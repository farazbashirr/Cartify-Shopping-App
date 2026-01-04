package com.example.cartify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvEdit, tvMyOrders, tvWishlist;
    Switch switchDarkMode;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
        setupBottomNav();
        setupListeners();
    }

    private void initViews() {
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvEdit = findViewById(R.id.tvEdit);
        tvMyOrders = findViewById(R.id.tvMyOrders);
        tvWishlist = findViewById(R.id.tvWishlist);
        switchDarkMode = findViewById(R.id.switchDarkMode);
        bottomNav = findViewById(R.id.bottomNav);
    }

    private void setupListeners() {

        tvEdit.setOnClickListener(v ->
                startActivity(new Intent(this, SignupActivity.class))
        );

        tvMyOrders.setOnClickListener(v ->
                startActivity(new Intent(this, OrdersActivity.class))
        );

        tvWishlist.setOnClickListener(v ->
                startActivity(new Intent(this, WishlistActivity.class))
        );

        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // TODO: Implement dark mode toggle
        });
    }

    private void setupBottomNav() {
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                startActivity(new Intent(this, HomeActivity.class));
                return true;
            }
            if (id == R.id.nav_search) {
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            }
            if (id == R.id.nav_cart) {
                startActivity(new Intent(this, CartActivity.class));
                return true;
            }
            if (id == R.id.nav_wishlist) {
                startActivity(new Intent(this, WishlistActivity.class));
                return true;
            }
            if (id == R.id.nav_profile) {
                return true;
            }

            return false;
        });
    }
}
