package com.example.cartify.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartify.ProductDetailActivity;
import com.example.cartify.R;
import com.example.cartify.models.Product;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    ArrayList<Product> list;
    Context context;

    public SearchAdapter(ArrayList<Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_search_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int pos) {
        Product p = list.get(pos);

        h.tvName.setText(p.getName());
        h.tvPrice.setText("$" + p.getPrice());
        h.tvDiscount.setText("-" + p.getDiscount() + "%");
        h.tvRating.setText("★ 4.5 (234)");

        h.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, ProductDetailActivity.class);
            i.putExtra("name", p.getName());
            i.putExtra("brand", p.getBrand());
            i.putExtra("price", p.getPrice());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProduct, ivWishlist, ivAddToCart;
        TextView tvName, tvPrice, tvDiscount, tvRating;

        public ViewHolder(@NonNull View v) {
            super(v);
            ivProduct = v.findViewById(R.id.ivProduct);
            ivWishlist = v.findViewById(R.id.ivWishlist);
            ivAddToCart = v.findViewById(R.id.ivAddToCart);
            tvName = v.findViewById(R.id.tvName);
            tvPrice = v.findViewById(R.id.tvPrice);
            tvDiscount = v.findViewById(R.id.tvDiscount);
            tvRating = v.findViewById(R.id.tvRating);
        }
    }
}
