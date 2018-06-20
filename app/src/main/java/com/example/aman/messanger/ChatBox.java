package com.example.aman.messanger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatBox extends AppCompatActivity {
   String me,friend;


           String key;
   EditText ets;
   Button bts;
   RecyclerView rview;
   ArrayList<DataID> arrlist=new ArrayList<DataID>();
   DatabaseReference databaseReferenceMe, databaseReferenceFreind;
    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(ChatBox.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ets=findViewById(R.id.ets);
        bts=findViewById(R.id.bts);
        Intent i=getIntent();
        me=i.getStringExtra("key1");
        friend=i.getStringExtra("key2");

        databaseReferenceMe= FirebaseDatabase.getInstance().getReference(me);
        databaseReferenceFreind= FirebaseDatabase.getInstance().getReference(friend);
        rview=findViewById(R.id.rview);
        rview.setLayoutManager(layoutManager);


        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(ets.getText().toString()))
                    sendData();
                else
                    Toast.makeText(getBaseContext(), "Enter MESSAGE", Toast.LENGTH_SHORT).show();
            }});

//        databaseReferenceFreind.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                if(dataSnapshot.hasChildren())
//                {
//               DataID dataReceive=new DataID(dataSnapshot.getValue(DataID.class).getData(),2);
//                   arrlist.add(dataReceive);
//                    rview.setAdapter(new MyAdapter(getBaseContext(),arrlist));
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        databaseReferenceFreind.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataID dataReceive=dataSnapshot.getValue(DataID.class); dataReceive.setId(2);
                arrlist.add(dataReceive);
                rview.setAdapter(new MyAdapter(getBaseContext(),arrlist));

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });








    }



public void sendData()
{    DataID dataSend=new DataID(ets.getText().toString(),1);
    key = databaseReferenceMe.push().getKey();
    databaseReferenceMe.child(key).setValue(dataSend);
    arrlist.add(dataSend);


    rview.setAdapter(new MyAdapter(ChatBox.this,arrlist));

}

}
