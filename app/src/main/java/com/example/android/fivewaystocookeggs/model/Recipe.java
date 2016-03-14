package com.example.android.fivewaystocookeggs.model;


public class Recipe {

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

}
