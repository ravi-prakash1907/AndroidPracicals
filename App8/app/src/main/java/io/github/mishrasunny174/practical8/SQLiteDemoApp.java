package io.github.mishrasunny174.practical8;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteDemoApp extends Application {

    SQLiteDatabase database;
    DatabaseHelper dbHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        dbHelper = new DatabaseHelper(getApplicationContext());
        database = dbHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDatabase()
    {
        return database;
    }
}
