package com.example.cartify;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartify.adapters.SearchAdapter;
import com.example.cartify.models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    RecyclerView rvSearch;
    SearchAdapter adapter;
    EditText etSearch;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rvSearch = findViewById(R.id.rvSearch);
        etSearch = findViewById(R.id.etSearch);
        bottomNav = findViewById(R.id.bottomNav);

        setupRecycler();
        setupBottomNav();
    }

    private void setupRecycler() {
        rvSearch.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("SoundMax", "Wireless Bluetooth Headphones", 149.99, 199.99, 25));
        list.add(new Product("FitTech", "Smart Fitness Watch", 299.99, 0, 0));

        adapter = new SearchAdapter(list, this);
        rvSearch.setAdapter(adapter);
    }

    private void setupBottomNav() {
        bottomNav.setOnItemSelectedListener(item -> {
            finish(); // back to home
            return true;
        });
    }
}
