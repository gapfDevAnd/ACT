package com.alxdevand.forecast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astronomy implements Parcelable {
    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;

    /**
     *
     * @return
     * The sunrise
     */
    public String getSunrise() {
        return sunrise;
    }

    /**
     *
     * @param sunrise
     * The sunrise
     */
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    /**
     *
     * @return
     * The sunset
     */
    public String getSunset() {
        return sunset;
    }

    /**
     *
     * @param sunset
     * The sunset
     */
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sunrise);
        dest.writeString(this.sunset);
    }

    public Astronomy() {
    }

    protected Astronomy(Parcel in) {
        this.sunrise = in.readString();
        this.sunset = in.readString();
    }

    public static final Parcelable.Creator<Astronomy> CREATOR = new Parcelable.Creator<Astronomy>() {
        @Override
        public Astronomy createFromParcel(Parcel source) {
            return new Astronomy(source);
        }

        @Override
        public Astronomy[] newArray(int size) {
            return new Astronomy[size];
        }
    };
}
