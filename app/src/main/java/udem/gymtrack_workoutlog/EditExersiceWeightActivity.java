package udem.gymtrack_workoutlog;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;

public class EditExersiceWeightActivity extends AppCompatActivity {

    //Global variables
    EditText editTextName;
    EditText editTextWeight;
    EditText editTextRepetitions;
    EditText editTextSeries;
    String category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exersice_weight);
        editTextName = (EditText) findViewById(R.id.editTextNameWeight);
        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        editTextRepetitions = (EditText) findViewById(R.id.editTextRepetitions);
        editTextSeries = (EditText) findViewById(R.id.editTextSeries);
        Bundle extras = getIntent().getExtras();
        category = extras.getString("Category");
        setFilters();
    }

    public void setFilters(){
        editTextRepetitions.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "1000")});
        editTextSeries.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "1000")});
    }

    public boolean validateForm(){
        boolean flag = true;
        //Validate name
        if(editTextName.getText().toString().trim().equals("")){
            editTextName.setError( "Name is required!" );
            flag=false;
        }
        //Validate Repetitions
        if(editTextRepetitions.getText().toString().trim().equals("")){
            editTextRepetitions.setError( "Repetitions is required!" );
            flag=false;
        }
        //Validate Series
        if(editTextSeries.getText().toString().trim().equals("")){
            editTextSeries.setError( "Series is required!" );
            flag=false;
        }
        return flag;
    }
    public Exercise createExersice(){
        Exercise exercise = new Exercise();
        //Set name
        exercise.setName(editTextName.getText().toString());
        //Set category
        exercise.setCategory(category);
        //Set Hours
        if(editTextWeight.getText().toString().trim().equals("")){
            exercise.setWeight((byte) 0);
        }else{
            exercise.setWeight(Byte.parseByte(editTextWeight.getText().toString()));
        }
        //Set Repetitions
        exercise.setRepetitions(Byte.parseByte(editTextRepetitions.getText().toString()));
        //Set Series
        exercise.setSeries(Byte.parseByte(editTextSeries.getText().toString()));


        System.out.println("Ejercicio "+exercise.toString());
        return exercise;
    }

    public void saveExersice(View view){
        if(validateForm()){
            Intent intent = new Intent();
            intent.putExtra("Exersice", createExersice());
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
