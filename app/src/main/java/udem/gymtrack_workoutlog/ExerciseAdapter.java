package udem.gymtrack_workoutlog;

/**
 * Created by victor on 29/11/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.MyViewHolder> {

    private List<Exercise> exerciseList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, dataOne, dataTwo;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.exersiceNameTextView);
            dataOne = (TextView) view.findViewById(R.id.exersiceFirstDataTextView);
            dataTwo = (TextView) view.findViewById(R.id.exersiceSecondDataTextView);
        }
    }


    public ExerciseAdapter(List<Exercise> moviesList) {
        this.exerciseList = exerciseList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_exersice, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        if(exercise.getCategory().equals("Cardio")){
            holder.name.setText(exercise.getName());
            String distance = exercise.getDistance() + "km";
            holder.dataOne.setText(distance);
            String time = exercise.getHours() + "hr "+exercise.getMinutes() + "min" + exercise.getSeconds() + "sec";
            holder.dataTwo.setText(time);
        }else{
            holder.name.setText(exercise.getName());
            holder.dataOne.setText((int) exercise.getWeight());
            holder.dataTwo.setText(exercise.getRepetitions());
        }

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}