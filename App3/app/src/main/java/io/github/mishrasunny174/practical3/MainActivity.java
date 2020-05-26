package io.github.mishrasunny174.practical3;

import android.app.Activity;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    Spinner image_spinner;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_spinner = (Spinner)findViewById(R.id.image_spinner);
        image = (ImageView)findViewById(R.id.image_view);
        String[] memes = getResources().getStringArray(R.array.memes);
        ArrayAdapter<String> memesAdapter = new ArrayAdapter<>(this,
                                                                android.R.layout.simple_expandable_list_item_1,
                                                                android.R.id.text1,
                                                                memes);
        image_spinner.setAdapter(memesAdapter);
        image_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        image.setImageResource(R.drawable.one);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.two);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.three);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.four);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
