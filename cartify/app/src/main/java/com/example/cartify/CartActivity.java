package com.example.cartify;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartify.adapters.CartAdapter;
import com.example.cartify.models.Product;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView rvCart;
    TextView tvSubtotal, tvShipping, tvTotal, tvFreeShippingMsg;
    Button btnCheckout;

    ArrayList<Product> cartList = new ArrayList<>();
    CartAdapter adapter;

    double shipping = 5.99; // fixed shipping

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initViews();
        loadCartItems();
        setupRecycler();
        updateTotals();
        initListeners();
    }

    private void initViews() {
        rvCart = findViewById(R.id.rvCart);
        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvShipping = findViewById(R.id.tvShipping);
        tvTotal = findViewById(R.id.tvTotal);
        tvFreeShippingMsg = findViewById(R.id.tvFreeShippingMsg);
        btnCheckout = findViewById(R.id.btnCheckout);
    }

    private void loadCartItems() {
        // Dummy items (you can load from SQLite later)
        cartList.add(new Product("LeatherCraft", "Minimalist Leather Wallet", 49.99, 69.99, 29));
        cartList.add(new Product("SoundMax", "Wireless Bluetooth Headphones", 149.99, 199.99, 25));
    }

    private void setupRecycler() {
        rvCart.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(cartList, this, this::updateTotals);
        rvCart.setAdapter(adapter);
    }

    private void initListeners() {
        btnCheckout.setOnClickListener(v ->
                Toast.makeText(this, "Proceeding to checkout...", Toast.LENGTH_SHORT).show()
        );
    }

    private void updateTotals() {
        double subtotal = 0;

        for (Product p : cartList) {
            subtotal += p.getPrice() * p.getQuantity();
        }

        tvSubtotal.setText("$" + String.format("%.2f", subtotal));
        tvShipping.setText("$" + String.format("%.2f", shipping));

        double total = subtotal + shipping;
        tvTotal.setText("$" + String.format("%.2f", total));

        // Free shipping message logic
        if (subtotal >= 50) {
            tvFreeShippingMsg.setText("You have free shipping!");
            tvFreeShippingMsg.setTextColor(0xFF4CAF50);
        } else {
            double remaining = 50 - subtotal;
            tvFreeShippingMsg.setText("Add $" + String.format("%.2f", remaining) + " more for free shipping!");
            tvFreeShippingMsg.setTextColor(0xFF4CAF50);
        }
    }
}
