package com.jan.flc.firstlinecode.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.jan.flc.firstlinecode.R;

/**
 * Created by huangje on 2017/6/29.
 */

public class SharedPreferencesActivity extends BaseActivity {

    private EditText account, password;
    private CheckBox rememberPassword;
    private String spAccount, spPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
        rememberPassword = (CheckBox) findViewById(R.id.rememberPassword);
        SharedPreferences sharedPreferences = getSharedPreferences("spTest", Context.MODE_PRIVATE);
        spAccount = sharedPreferences.getString("account", null);
        spPassword = sharedPreferences.getString("password", null);
        boolean isRememberPassword = sharedPreferences.getBoolean("remember", false);
        if (isRememberPassword) {
            rememberPassword.setChecked(true);
            account.setText(spAccount);
            password.setText(spPassword);
        }
    }

    public void login(View v) {
        String acc = account.getText().toString();
        String pw = password.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("spTest", Context.MODE_PRIVATE);
        spAccount = sharedPreferences.getString("account", null);
        spPassword = sharedPreferences.getString("password", null);
        if (!TextUtils.isEmpty(acc) && !TextUtils.isEmpty(pw)) {
            if (acc.equals(spAccount) && pw.equals(spPassword)) {
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("remember", rememberPassword.isChecked());
                editor.commit();
            } else {
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
            }
        } else if (TextUtils.isEmpty(spAccount) && TextUtils.isEmpty(spPassword)) {
            Toast.makeText(this, "请先注册", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View v) {
        String acc = account.getText().toString();
        String pw = password.getText().toString();
        if (!TextUtils.isEmpty(acc) && !TextUtils.isEmpty(pw)) {
            SharedPreferences.Editor editor = getSharedPreferences("spTest", Context.MODE_PRIVATE).edit();
            editor.putString("account", acc);
            editor.putString("password", pw);
            editor.putBoolean("remember", rememberPassword.isChecked());
            editor.commit();
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }
}
