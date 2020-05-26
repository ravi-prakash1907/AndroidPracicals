package io.github.mishrasunny174.practical8;

import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RemoveUser extends Activity {

    private EditText username;
    private Button remove_user_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_user);
        username = (EditText)findViewById(R.id.username_edittext_remove_user);
        remove_user_button = (Button)findViewById(R.id.remove_user_button);
        remove_user_button.setOnClickListener((view)->{
            if(username.getText().toString().equals("")) {
                Toast.makeText(this,"Please provide username",Toast.LENGTH_SHORT).show();
                return;
            }
            String criteria = DatabaseSchema.TableSchema.COLUMN_NAME_USERNAME + " LIKE ?";
            String selectionArgs[] = {username.getText().toString()};
            int deletedRows = ((SQLiteDemoApp)getApplication()).getDatabase().delete(DatabaseSchema.TableSchema.TABLE_NAME,criteria,selectionArgs);
            if(deletedRows>0)
            {
                Toast.makeText(this, "user deleted",Toast.LENGTH_SHORT).show();
                finish();
            }
            else
            {
                Toast.makeText(this,"user not found",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
