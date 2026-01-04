package com.example.cartify.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartify.R;
import com.example.cartify.models.Product;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<Product> list;
    Context context;
    CartListener listener;

    public interface CartListener {
        void onQuantityChanged();
    }

    public CartAdapter(ArrayList<Product> list, Context context, CartListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_cart_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int pos) {
        Product p = list.get(pos);

        h.tvName.setText(p.getName());
        h.tvBrand.setText(p.getBrand());
        h.tvPrice.setText("$" + p.getPrice());
        h.tvQuantity.setText(String.valueOf(p.getQuantity()));

        h.btnMinus.setOnClickListener(v -> {
            if (p.getQuantity() > 1) {
                p.setQuantity(p.getQuantity() - 1);
                notifyItemChanged(pos);
                listener.onQuantityChanged();
            }
        });

        h.btnPlus.setOnClickListener(v -> {
            p.setQuantity(p.getQuantity() + 1);
            notifyItemChanged(pos);
            listener.onQuantityChanged();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvBrand, tvPrice, tvQuantity;
        Button btnMinus, btnPlus;

        public ViewHolder(@NonNull View v) {
            super(v);
            tvName = v.findViewById(R.id.tvName);
            tvBrand = v.findViewById(R.id.tvBrand);
            tvPrice = v.findViewById(R.id.tvPrice);
            tvQuantity = v.findViewById(R.id.tvQuantity);
            btnMinus = v.findViewById(R.id.btnMinus);
            btnPlus = v.findViewById(R.id.btnPlus);
        }
    }
}
