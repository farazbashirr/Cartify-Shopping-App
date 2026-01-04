package com.example.cartify;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    TextView tvBrand, tvName, tvPrice, tvOldPrice, tvRating, tvQuantity;
    ImageView ivProductImage;
    Button btnMinus, btnPlus, btnAddToCart;

    int quantity = 1;
    double price = 49.99; // default
    double oldPrice = 69.99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        initViews();
        loadIntentData();
        initListeners();
    }

    private void initViews() {
        ivProductImage = findViewById(R.id.ivProductImage);
        tvBrand = findViewById(R.id.tvBrand);
        tvName = findViewById(R.id.tvName);
        tvRating = findViewById(R.id.tvRating);
        tvPrice = findViewById(R.id.tvPrice);
        tvOldPrice = findViewById(R.id.tvOldPrice);
        tvQuantity = findViewById(R.id.tvQuantity);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnAddToCart = findViewById(R.id.btnAddToCart);
    }

    private void loadIntentData() {
        String name = getIntent().getStringExtra("name");
        String brand = getIntent().getStringExtra("brand");
        double p = getIntent().getDoubleExtra("price", 49.99);

        tvName.setText(name);
        tvBrand.setText(brand);
        tvPrice.setText("$" + p);
        price = p;
    }

    private void initListeners() {

        btnMinus.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                tvQuantity.setText(String.valueOf(quantity));
            }
        });

        btnPlus.setOnClickListener(v -> {
            quantity++;
            tvQuantity.setText(String.valueOf(quantity));
        });

        btnAddToCart.setOnClickListener(v ->
                Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show()
        );
    }
}
