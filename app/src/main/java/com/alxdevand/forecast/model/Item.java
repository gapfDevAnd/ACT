package com.alxdevand.forecast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Item implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("pubDate")
    @Expose
    private String pubDate;
    @SerializedName("condition")
    @Expose
    private Condition condition;
    @SerializedName("forecast")
    @Expose
    private List<ForecastSpecification> forecast = new ArrayList<>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("guid")
    @Expose
    private Guid guid;

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The _long
     */
    public String getLong() {
        return _long;
    }

    /**
     *
     * @param _long
     * The long
     */
    public void setLong(String _long) {
        this._long = _long;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The pubDate
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     *
     * @param pubDate
     * The pubDate
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     *
     * @return
     * The condition
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     *
     * @param condition
     * The condition
     */
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    /**
     *
     * @return
     * The forecast
     */
    public List<ForecastSpecification> getForecast() {
        return forecast;
    }

    /**
     *
     * @param forecast
     * The forecast
     */
    public void setForecast(List<ForecastSpecification> forecast) {
        this.forecast = forecast;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The guid
     */
    public Guid getGuid() {
        return guid;
    }

    /**
     *
     * @param guid
     * The guid
     */
    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.lat);
        dest.writeString(this._long);
        dest.writeString(this.link);
        dest.writeString(this.pubDate);
        dest.writeParcelable(this.condition, flags);
        dest.writeTypedList(this.forecast);
        dest.writeString(this.description);
        dest.writeParcelable(this.guid, flags);
    }

    public Item() {
    }

    protected Item(Parcel in) {
        this.title = in.readString();
        this.lat = in.readString();
        this._long = in.readString();
        this.link = in.readString();
        this.pubDate = in.readString();
        this.condition = in.readParcelable(Condition.class.getClassLoader());
        this.forecast = in.createTypedArrayList(ForecastSpecification.CREATOR);
        this.description = in.readString();
        this.guid = in.readParcelable(Guid.class.getClassLoader());
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
