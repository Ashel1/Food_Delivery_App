package com.example.thepunjabidhaba;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static final String USER_KEY ="user_key" ;
    Context context;
    ArrayList<DishProfile> items;

    public MyAdapter(Context c, ArrayList<DishProfile> i){
        context=c;
        items=i;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DishProfile i=items.get(position);
        holder.name.setText(i.getName());
        holder.price.setText("Price: "+i.getPrice());
        Picasso.get().load(i.getPic()).into(holder.pic);
        holder.time.setText("Estimate Time: "+i.getTime());
        String type=i.getType().toLowerCase();
        if(type.equals("veg")) {
            holder.type.setBackgroundColor(0xFF008000);
        }
        else{
            holder.type.setBackgroundColor(0xFFFF0000);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id= i.getName();
                Intent intent=new Intent(context,dishDetail.class);
                intent.putExtra(USER_KEY,id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,price,type,time;
        ImageView pic;
        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.dishName);
            price=itemView.findViewById(R.id.dishPrice);
            pic=itemView.findViewById(R.id.dishImg);
            type=itemView.findViewById(R.id.dishType);
            time=itemView.findViewById(R.id.dishTime);

        }
    }
}