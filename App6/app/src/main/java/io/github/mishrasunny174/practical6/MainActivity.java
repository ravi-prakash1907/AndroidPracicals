package io.github.mishrasunny174.practical6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    RadioGroup group;
    RelativeLayout main_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_layout = (RelativeLayout)findViewById(R.id.main_layout);
        group = (RadioGroup)findViewById(R.id.button_group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.red_button:
                        main_layout.setBackgroundColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.blue_button:
                        main_layout.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;
                    case R.id.green_button:
                        main_layout.setBackgroundColor(getResources().getColor(R.color.green));
                        break;
                }
            }
        });
    }
}
