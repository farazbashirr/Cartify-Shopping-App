package com.example.cartify;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartify.adapters.WishlistAdapter;
import com.example.cartify.models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class WishlistActivity extends AppCompatActivity {

    RecyclerView rvWishlist;
    BottomNavigationView bottomNav;
    ArrayList<Product> list = new ArrayList<>();
    WishlistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        rvWishlist = findViewById(R.id.rvWishlist);
        bottomNav = findViewById(R.id.bottomNav);

        loadWishlist();
        setupRecycler();
        setupBottomNav();
    }

    private void loadWishlist() {
        list.add(new Product("LeatherCraft", "Minimalist Leather Wallet", 49.99, 69.99, 29));
    }

    private void setupRecycler() {
        rvWishlist.setLayoutManager(new LinearLayoutManager(this));

        adapter = new WishlistAdapter(list, this, new WishlistAdapter.WishlistListener() {
            @Override
            public void onDelete(Product p) {
                list.remove(p);
                adapter.notifyDataSetChanged();
                Toast.makeText(WishlistActivity.this, "Removed from wishlist", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAddToCart(Product p) {
                Toast.makeText(WishlistActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        rvWishlist.setAdapter(adapter);
    }

    private void setupBottomNav() {
        bottomNav.setOnItemSelectedListener(item -> {
            finish();
            return true;
        });
    }
}
