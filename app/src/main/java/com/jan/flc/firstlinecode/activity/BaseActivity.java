package com.jan.flc.firstlinecode.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jan.flc.firstlinecode.utils.ActivityCollection;
import com.jan.flc.firstlinecode.utils.LogUtils;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.v(getClass().getSimpleName(),"onCreate");
        ActivityCollection.addActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.v(getClass().getSimpleName(),"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.v(getClass().getSimpleName(),"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.v(getClass().getSimpleName(),"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.v(getClass().getSimpleName(),"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.v(getClass().getSimpleName(),"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.v(getClass().getSimpleName(),"onDestroy");
        ActivityCollection.removeActivity(this);
    }
}
