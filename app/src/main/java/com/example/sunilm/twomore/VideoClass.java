package com.example.sunilm.twomore;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sunilm on 5/3/2019.
 */

public class VideoClass implements Parcelable{
    String name;
    String description;
    public VideoClass(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public VideoClass() {

    }

    @Override
    public String toString() {
        return "VideoClass{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(description);
    }


    public static final Parcelable.Creator<VideoClass> CREATOR
            = new Parcelable.Creator<VideoClass>() {
        public VideoClass createFromParcel(Parcel in) {
            return new VideoClass(in);
        }

        public VideoClass[] newArray(int size) {
            return new VideoClass[size];
        }
    };

    public VideoClass(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
    }

}
