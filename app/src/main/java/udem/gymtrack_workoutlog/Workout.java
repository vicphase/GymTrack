package udem.gymtrack_workoutlog;

import android.os.Parcel;
import android.os.Parcelable;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by victor on 13/11/16.
 */

public class Workout{

    private CalendarDay day;
    private LinkedList<Exercise> exercises;

    public Workout() {
        this.exercises = new LinkedList<Exercise>();
    }

    public Workout(CalendarDay day) {
        this.day = day;
        this.exercises = new LinkedList<Exercise>();
    }


    public CalendarDay getDay() {
        return day;
    }

    public void setDay(CalendarDay day) {
        this.day = day;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(LinkedList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setExercise(Exercise exercise){
        this.exercises.add(exercise);
    }

    public Exercise getExercise(int i){
        if(i>this.exercises.size()-1){
            return null;
        }else
            return this.exercises.get(i);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "day=" + day +
                ", exercises=" + exercises +
                '}';
    }
}
