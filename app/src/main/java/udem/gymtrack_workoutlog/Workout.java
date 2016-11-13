package udem.gymtrack_workoutlog;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import java.util.List;

/**
 * Created by victor on 13/11/16.
 */

public class Workout {

    private CalendarDay day;
    private List<Exercise> exercises;

    public Workout(CalendarDay day) {
        this.day = day;
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

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
