package io.github.mishrasunny174.practical4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    RadioGroup radioGroup;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group_options);
        result = (TextView)findViewById(R.id.result);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String output = ((RadioButton)findViewById(group.getCheckedRadioButtonId())).getText().toString();
                result.setText(output);
            }
        });
    }
}
