package com.alxdevand.forecast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Guid implements Parcelable {
    @SerializedName("isPermaLink")
    @Expose
    private String isPermaLink;

    /**
     *
     * @return
     * The isPermaLink
     */
    public String getIsPermaLink() {
        return isPermaLink;
    }

    /**
     *
     * @param isPermaLink
     * The isPermaLink
     */
    public void setIsPermaLink(String isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.isPermaLink);
    }

    public Guid() {
    }

    protected Guid(Parcel in) {
        this.isPermaLink = in.readString();
    }

    public static final Parcelable.Creator<Guid> CREATOR = new Parcelable.Creator<Guid>() {
        @Override
        public Guid createFromParcel(Parcel source) {
            return new Guid(source);
        }

        @Override
        public Guid[] newArray(int size) {
            return new Guid[size];
        }
    };
}
