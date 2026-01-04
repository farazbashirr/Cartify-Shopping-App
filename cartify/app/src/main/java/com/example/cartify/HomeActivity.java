package com.example.cartify;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartify.adapters.TrendingAdapter;
import com.example.cartify.models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvTrending;
    TrendingAdapter trendingAdapter;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvTrending = findViewById(R.id.rvTrending);
        bottomNav = findViewById(R.id.bottomNav);

        setupTrending();
        setupBottomNav();
    }

    private void setupTrending() {
        rvTrending.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("SoundMax", "Wireless Bluetooth Headphones", 149.99, 199.99, 25));
        list.add(new Product("LeatherCraft", "Minimalist Leather Wallet", 49.99, 69.99, 29));

        trendingAdapter = new TrendingAdapter(list, this);
        rvTrending.setAdapter(trendingAdapter);
    }

    private void setupBottomNav() {
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) return true;

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
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            }

            return false;
        });
    }
}
