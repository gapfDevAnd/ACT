package com.alxdevand.forecast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Units implements Parcelable {
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("temperature")
    @Expose
    private String temperature;

    /**
     *
     * @return
     * The distance
     */
    public String getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     * The pressure
     */
    public String getPressure() {
        return pressure;
    }

    /**
     *
     * @param pressure
     * The pressure
     */
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    /**
     *
     * @return
     * The speed
     */
    public String getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed
     * The speed
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     *
     * @return
     * The temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     *
     * @param temperature
     * The temperature
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.distance);
        dest.writeString(this.pressure);
        dest.writeString(this.speed);
        dest.writeString(this.temperature);
    }

    public Units() {
    }

    protected Units(Parcel in) {
        this.distance = in.readString();
        this.pressure = in.readString();
        this.speed = in.readString();
        this.temperature = in.readString();
    }

    public static final Parcelable.Creator<Units> CREATOR = new Parcelable.Creator<Units>() {
        @Override
        public Units createFromParcel(Parcel source) {
            return new Units(source);
        }

        @Override
        public Units[] newArray(int size) {
            return new Units[size];
        }
    };
}
