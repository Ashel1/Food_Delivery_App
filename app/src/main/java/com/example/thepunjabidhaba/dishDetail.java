package com.example.thepunjabidhaba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class dishDetail extends AppCompatActivity {

    TextView name, quantity, description, price;
    ImageView pic;
    Button toCart;
    ElegantNumberButton quantbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        name=findViewById(R.id.dishName1);
        quantity=findViewById(R.id.dishQuantity1);
        description=findViewById(R.id.dishDescription1);
        price=findViewById(R.id.dishPrice1);
        pic=findViewById(R.id.dishImg1);
        quantbt=findViewById(R.id.quantbt);
        toCart=findViewById(R.id.toCart1);

        String id=getIntent().getStringExtra(MyAdapter.USER_KEY);
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("DishProfiles").child(id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DishProfile i=dataSnapshot.getValue(DishProfile.class);
                name.setText(i.getName());
                quantity.setText(i.getQuantity());
                description.setText(i.getDescription());
                price.setText("Price: "+i.getPrice());
                Picasso.get().load(i.getPic()).into(pic);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        toCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 addingToCartList();
            }
        });
    }

    private void addingToCartList() {
        String saveCurrentTime, saveCurrentDate;
        Calendar callForDate= Calendar.getInstance();
        SimpleDateFormat currentDate=new SimpleDateFormat("dd-MM-yyyy");
        saveCurrentDate=currentDate.format(callForDate.getTime());

        SimpleDateFormat currentTime=new SimpleDateFormat("hh:mm:ss a");
        saveCurrentTime=currentTime.format(callForDate.getTime());

        DatabaseReference cartreference=FirebaseDatabase.getInstance().getReference().child("CartList");

        final HashMap<String, Object> cartMap=new HashMap<>();
        cartMap.put("Name",name.getText().toString());
        cartMap.put("ID",name.getText().toString());
        String pprice=price.getText().toString().replace("Price: Rs","");
        cartMap.put("Price",pprice);
        cartMap.put("Date",saveCurrentDate);
        cartMap.put("Time",saveCurrentTime);
        cartMap.put("Quantity",quantbt.getNumber());
        cartreference.child(name.getText().toString()).setValue(cartMap);
    }
}
