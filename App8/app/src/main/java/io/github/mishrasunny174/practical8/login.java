package io.github.mishrasunny174.practical8;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity {

    private EditText username;
    private EditText password;
    private Button login_button;
    private static final String[] projections = {DatabaseSchema.TableSchema.COLUMN_NAME_PASSWORD};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText)findViewById(R.id.username_edittext_login);
        password = (EditText)findViewById(R.id.password_edit_text_login);
        login_button = (Button)findViewById(R.id.login_button_login);
        login_button.setOnClickListener((view)->{
            if(username.getText().toString().equals("")||password.getText().toString().equals("")) {
                Toast.makeText(this,"Please enter credentials",Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor cursor;
            String where = DatabaseSchema.TableSchema.COLUMN_NAME_PASSWORD + " = ?";
            String[] filter = {password.getText().toString()};
            cursor = ((SQLiteDemoApp)getApplication()).getDatabase().query(DatabaseSchema.TableSchema.TABLE_NAME,
                                                                            projections,
                                                                            where,
                                                                            filter,
                                                                            null,
                                                                            null,
                                                                            null);
            if(cursor.getCount()==0)
            {
                Toast.makeText(this,"Invalid credentials",Toast.LENGTH_SHORT).show();
            } else {
                while(cursor.moveToNext()) {
                    if(cursor.getString(cursor.getColumnIndex(DatabaseSchema.TableSchema.COLUMN_NAME_PASSWORD)).equals(password.getText().toString())){
                        Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }

}
