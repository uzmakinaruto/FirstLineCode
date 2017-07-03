package com.jan.flc.firstlinecode.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jan.flc.firstlinecode.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by huangje on 2017/6/27.
 */

public class FileStorageActivity extends BaseActivity {

    private EditText input;
    private static final String TAG = "FileStorageActivity";
    private BufferedReader reader;
    private BufferedWriter writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);
        input = (EditText) findViewById(R.id.input);
        readFromFile();
    }

    public void saveToFile(View v) throws FileNotFoundException {
        if (writer == null) {
            writer = new BufferedWriter(new OutputStreamWriter(openFileOutput(TAG, Context.MODE_PRIVATE)));
        }
        String str = input.getText().toString();
        if (!TextUtils.isEmpty(str)) {
            try {
                writer.write(str);
                Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    public void readFromFile() {
        if (reader == null) {
            try {
                reader = new BufferedReader(new InputStreamReader(openFileInput(TAG)));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                input.setText(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
