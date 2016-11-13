package udem.gymtrack_workoutlog;

/**
 * Created by victor on 13/11/16.
 */

public class Exercise {

    private String category;
    private String name;
    private float weight;
    private byte repetitions;
    private byte series;
    private float distance;
    private String distanceUnit;
    private byte hours;
    private byte minutes;
    private byte seconds;

    //Empty excercise
    public Exercise() {
    }

    //Weight exercise
    public Exercise(String category, String name, float weight, byte repetitions, byte series) {
        this.category = category;
        this.name = name;
        this.weight = weight;
        this.repetitions = repetitions;
        this.series = series;
    }

    //Cardio exercise
    public Exercise(String category, String name, float distance, String distanceUnit, byte hours, byte minutes, byte seconds) {
        this.category = category;
        this.name = name;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //Getters and Setters

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public byte getSeries() {
        return series;
    }

    public void setSeries(byte series) {
        this.series = series;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public byte getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(byte repetitions) {
        this.repetitions = repetitions;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public byte getHours() {
        return hours;
    }

    public void setHours(byte hours) {
        this.hours = hours;
    }

    public byte getMinutes() {
        return minutes;
    }

    public void setMinutes(byte minutes) {
        this.minutes = minutes;
    }

    public byte getSeconds() {
        return seconds;
    }

    public void setSeconds(byte seconds) {
        this.seconds = seconds;
    }
}
