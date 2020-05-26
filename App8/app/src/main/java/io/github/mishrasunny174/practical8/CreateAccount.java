package io.github.mishrasunny174.practical8;

import android.content.ContentValues;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends Activity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button create_account_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        editTextUsername = (EditText)findViewById(R.id.username_edittext_create_account);
        editTextPassword = (EditText)findViewById(R.id.password_edit_text_create_account);
        create_account_button = (Button)findViewById(R.id.create_account_button_create_account_activity);
        create_account_button.setOnClickListener((view)->{
            if(editTextUsername.getText().toString().equals("")||editTextPassword.getText().toString().equals("")) {
                Toast.makeText(this,"Please provide an username and password",Toast.LENGTH_SHORT).show();
                return;
            }
            ContentValues cv = new ContentValues();
            cv.put(DatabaseSchema.TableSchema.COLUMN_NAME_USERNAME,editTextUsername.getText().toString());
            cv.put(DatabaseSchema.TableSchema.COLUMN_NAME_PASSWORD,editTextPassword.getText().toString());
            long rowid = ((SQLiteDemoApp)getApplication()).getDatabase().insert(DatabaseSchema.TableSchema.TABLE_NAME,null,cv);
            if(rowid==-1)
                Log.e("DATABASE","Unable to insert values in database");
            else {
                Log.i("SUCCESSFUL","inserted successfully");
                Toast.makeText(this,"Account created successfully",Toast.LENGTH_SHORT).show();
                finish();
            }

        });
    }

}
