package com.example.cartify.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cartify.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private final CartifyDatabaseHelper dbHelper;

    public OrderDao(Context context) {
        dbHelper = new CartifyDatabaseHelper(context);
    }

    public long insertOrder(Order order) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CartifyDatabaseHelper.COLUMN_ORDER_USER_ID, order.getUserId());
        values.put(CartifyDatabaseHelper.COLUMN_ORDER_PRODUCT_NAME, order.getProductName());
        values.put(CartifyDatabaseHelper.COLUMN_ORDER_PRICE, order.getPrice());
        values.put(CartifyDatabaseHelper.COLUMN_ORDER_QUANTITY, order.getQuantity());
        values.put(CartifyDatabaseHelper.COLUMN_ORDER_DATE, order.getOrderDate());

        long id = db.insert(CartifyDatabaseHelper.TABLE_ORDERS, null, values);
        db.close();
        return id;
    }

    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection = CartifyDatabaseHelper.COLUMN_ORDER_USER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(
                CartifyDatabaseHelper.TABLE_ORDERS,
                null,
                selection,
                selectionArgs,
                null,
                null,
                CartifyDatabaseHelper.COLUMN_ORDER_DATE + " DESC"
        );

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_ORDER_ID));
                String productName = cursor.getString(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_ORDER_PRODUCT_NAME));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_ORDER_PRICE));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_ORDER_QUANTITY));
                String orderDate = cursor.getString(cursor.getColumnIndexOrThrow(CartifyDatabaseHelper.COLUMN_ORDER_DATE));

                orders.add(new Order(id, userId, productName, price, quantity, orderDate));
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return orders;
    }
}
