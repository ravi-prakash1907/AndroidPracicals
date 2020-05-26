package io.github.mishrasunny174.practical8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class MainActivity extends Activity {

    private Button loginButton;
    private Button createAccountButton;
    private Button listUsersButton;
    private Button removeUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = (Button)findViewById(R.id.login_button);
        createAccountButton = (Button)findViewById(R.id.create_account);
        listUsersButton = (Button)findViewById(R.id.list_users);
        removeUser = (Button)findViewById(R.id.delete_user_button);
        createAccountButton.setOnClickListener((view)->{
            Intent intent = new Intent(this,CreateAccount.class);
            startActivity(intent);
        });
        listUsersButton.setOnClickListener((view)->{
            startActivity(new Intent(this,ListUsers.class));
        });
        loginButton.setOnClickListener((view)->{
            startActivity(new Intent(this,login.class));
        });
        removeUser.setOnClickListener((view)->{
            startActivity(new Intent(this,RemoveUser.class));
        });
    }
}
