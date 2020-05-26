package io.github.mishrasunny174.practical8;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListUsers extends Activity {

    private ListView userList;
    private String[] projections = {DatabaseSchema.TableSchema.COLUMN_NAME_USERNAME};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        userList = (ListView)findViewById(R.id.list_view_users);
        Cursor cursor = ((SQLiteDemoApp)getApplication()).getDatabase().query(DatabaseSchema.TableSchema.TABLE_NAME,
                                                                                projections,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null);
        ArrayList<String> listOfUsers = new ArrayList<>();
        while(cursor.moveToNext())
        {
            String username = cursor.getString(cursor.getColumnIndex(DatabaseSchema.TableSchema.COLUMN_NAME_USERNAME));
            listOfUsers.add(username);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1,listOfUsers);
        userList.setAdapter(adapter);
    }

}
