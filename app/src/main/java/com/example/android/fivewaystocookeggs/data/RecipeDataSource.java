package com.example.android.fivewaystocookeggs.data;

import android.database.Cursor;

/**
 * Interface to interact with recipes data.
 */
public interface RecipeDataSource {

    /**
     * Reads recipes from specific data source.
     *
     * @return array of Recipe entries
     */
    Cursor getRecipes();

    /**
     * Returns recipe with specific ID.
     *
     * @param id
     *
     * @return recipe entry
     */
    Cursor getRecipe(long id);

}
