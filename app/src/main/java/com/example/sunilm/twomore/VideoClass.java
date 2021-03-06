package com.example.sunilm.twomore;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sunilm on 5/3/2019.
 */

public class VideoClass implements Parcelable{
    String name;
    String description;
    String  URL;
    Bitmap bitmap;

    public VideoClass(String name, String description, String URL,Bitmap bitmap) {
        this.name = name;
        this.description = description;
        this.URL = URL;
        this.bitmap = bitmap;
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
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.URL);
        dest.writeParcelable(this.bitmap, flags);
    }

    protected VideoClass(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.URL = in.readString();
        this.bitmap = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<VideoClass> CREATOR = new Creator<VideoClass>() {
        @Override
        public VideoClass createFromParcel(Parcel source) {
            return new VideoClass(source);
        }

        @Override
        public VideoClass[] newArray(int size) {
            return new VideoClass[size];
        }
    };
}
