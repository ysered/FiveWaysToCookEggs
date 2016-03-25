package com.example.android.fivewaystocookeggs.data;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;

import com.example.android.fivewaystocookeggs.R;

/**
 * Reads recipe entries from string resources.
 */
public class StringRecipeDataSource implements RecipeDataSource {

    private static final String[] COLUMN_NAMES = {
            RecipeContract.RecipeEntry._ID,
            RecipeContract.RecipeEntry.COLUMN_IMAGE_RESOURCE,
            RecipeContract.RecipeEntry.COLUMN_TITLE,
            RecipeContract.RecipeEntry.COLUMN_INGREDIENTS_SHORT,
            RecipeContract.RecipeEntry.COLUMN_INGREDIENTS,
            RecipeContract.RecipeEntry.COLUMN_DETAILS
    };
    private static final int ID_COLUMN_INDEX = 0;

    private final Object[][] mRecipes;

    public StringRecipeDataSource(Context context) {
        mRecipes = getRecipesFromResources(context);
    }

    private Object[][] getRecipesFromResources(Context context) {
        return new Object[][] {
                new Object[] {
                        1,
                        R.drawable.egg_in_bread,
                        context.getString(R.string.eggs_in_bread),
                        context.getString(R.string.eggs_in_bread_ingredients_line),
                        context.getString(R.string.eggs_in_bread_ingredients),
                        context.getString(R.string.eggs_in_bread_details)
                },
                new Object[]{
                        2,
                        R.drawable.french_eggs,
                        context.getString(R.string.french_eggs),
                        context.getString(R.string.french_eggs_ingredients_line),
                        context.getString(R.string.french_eggs_ingredients),
                        context.getString(R.string.french_eggs_details)
                },
                new Object[]{
                        3,
                        R.drawable.eggs_in_tomatoes,
                        context.getString(R.string.eggs_in_tomatoes),
                        context.getString(R.string.eggs_in_tomatoes_ingredients_line),
                        context.getString(R.string.eggs_in_tomatoes_ingredients),
                        context.getString(R.string.eggs_in_tomatoes_details)
                },
                new Object[] {
                        4,
                        R.drawable.eggs_in_baskets,
                        context.getString(R.string.eggs_in_baskets),
                        context.getString(R.string.eggs_in_baskets_ingredients_line),
                        context.getString(R.string.eggs_in_baskets_ingredients),
                        context.getString(R.string.eggs_in_baskets_details)
                },
                new Object[] {
                        5,
                        R.drawable.eggs_by_author,
                        context.getString(R.string.eggs_by_author),
                        context.getString(R.string.eggs_by_author_ingredients_line),
                        context.getString(R.string.eggs_by_author_ingredients),
                        context.getString(R.string.eggs_by_author_details)
                }
        };
    }

    @Override
    public Cursor getRecipes() {
        MatrixCursor cursor = new MatrixCursor(COLUMN_NAMES, mRecipes.length);
        for (int i = 0; i < mRecipes.length; i++) {
            cursor.addRow(mRecipes[i]);
        }
        return cursor;
    }

    @Override
    public Cursor getRecipe(long id) {
        for (int i = 0; i < mRecipes.length; i++) {
            if (Long.valueOf(mRecipes[i][ID_COLUMN_INDEX].toString()) == id) {
                MatrixCursor cursor = new MatrixCursor(COLUMN_NAMES, 1);
                cursor.addRow(mRecipes[i]);
                return cursor;
            }
        }
        return null;
    }

}
