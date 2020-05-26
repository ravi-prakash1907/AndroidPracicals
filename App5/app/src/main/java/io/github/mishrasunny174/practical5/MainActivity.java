package io.github.mishrasunny174.practical5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    private String[] courses;
    private String[] hods;
    private TextView result;
    private Spinner spinner;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courses = getResources().getStringArray(R.array.courses);
        hods = getResources().getStringArray(R.array.hod);
        result = (TextView)findViewById(R.id.result);
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(this,
                                    android.R.layout.simple_expandable_list_item_1,
                                    android.R.id.text1,
                                    courses);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                result.setText(hods[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
