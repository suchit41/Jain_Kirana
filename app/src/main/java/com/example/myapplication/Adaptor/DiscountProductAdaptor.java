package com.example.myapplication.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.DiscountedProducts;

import java.util.List;

public class DiscountProductAdaptor extends RecyclerView.Adapter<DiscountProductAdaptor.DiscountProductViewHolder> {
 Context context;
 List<DiscountedProducts>discountedProductsList;

    public DiscountProductAdaptor(Context context, List<DiscountedProducts> discountedProductsList) {
  this.context= context;
  this.discountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.discount_row_items,parent,false);

        return new DiscountProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountProductViewHolder holder, int position) {
holder.discount_image.setImageResource(discountedProductsList.get(position).getImageurl());
    }

    @Override
    public int getItemCount() {
        return discountedProductsList.size();
    }




    public static class DiscountProductViewHolder extends RecyclerView.ViewHolder{
        ImageView discount_image;

        public DiscountProductViewHolder(@NonNull View itemView){
            super(itemView);
            discount_image = itemView.findViewById(R.id.discount_image);

        }
    }

}
