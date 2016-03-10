package com.example.android.fivewaystocookeggs.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.fivewaystocookeggs.Recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipesDataSource {

    private static final String DATABASE_NAME = "five_recipes.db";
    private static final int DATABASE_VERSION = 1;

    private final SQLiteDatabase mDatabase;

    public RecipesDataSource(Context context) throws IOException {
        AssetDatabaseHelper helper = new AssetDatabaseHelper(context, DATABASE_NAME, DATABASE_VERSION);
        helper.importDatabaseIfNotExists();
        mDatabase = helper.getWritableDatabase();
    }

    public List<Recipe> getRecipes() {
        final String query = "SELECT id, image_name, title FROM recipe";
        final Cursor cursor = mDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        List<Recipe> recipes = new ArrayList<>(cursor.getCount());
        while(!cursor.isAfterLast()) {
            Recipe recipe = new Recipe();
            recipe.setId(cursor.getInt(0));
            recipe.setImageName(cursor.getString(1));
            recipe.setTitle(cursor.getString(2));
            recipes.add(recipe);
            cursor.moveToNext();
        }
        cursor.close();

        for (Recipe recipe : recipes) {
            recipe.setIngredients(fetchIngredients(recipe.getId()));
            recipe.setDirections(fetchDirections(recipe.getId()));
        }

        return recipes;
    }

    private List<String> fetchIngredients(long recipeId) {
        final String query = "SELECT text FROM ingredient WHERE recipe_id = ? ORDER BY position ASC";
        final String[] selectionArgs = { String.valueOf(recipeId) };
        final Cursor cursor = mDatabase.rawQuery(query, selectionArgs);
        cursor.moveToFirst();

        List<String> ingredients = new ArrayList<>(cursor.getCount());
        while(!cursor.isAfterLast()) {
            ingredients.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();

        return ingredients;
    }

    private List<String> fetchDirections(long recipeId) {
        final String query = "SELECT text FROM direction WHERE recipe_id = ? ORDER BY position ASC";
        final String[] selectionArgs = { String.valueOf(recipeId) };
        final Cursor cursor = mDatabase.rawQuery(query, selectionArgs);
        cursor.moveToFirst();

        List<String> directions = new ArrayList<>(cursor.getCount());
        while(!cursor.isAfterLast()) {
            directions.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();

        return directions;
    }

}
