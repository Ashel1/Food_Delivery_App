package com.example.thepunjabidhaba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button po, clear;
    private TextView ta;
    private int total;
    ArrayList<Cart> list;
    CartAdapter adapter;
    DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("CartList");

    public CartActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cart);
        clear=findViewById(R.id.clear);
        ta=findViewById(R.id.total_price);
        po=findViewById(R.id.po);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<Cart>();

        cartListRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren() ){
                    Cart i=dataSnapshot1.getValue(Cart.class);
                    total=total+(Integer.parseInt(i.getPrice())*Integer.parseInt(i.getQuantity()));
                    i.setId(dataSnapshot.getKey());
                    list.add(i);
                }
                ta.setText("Total= "+ total);
                adapter= new CartAdapter(CartActivity.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CartActivity.this,"Something is wrong",Toast.LENGTH_SHORT).show();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartListRef.setValue(null);
                Toast.makeText(CartActivity.this,"Cart Emptied",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(CartActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartListRef.setValue(null);
                Toast.makeText(CartActivity.this,"Order Placed!!",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(CartActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
