package com.jan.flc.firstlinecode.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jan.flc.firstlinecode.R;

/**
 * Created by huangje on 17-3-3.
 */

public class DialogActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity);
        TextView modeText = (TextView) findViewById(R.id.intentMode);
        TextView dataText = (TextView) findViewById(R.id.intentData);
        final EditText returnText = (EditText) findViewById(R.id.returnData);
        Button returnBtn = (Button) findViewById(R.id.returnBtn);
        modeText.setText(getIntent().getStringExtra("mode"));
        dataText.setText(getIntent().getStringExtra("input"));
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("return", returnText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public static void actionStart(Activity activity, String mode, String input, int requestCode) {
        Intent intent = new Intent(activity, DialogActivity.class);
        intent.putExtra("mode", mode);
        intent.putExtra("input", input);
        activity.startActivityForResult(intent, requestCode);
    }
}
