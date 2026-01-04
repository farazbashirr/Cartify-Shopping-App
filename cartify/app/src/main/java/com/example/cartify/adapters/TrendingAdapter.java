package com.example.cartify.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartify.ProductDetailActivity;
import com.example.cartify.R;
import com.example.cartify.models.Product;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    ArrayList<Product> list;
    Context context;

    public TrendingAdapter(ArrayList<Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_trending_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int pos) {
        Product p = list.get(pos);

        h.tvBrand.setText(p.getBrand());
        h.tvName.setText(p.getName());
        h.tvPrice.setText("$" + p.getPrice());
        h.tvDiscount.setText("-" + p.getDiscount() + "%");

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
        TextView tvBrand, tvName, tvPrice, tvDiscount;

        public ViewHolder(@NonNull View v) {
            super(v);
            tvBrand = v.findViewById(R.id.tvBrand);
            tvName = v.findViewById(R.id.tvName);
            tvPrice = v.findViewById(R.id.tvPrice);
            tvDiscount = v.findViewById(R.id.tvDiscount);
        }
    }
}
