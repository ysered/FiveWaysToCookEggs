package com.example.android.fivewaystocookeggs.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AssetDatabaseHelper extends SQLiteOpenHelper {

    private final Context mContext;
    private final String mDatabaseName;
    private final String mDatabasePath;

    public AssetDatabaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
        mContext = context;
        mDatabaseName = name;
        // TODO: check context.getFilesDir().getPath()
        mDatabasePath = "/data/data/" + context.getPackageName() + "/databases/";
    }

    public boolean isDatabaseExists() {
        SQLiteDatabase database = null;
        try {
            database = SQLiteDatabase.openDatabase(mDatabasePath + mDatabaseName, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            Log.i(getClass().getName(), "Database doesn't exists");
        } catch (Exception e) {
            Log.i(getClass().getName(), "An error occurred: " + e.getMessage());
        }

        if (database != null) {
            database.close();
        }

        return database != null;
    }

    public void importDatabaseIfNotExists() throws IOException {
        boolean isExists = isDatabaseExists();
        if (!isExists) {
            getReadableDatabase(); // will create empty database
            try {
                copyDatabase();
            } catch (IOException e) {
                throw new IOException("Cannot copy database", e);
            }
        }
    }

    private void copyDatabase() throws IOException {
        InputStream inputStream = mContext.getAssets().open(mDatabaseName);
        OutputStream outputStream = new FileOutputStream(mDatabasePath + mDatabaseName);

        byte[] buffer = new byte[4096];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();

        close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}