package udem.gymtrack_workoutlog;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;

public class EditExersiceCardioActivity extends AppCompatActivity {


    EditText editTextName;
    EditText editTextDistance;
    EditText editTextHours;
    EditText editTextMinutes;
    EditText editTextSeconds;
    EditText editTextTime;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exersice_cardio);
        editTextName = (EditText) findViewById(R.id.editTextNameCardio);
        editTextDistance = (EditText) findViewById(R.id.editTextDistance);
        editTextHours = (EditText) findViewById(R.id.editTextHours);
        editTextMinutes = (EditText) findViewById(R.id.editTextMinutes);
        editTextSeconds = (EditText) findViewById(R.id.editTextSeconds);
        editTextTime = (EditText) findViewById(R.id.editTextTime);
        Bundle extras = getIntent().getExtras();
        category = extras.getString("Category");
        setFilters();
    }

    public void setFilters(){
        editTextDistance.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "42")});
        editTextHours.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "24")});
        editTextMinutes.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "59")});
        editTextSeconds.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "59")});
    }

    public boolean validateForm(){
        boolean flag = true;
        //Validate name
       if(editTextName.getText().toString().trim().equals("")){
            editTextName.setError( "Name is required!" );
           flag=false;
    }
        //Validate distance or time
        if(!(editTextDistance.getText().toString().trim().equals("") ||
                (editTextSeconds.getText().toString().trim().equals("")) ||
                (editTextMinutes.getText().toString().trim().equals("")) ||
                (editTextHours.getText().toString().trim().equals("")))){
           editTextDistance.setError("Distance or time is required!");
            editTextTime.setError("Distance or time is required!");
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
        if(editTextHours.getText().toString().trim().equals("")){
            exercise.setHours((byte) 0);
        }else{
            exercise.setHours(Byte.parseByte(editTextHours.getText().toString()));
        }
        //Set minutes
        if(editTextMinutes.getText().toString().trim().equals("")){
            exercise.setMinutes((byte) 0);
        }else{
            exercise.setMinutes(Byte.parseByte(editTextMinutes.getText().toString()));
        }
        //Set seconds
        if(editTextSeconds.getText().toString().trim().equals("")){
            exercise.setSeconds((byte) 0);
        }else{
            exercise.setSeconds(Byte.parseByte(editTextSeconds.getText().toString()));
        }
        //Set distance
        if(editTextDistance.getText().toString().trim().equals("")){
            exercise.setDistance((byte) 0);
        }else{
            exercise.setDistance(Float.parseFloat(editTextDistance.getText().toString()));
        }
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
