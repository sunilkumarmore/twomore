package com.example.sunilm.twomore;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sunilm on 5/14/2019.
 */


public class StoriesClass implements Parcelable {
    String name;
    String description;
    String  URL;

    public Drawable getBitmap() {
        return bitmap;
    }

    public void setBitmap(Drawable bitmap) {
        this.bitmap = bitmap;
    }

    Drawable bitmap;


/*    nn.add(BitmapFactory.decodeResource(this.getResources(), R.mipmap.image1));
        nn.add(BitmapFactory.decodeResource(this.getResources(), R.mipmap.image2));
        nn.add(BitmapFactory.decodeResource(this.getResources(), R.mipmap.image3));
        nn.add(BitmapFactory.decodeResource(this.getResources(), R.mipmap.image4));
        nn.add(BitmapFactory.decodeResource(this.getResources(), R.mipmap.image5));*/
    public StoriesClass(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public StoriesClass() {

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
        dest.writeParcelable((Parcelable) this.bitmap, flags);
    }

    protected StoriesClass(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.URL = in.readString();
        this.bitmap = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<StoriesClass> CREATOR = new Creator<StoriesClass>() {
        @Override
        public StoriesClass createFromParcel(Parcel source) {
            return new StoriesClass(source);
        }

        @Override
        public StoriesClass[] newArray(int size) {
            return new StoriesClass[size];
        }
    };
}
