package com.jan.flc.firstlinecode.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jan.flc.firstlinecode.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by huangje on 17-3-8.
 */

public class BaseUIActivity extends BaseActivity {

    private TextView tv;
    private EditText et;
    private Button setBtn;
    private Button showBtn;
    private ImageView iv;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_ui_base);
        tv = (TextView) findViewById(R.id.contentText);
        et = (EditText) findViewById(R.id.input);
        setBtn = (Button) findViewById(R.id.setBtn);
        showBtn = (Button) findViewById(R.id.showBtn);
        iv = (ImageView) findViewById(R.id.image);

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(et.getText())) {
                    tv.setText(et.getText().toString());
                }
            }
        });
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgressDialog();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                hideProgressDialog();
                                if (iv.getVisibility() == View.VISIBLE)
                                {
                                    iv.setVisibility(View.INVISIBLE);
                                    showBtn.setText("显示");
                                }

                                else
                                {
                                    iv.setVisibility(View.VISIBLE);
                                    showBtn.setText("隐藏");
                                }
                            }
                        });
                    }
                }).start();
            }
        });
    }

    private void getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Setting");
        }
    }

    private void showProgressDialog() {
        getProgressDialog();
        progressDialog.show();
    }

    private void hideProgressDialog() {
        getProgressDialog();
        progressDialog.hide();
    }
}
