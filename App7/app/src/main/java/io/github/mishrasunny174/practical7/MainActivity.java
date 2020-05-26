package io.github.mishrasunny174.practical7;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText username;
    private EditText password;
    private Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username_edittext);
        password = (EditText)findViewById(R.id.password_edittext);
        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener((view)->{
            if(username.getText().toString().equals("") || password.getText().toString().equals("")){
                Toast.makeText(this,"Please enter credentials",Toast.LENGTH_SHORT).show();
            } else if(username.getText().toString().equals(getString(R.string.username))
                    &&
                    password.getText().toString().equals(getString(R.string.password))){
                Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,
                        "username = "+getString(R.string.username)+" password = "+getString(R.string.password),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
