package com.example.android.fivewaystocookeggs.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class RecipeProvider extends ContentProvider {

    private static final UriMatcher sUriMatcher;
    private static final int RECIPES = 100;
    private static final int RECIPE = 101;

    private RecipeDataSource mDataSource;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = RecipeContract.CONTENT_AUTHORITY;
        sUriMatcher.addURI(authority, RecipeContract.PATH_RECIPES, RECIPES);
        sUriMatcher.addURI(authority, RecipeContract.PATH_RECIPES + "/#", RECIPE);
    }

    @Override
    public boolean onCreate() {
        mDataSource = new StringRecipeDataSource(getContext());
        return true;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case RECIPES:
                return RecipeContract.RecipeEntry.CONTENT_TYPE;
            case RECIPE:
                return RecipeContract.RecipeEntry.CONTENT_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown URI: " + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        final int match = sUriMatcher.match(uri);
        if (RECIPES == match) {
            return mDataSource.getRecipes();
        } else if (RECIPE == match) {
            final long id = Long.valueOf(uri.getPathSegments().get(1));
            return mDataSource.getRecipe(id);
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

}
