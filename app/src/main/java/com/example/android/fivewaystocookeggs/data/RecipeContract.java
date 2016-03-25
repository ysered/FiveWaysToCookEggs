package com.example.android.fivewaystocookeggs.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class RecipeContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.fivewaystocookeggs";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_RECIPES = "recipes";

    public static final class RecipeEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_RECIPES).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + PATH_RECIPES;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + PATH_RECIPES;

        public static final String COLUMN_IMAGE_RESOURCE = "image_resource";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_INGREDIENTS_SHORT = "ingredients_line";
        public static final String COLUMN_INGREDIENTS = "ingredient_id";
        public static final String COLUMN_DETAILS = "details";

        public static final Uri getContentUriForRecipe(long id) {
            return CONTENT_URI.buildUpon().appendPath(Long.toString(id)).build();
        }

    }

}
