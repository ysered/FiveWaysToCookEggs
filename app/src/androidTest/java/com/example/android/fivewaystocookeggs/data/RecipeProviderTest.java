package com.example.android.fivewaystocookeggs.data;

import android.content.Context;
import android.database.Cursor;
import android.test.AndroidTestCase;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.data.RecipeContract.RecipeEntry;

public class RecipeProviderTest extends AndroidTestCase {

    private Object[][] getExpectedEntries(Context context) {
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

    // TODO: optimize tests
    public void testRecipeEntries() {
        final Cursor cursor = mContext.getContentResolver()
                .query(RecipeEntry.CONTENT_URI, null, null, null, null);
        assertNotNull("Cursor object shouldn't be null", cursor);

        try {
            final int idIndex = cursor.getColumnIndex(RecipeEntry._ID);
            final int imageResIndex = cursor.getColumnIndex(RecipeEntry.COLUMN_IMAGE_RESOURCE);
            final int titleIndex = cursor.getColumnIndex(RecipeEntry.COLUMN_TITLE);
            final int ingredientsShortIndex =
                    cursor.getColumnIndex(RecipeEntry.COLUMN_INGREDIENTS_SHORT);
            final int ingredientsIndex = cursor.getColumnIndex(RecipeEntry.COLUMN_INGREDIENTS);
            final int detailsIndex = cursor.getColumnIndex(RecipeEntry.COLUMN_DETAILS);

            int actualId;
            int actualImageResource;
            String actualTitle;
            String actualIngredientsShort;
            String actualIngredients;
            String actualDetails;

            final Object[][] expectedEntries = getExpectedEntries(mContext);

            int i = 0;
            while (cursor.moveToNext()) {
                actualId = cursor.getInt(idIndex);
                assertEquals("IDs should be equal", actualId, expectedEntries[i][0]);

                actualImageResource = cursor.getInt(imageResIndex);
                assertEquals("Image resource IDs should be equal", actualImageResource,
                        expectedEntries[i][1]);

                actualTitle = cursor.getString(titleIndex);
                assertEquals("Titles should be equal", actualTitle, expectedEntries[i][2]);

                actualIngredientsShort = cursor.getString(ingredientsShortIndex);
                assertEquals("Ingredient short texts should be equal", actualIngredientsShort,
                        expectedEntries[i][3]);

                actualIngredients = cursor.getString(ingredientsIndex);
                assertEquals("Ingredient short texts should be equal", actualIngredients,
                        expectedEntries[i][4]);

                actualDetails = cursor.getString(detailsIndex);
                assertEquals("Details should be equal", actualDetails, expectedEntries[i][5]);

                i++;
            }
        } finally {
            cursor.close();
        }
    }

    public void testRecipeById() {
        final Cursor cursor = mContext.getContentResolver()
                .query(RecipeEntry.getContentUriForRecipe(1), null, null, null, null);
        assertNotNull("Cursor object shouldn't be null", cursor);

        cursor.moveToFirst();

        final int idIndex = cursor.getColumnIndex(RecipeEntry._ID);
        final int imageResIndex = cursor.getColumnIndex(RecipeEntry.COLUMN_IMAGE_RESOURCE);
        final int titleIndex = cursor.getColumnIndex(RecipeEntry.COLUMN_TITLE);
        final int ingredientsShortIndex =
                cursor.getColumnIndex(RecipeEntry.COLUMN_INGREDIENTS_SHORT);
        final int ingredientsIndex = cursor.getColumnIndex(RecipeEntry.COLUMN_INGREDIENTS);
        final int detailsIndex = cursor.getColumnIndex(RecipeEntry.COLUMN_DETAILS);

        final Object[][] expectedEntries = getExpectedEntries(mContext);

        int actualId = cursor.getInt(idIndex);
        assertEquals("IDs should be equal", actualId, expectedEntries[0][0]);

        int actualImageResource = cursor.getInt(imageResIndex);
        assertEquals("Image resource IDs should be equal", actualImageResource,
                expectedEntries[0][1]);

        String actualTitle = cursor.getString(titleIndex);
        assertEquals("Titles should be equal", actualTitle, expectedEntries[0][2]);

        String actualIngredientsShort = cursor.getString(ingredientsShortIndex);
        assertEquals("Ingredient short texts should be equal", actualIngredientsShort,
                expectedEntries[0][3]);

        String actualIngredients = cursor.getString(ingredientsIndex);
        assertEquals("Ingredient short texts should be equal", actualIngredients,
                expectedEntries[0][4]);

        String actualDetails = cursor.getString(detailsIndex);
        assertEquals("Details should be equal", actualDetails, expectedEntries[0][5]);

        cursor.close();
    }

}
