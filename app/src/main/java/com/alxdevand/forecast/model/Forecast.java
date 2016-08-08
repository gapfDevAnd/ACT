package com.alxdevand.forecast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast implements Parcelable {
    @SerializedName("query")
    @Expose
    private Query query;

    /**
     *
     * @return
     * The query
     */
    public Query getQuery() {
        return query;
    }

    /**
     *
     * @param query
     * The query
     */
    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.query, flags);
    }

    public Forecast() {
    }

    protected Forecast(Parcel in) {
        this.query = in.readParcelable(Query.class.getClassLoader());
    }

    public static final Parcelable.Creator<Forecast> CREATOR = new Parcelable.Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel source) {
            return new Forecast(source);
        }

        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
}
