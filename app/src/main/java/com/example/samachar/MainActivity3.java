package com.example.samachar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
// sign up page code to inser data into database
public class MainActivity3 extends AppCompatActivity {
EditText editText1,editText2,editText3;
Button b;
DBhelper help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText1=findViewById(R.id.editTextText2);
        editText2=findViewById(R.id.editTextTextEmailAddress2);
        editText3=findViewById(R.id.editTextTextPassword4);
        help=new DBhelper(this);
        b=findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =editText1.getText().toString();
                String usename =editText2.getText().toString();
                String password=editText3.getText().toString();
               boolean done= help.insert(name,usename,password);
               if (done==true)
               {
                  // Log.d("error","error");
                   Toast.makeText(MainActivity3.this,"Successfully Registered!!",Toast.LENGTH_LONG).show();
                   editText1.setText("");
                   editText2.setText("");
                   editText3.setText("");
                   Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                   startActivity(intent);
               }
               else {
                   Toast.makeText(MainActivity3.this," not done",Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}