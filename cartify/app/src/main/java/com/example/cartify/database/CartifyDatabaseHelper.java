package com.example.cartify.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CartifyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "cartify.db";
    public static final int DATABASE_VERSION = 1;

    // Users table
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "id";
    public static final String COLUMN_USER_FULL_NAME = "full_name";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_PASSWORD = "password";

    // Orders table
    public static final String TABLE_ORDERS = "orders";
    public static final String COLUMN_ORDER_ID = "id";
    public static final String COLUMN_ORDER_USER_ID = "user_id";
    public static final String COLUMN_ORDER_PRODUCT_NAME = "product_name";
    public static final String COLUMN_ORDER_PRICE = "price";
    public static final String COLUMN_ORDER_QUANTITY = "quantity";
    public static final String COLUMN_ORDER_DATE = "order_date";

    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_FULL_NAME + " TEXT NOT NULL, " +
                    COLUMN_USER_EMAIL + " TEXT NOT NULL UNIQUE, " +
                    COLUMN_USER_PASSWORD + " TEXT NOT NULL" +
                    ");";

    private static final String CREATE_TABLE_ORDERS =
            "CREATE TABLE " + TABLE_ORDERS + " (" +
                    COLUMN_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ORDER_USER_ID + " INTEGER NOT NULL, " +
                    COLUMN_ORDER_PRODUCT_NAME + " TEXT NOT NULL, " +
                    COLUMN_ORDER_PRICE + " REAL NOT NULL, " +
                    COLUMN_ORDER_QUANTITY + " INTEGER NOT NULL, " +
                    COLUMN_ORDER_DATE + " TEXT NOT NULL" +
                    ");";

    public CartifyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_ORDERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        onCreate(db);
    }
}
