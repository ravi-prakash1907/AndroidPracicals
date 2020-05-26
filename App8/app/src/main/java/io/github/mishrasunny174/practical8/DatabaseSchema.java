package io.github.mishrasunny174.practical8;

import android.provider.BaseColumns;

public final class DatabaseSchema{

    public static final String DATABASE_NAME = "users.db";
    public static final int DATABASE_VERSION = 1;
    private DatabaseSchema(){}

    public static class TableSchema implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }

    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS "+TableSchema.TABLE_NAME + "( "
                                                    +TableSchema._ID + " INTEGER PRIMARY KEY,"
                                                    +TableSchema.COLUMN_NAME_USERNAME + " VARCHAR,"
                                                    +TableSchema.COLUMN_NAME_PASSWORD + " VARCHAR )";
    public static final String DELETE_TABLE_QUERY = "DROP TABLE "+"IF EXISTS "+TableSchema.TABLE_NAME;
}
