package com.example.sunilm.twomore;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by sunilm on 5/24/2019.
 */

public class User implements Parcelable {


    String name;
    String age;
   ArrayList<String> videosSubscribed;
    ArrayList<String> storiesSubscribed;
    ArrayList<String> storiesLoaded;
    ArrayList<String> videosLoaded;

    public User(String name, String age, ArrayList<String> videosSubscribed, ArrayList<String> storiesSubscribed, ArrayList<String> storiesLoaded, ArrayList<String> videosLoaded) {
        this.name = name;
        this.age = age;
        this.videosSubscribed = videosSubscribed;
        this.storiesSubscribed = storiesSubscribed;
        this.storiesLoaded = storiesLoaded;
        this.videosLoaded = videosLoaded;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.age);
        dest.writeStringList(this.videosSubscribed);
        dest.writeStringList(this.storiesSubscribed);
        dest.writeStringList(this.storiesLoaded);
        dest.writeStringList(this.videosLoaded);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.age = in.readString();
        this.videosSubscribed = in.createStringArrayList();
        this.storiesSubscribed = in.createStringArrayList();
        this.storiesLoaded = in.createStringArrayList();
        this.videosLoaded = in.createStringArrayList();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<String> getVideosSubscribed() {
        return videosSubscribed;
    }

    public void setVideosSubscribed(ArrayList<String> videosSubscribed) {
        this.videosSubscribed = videosSubscribed;
    }

    public ArrayList<String> getStoriesSubscribed() {
        return storiesSubscribed;
    }

    public void setStoriesSubscribed(ArrayList<String> storiesSubscribed) {
        this.storiesSubscribed = storiesSubscribed;
    }

    public ArrayList<String> getStoriesLoaded() {
        return storiesLoaded;
    }

    public void setStoriesLoaded(ArrayList<String> storiesLoaded) {
        this.storiesLoaded = storiesLoaded;
    }

    public ArrayList<String> getVideosLoaded() {
        return videosLoaded;
    }

    public void setVideosLoaded(ArrayList<String> videosLoaded) {
        this.videosLoaded = videosLoaded;
    }
}
