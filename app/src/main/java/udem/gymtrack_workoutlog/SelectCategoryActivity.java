package udem.gymtrack_workoutlog;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectCategoryActivity extends AppCompatActivity {

    //Global variables
    Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
    }

public void onClick(View view){
    String tag = (String) view.getTag();
    if(tag.equals("Cardio")){
        Intent intent = new Intent(this, EditExersiceCardioActivity.class);
        intent.putExtra("Category", tag);
        startActivityForResult(intent,777);
    }else{
        Intent intent = new Intent(this, EditExersiceWeightActivity.class);
        intent.putExtra("Category", tag);
        startActivityForResult(intent, 777);
    }
}

    @Override
    protected void onActivityResult (int requestCode,
                                     int resultCode, Intent data){
        if (requestCode==777 && resultCode==RESULT_OK) {
            Exercise exercise = (Exercise) data.getExtras().get("Exersice");
            System.out.println("Se creo el ejercicio! "+exercise.toString());
            Intent intent = new Intent();
            intent.putExtra("Exersice", exercise);
            setResult(RESULT_OK, intent);
            finish();
        }}

}
