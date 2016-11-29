package udem.gymtrack_workoutlog;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 13/11/16.
 */

public class Exercise implements Parcelable {

    private String category;
    private String name;
    private float weight;
    private byte repetitions;
    private byte series;
    private float distance;
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
    public Exercise(String category, String name, float distance, byte hours, byte minutes, byte seconds) {
        this.category = category;
        this.name = name;
        this.distance = distance;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //Getters and Setters

    protected Exercise(Parcel in) {
        category = in.readString();
        name = in.readString();
        weight = in.readFloat();
        repetitions = in.readByte();
        series = in.readByte();
        distance = in.readFloat();
        hours = in.readByte();
        minutes = in.readByte();
        seconds = in.readByte();
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(category);
        parcel.writeString(name);
        parcel.writeFloat(weight);
        parcel.writeByte(repetitions);
        parcel.writeByte(series);
        parcel.writeFloat(distance);
        parcel.writeByte(hours);
        parcel.writeByte(minutes);
        parcel.writeByte(seconds);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", repetitions=" + repetitions +
                ", series=" + series +
                ", distance=" + distance +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
