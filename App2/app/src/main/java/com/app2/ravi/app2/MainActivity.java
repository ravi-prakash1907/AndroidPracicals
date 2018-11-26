package com.app2.ravi.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username ;
    EditText password ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.uname);
        password = (EditText)findViewById(R.id.pass);
    }


    public void openButton(View view) {

            if(password.getText().toString().equals(R.string.password)) {
                Toast.makeText(getApplicationContext(),
                        "Welcome "+username.getText().toString(),Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "Incorrect Password!",Toast.LENGTH_SHORT).show();
            }
            //Intent i = new Intent(this, Display.class);
            //startActivity(i);
        }
}


