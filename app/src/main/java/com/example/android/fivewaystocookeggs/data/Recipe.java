package com.example.android.fivewaystocookeggs.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {

    public final int imageResource;
    public final String title;
    public final String ingredientsLine;
    public final String ingredients;
    public final String details;

    public Recipe(int imageResource, String title, String ingredientsLine, String ingredients,
                  String details) {
        this.imageResource = imageResource;
        this.title = title;
        this.ingredientsLine = ingredientsLine;
        this.ingredients = ingredients;
        this.details = details;
    }

    protected Recipe(Parcel in) {
        imageResource = in.readInt();
        title = in.readString();
        ingredientsLine = in.readString();
        ingredients = in.readString();
        details = in.readString();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {

        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResource);
        dest.writeString(title);
        dest.writeString(ingredientsLine);
        dest.writeString(ingredients);
        dest.writeString(details);
    }

}
