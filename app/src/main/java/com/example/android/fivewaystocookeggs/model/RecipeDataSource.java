package com.example.android.fivewaystocookeggs.model;


import android.content.Context;

import com.example.android.fivewaystocookeggs.R;

public class RecipeDataSource {

    private final Context mContext;

    public RecipeDataSource(Context context) {
        mContext = context;
    }

    public Recipe[] getRecipes() {
        return new Recipe[] {
                new Recipe(
                        R.drawable.egg_in_bread,
                        mContext.getString(R.string.eggs_in_bread),
                        mContext.getString(R.string.eggs_in_bread_ingredients_line),
                        mContext.getString(R.string.eggs_in_bread_ingredients),
                        mContext.getString(R.string.eggs_in_bread_details)
                ),
                new Recipe(
                        R.drawable.french_eggs,
                        mContext.getString(R.string.french_eggs),
                        mContext.getString(R.string.french_eggs_ingredients_line),
                        mContext.getString(R.string.french_eggs_ingredients),
                        mContext.getString(R.string.french_eggs_details)
                ),
                new Recipe(
                        R.drawable.eggs_in_tomatoes,
                        mContext.getString(R.string.eggs_in_tomatoes),
                        mContext.getString(R.string.eggs_in_tomatoes_ingredients_line),
                        mContext.getString(R.string.eggs_in_tomatoes_ingredients),
                        mContext.getString(R.string.eggs_in_tomatoes_details)
                ),
                new Recipe(
                        R.drawable.eggs_in_baskets,
                        mContext.getString(R.string.eggs_in_baskets),
                        mContext.getString(R.string.eggs_in_baskets_ingredients_line),
                        mContext.getString(R.string.eggs_in_baskets_ingredients),
                        mContext.getString(R.string.eggs_in_baskets_details)
                ),
                new Recipe(
                        R.drawable.eggs_by_author,
                        mContext.getString(R.string.eggs_by_author),
                        mContext.getString(R.string.eggs_by_author_ingredients_line),
                        mContext.getString(R.string.eggs_by_author_ingredients),
                        mContext.getString(R.string.eggs_by_author_details)
                )
        };
    }

}
