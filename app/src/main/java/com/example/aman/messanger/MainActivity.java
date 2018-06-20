package com.example.aman.messanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2; Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.editText);
        t2=findViewById(R.id.editText2);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(!TextUtils.isEmpty(t1.getText().toString())&&!TextUtils.isEmpty(t2.getText().toString()))
                {Intent i=new Intent(MainActivity.this,ChatBox.class);
                i.putExtra("key1",t1.getText().toString());
                i.putExtra("key2",t1.getText().toString());
                startActivity(i);}
                else
                   Toast.makeText(MainActivity.this,"Enter Names",Toast.LENGTH_SHORT).show();
            }
        });





    }
}
