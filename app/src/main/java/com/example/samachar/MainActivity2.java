//<======= LOGIN OR SIGN UP PAGE ======>
package com.example.samachar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button button;
TextView textView;
EditText editText,editTextPass;
    DBhelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.tv);
        editText=findViewById(R.id.editTextText);
        editTextPass=findViewById(R.id.editTextTextPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           String username =editText.getText().toString();
           String password=editTextPass.getText().toString();
           helper =new DBhelper(MainActivity2.this);
          if (username.equals("")||password.equals(""))
          {
              Toast.makeText(MainActivity2.this,"Mention username and password!",Toast.LENGTH_LONG).show();
          }
          else {
              boolean check = helper.checkUsernamePassword(username, password);
              boolean checkPass =helper.checkPassword(username,password);
              if (check) {
                  // news wale page prr bhej do
                  Intent intent=new Intent(MainActivity2.this,MainActivity4.class);
                  startActivity(intent);
                  editTextPass.setText("");
              } else  if (!checkPass){
                  Toast.makeText(MainActivity2.this, "Username or Password is incorrect!", Toast.LENGTH_LONG).show();
                   editTextPass.setText("");
              }
              else {
                  Toast.makeText(MainActivity2.this, "Sign up! First", Toast.LENGTH_LONG).show();
              }

          }
            }
        });
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent =new Intent(MainActivity2.this,MainActivity3.class);
               startActivity(intent);
           }
       });



    }
}