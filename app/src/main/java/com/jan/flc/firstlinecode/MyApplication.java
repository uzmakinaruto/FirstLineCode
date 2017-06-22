package com.jan.flc.firstlinecode;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by huangje on 2017/3/16.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        /*CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/STCAIYUN.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );*/
    }

}
