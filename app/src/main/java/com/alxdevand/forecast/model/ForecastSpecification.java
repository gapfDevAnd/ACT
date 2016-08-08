package com.alxdevand.forecast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastSpecification implements Parcelable {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("high")
    @Expose
    private String high;
    @SerializedName("low")
    @Expose
    private String low;
    @SerializedName("text")
    @Expose
    private String text;

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The day
     */
    public String getDay() {
        return day;
    }

    /**
     *
     * @param day
     * The day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     *
     * @return
     * The high
     */
    public String getHigh() {
        return high;
    }

    /**
     *
     * @param high
     * The high
     */
    public void setHigh(String high) {
        this.high = high;
    }

    /**
     *
     * @return
     * The low
     */
    public String getLow() {
        return low;
    }

    /**
     *
     * @param low
     * The low
     */
    public void setLow(String low) {
        this.low = low;
    }

    /**
     *
     * @return
     * The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.date);
        dest.writeString(this.day);
        dest.writeString(this.high);
        dest.writeString(this.low);
        dest.writeString(this.text);
    }

    public ForecastSpecification() {
    }

    protected ForecastSpecification(Parcel in) {
        this.code = in.readString();
        this.date = in.readString();
        this.day = in.readString();
        this.high = in.readString();
        this.low = in.readString();
        this.text = in.readString();
    }

    public static final Parcelable.Creator<ForecastSpecification> CREATOR = new Parcelable.Creator<ForecastSpecification>() {
        @Override
        public ForecastSpecification createFromParcel(Parcel source) {
            return new ForecastSpecification(source);
        }

        @Override
        public ForecastSpecification[] newArray(int size) {
            return new ForecastSpecification[size];
        }
    };
}
