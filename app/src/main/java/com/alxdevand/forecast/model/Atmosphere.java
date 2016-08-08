package com.alxdevand.forecast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Atmosphere implements Parcelable {
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("rising")
    @Expose
    private String rising;
    @SerializedName("visibility")
    @Expose
    private String visibility;

    /**
     *
     * @return
     * The humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     *
     * @param humidity
     * The humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
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
     * The rising
     */
    public String getRising() {
        return rising;
    }

    /**
     *
     * @param rising
     * The rising
     */
    public void setRising(String rising) {
        this.rising = rising;
    }

    /**
     *
     * @return
     * The visibility
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     *
     * @param visibility
     * The visibility
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.humidity);
        dest.writeString(this.pressure);
        dest.writeString(this.rising);
        dest.writeString(this.visibility);
    }

    public Atmosphere() {
    }

    protected Atmosphere(Parcel in) {
        this.humidity = in.readString();
        this.pressure = in.readString();
        this.rising = in.readString();
        this.visibility = in.readString();
    }

    public static final Parcelable.Creator<Atmosphere> CREATOR = new Parcelable.Creator<Atmosphere>() {
        @Override
        public Atmosphere createFromParcel(Parcel source) {
            return new Atmosphere(source);
        }

        @Override
        public Atmosphere[] newArray(int size) {
            return new Atmosphere[size];
        }
    };
}
