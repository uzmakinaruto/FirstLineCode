package com.jan.flc.firstlinecode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.utils.ActivityCollection;

/**
 * Created by huangje on 17-3-3.
 */

public class AtyChapterActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    public static final int REQUEST_CODE = 0;
    public static final String INTENT_ACTION = "com.jan.flc.firstlinecode.INTENT_ACTION";
    public static final String INTENT_CATEGORY = "com.jan.flc.firstlinecode.INTENT_CATEGORY";
    public static final String[] ACTIVITY_SECTIONS = new String[]{
            "显式Intent", "隐式Intent", "生命周期", "启动模式", "结束程序"
    };

    private TextView returnData;
    private EditText inputData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_activity);
        ListView lv = (ListView) findViewById(R.id.activityChapterList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ACTIVITY_SECTIONS);
        lv.setAdapter(adapter);
        inputData = (EditText) findViewById(R.id.intentInput);
        returnData = (TextView) findViewById(R.id.returnData);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0: {
                String input = inputData.getText().toString();
                String mode = "显式模式";
                DialogActivity.actionStart(this, mode, input, REQUEST_CODE);
            }
            break;

            case 1: {
                String input = inputData.getText().toString();
                String mode = "隐式模式";
                Intent intent = new Intent(INTENT_ACTION);
                intent.addCategory(INTENT_CATEGORY);
                intent.putExtra("mode", mode);
                intent.putExtra("input", input);
                startActivityForResult(intent, REQUEST_CODE);
            }
            break;

            case 3: {
                Toast.makeText(this, getString(R.string.launcher_mode), Toast.LENGTH_LONG).show();
            }
            break;
            case 4: {
                ActivityCollection.finishAll();
            }
            break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                returnData.setText(data.getStringExtra("return"));
            }
        }
    }
}
