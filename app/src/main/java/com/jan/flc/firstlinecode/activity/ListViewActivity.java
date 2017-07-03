package com.jan.flc.firstlinecode.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.adapter.PersonLVAdapter;
import com.jan.flc.firstlinecode.data.DouyuF4;

import java.util.List;

/**
 * Created by huangje on 17-3-9.
 */

public class ListViewActivity extends BaseActivity {


    private List<DouyuF4> persons;
    private ListView lv;
    private boolean isRefresh = false;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.invalidateViews();
            Log.v("getView","handleMessage");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_ui_listview);
        persons = DouyuF4.getRandomPerson(20);
        lv = (ListView) findViewById(R.id.lv);
        PersonLVAdapter adapter = new PersonLVAdapter(this, R.layout.item_person_hor, persons);
        lv.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRefresh) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHandler.sendEmptyMessage(0);
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRefresh = false;
    }
}
