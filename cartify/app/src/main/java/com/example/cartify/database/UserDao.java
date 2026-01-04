package com.example.cartify.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cartify.models.User;

public class UserDao {

    private final CartifyDatabaseHelper dbHelper;

    public UserDao(Context context) {
        dbHelper = new CartifyDatabaseHelper(context);
    }

    public long insertUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CartifyDatabaseHelper.COLUMN_USER_FULL_NAME, user.getFullName());
        values.put(CartifyDatabaseHelper.COLUMN_USER_EMAIL, user.getEmail());
        values.put(CartifyDatabaseHelper.COLUMN_USER_PASSWORD, user.getPassword());
        long id = db.insert(CartifyDatabaseHelper.TABLE_USERS, null, values);
        db.close();
        return id;
    }

    public boolean isUserExists(String email) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {CartifyDatabaseHelper.COLUMN_USER_ID};
        String selection = CartifyDatabaseHelper.COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(
                CartifyDatabaseHelper.TABLE_USERS,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean exists = cursor != null && cursor.getCount() > 0;
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return exists;
    }

    public User login(String email, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selection = CartifyDatabaseHelper.COLUMN_USER_EMAIL + " = ? AND " +
                CartifyDatabaseHelper.COLUMN_USER_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(
                CartifyDatabaseHelper.TABLE_USERS,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        User user = null;
        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_USER_ID));
            String fullName = cursor.getString(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_USER_FULL_NAME));
            String em = cursor.getString(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_USER_EMAIL));
            String pass = cursor.getString(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_USER_PASSWORD));

            user = new User(id, fullName, em, pass);
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return user;
    }
}
