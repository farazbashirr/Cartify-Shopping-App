package com.example.cartify.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartify.R;
import com.example.cartify.models.Product;

import java.util.ArrayList;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {

    ArrayList<Product> list;
    Context context;

    public interface WishlistListener {
        void onDelete(Product p);
        void onAddToCart(Product p);
    }

    WishlistListener listener;

    public WishlistAdapter(ArrayList<Product> list, Context context, WishlistListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_wishlist_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int pos) {
        Product p = list.get(pos);

        h.tvName.setText(p.getName());
        h.tvBrand.setText(p.getBrand());
        h.tvPrice.setText("$" + p.getPrice());
        h.tvDate.setText("Added on Jan 4, 2026");

        h.ivDelete.setOnClickListener(v -> listener.onDelete(p));
        h.ivAddToCart.setOnClickListener(v -> listener.onAddToCart(p));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProduct, ivDelete, ivAddToCart;
        TextView tvName, tvBrand, tvPrice, tvDate;

        public ViewHolder(@NonNull View v) {
            super(v);
            ivProduct = v.findViewById(R.id.ivProduct);
            ivDelete = v.findViewById(R.id.ivDelete);
            ivAddToCart = v.findViewById(R.id.ivAddToCart);
            tvName = v.findViewById(R.id.tvName);
            tvBrand = v.findViewById(R.id.tvBrand);
            tvPrice = v.findViewById(R.id.tvPrice);
            tvDate = v.findViewById(R.id.tvDate);
        }
    }
}
