package com.example.thepunjabidhaba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    Context context;
    ArrayList<Cart> items;

    public CartAdapter(Context c, ArrayList<Cart> i){
        context=c;
        items=i;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartAdapter.CartViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_items_layout,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        int tot;
        final Cart i=items.get(position);
        holder.name.setText(i.getName());
        holder.price.setText("Price: Rs "+i.getPrice());
        holder.quantity.setText("Quantity: "+i.getQuantity());
        tot=Integer.parseInt(i.getPrice())*Integer.parseInt(i.getQuantity());
        holder.total.setText("Total Price: "+(tot));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder{
        TextView name,quantity,price,total;
        public CartViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.prname);
            price=itemView.findViewById(R.id.prprice);
            quantity=itemView.findViewById(R.id.prquant);
            total=itemView.findViewById(R.id.prtotal);
        }
    }
}
