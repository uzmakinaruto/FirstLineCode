package com.jan.flc.firstlinecode.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.data.DouyuF4;
import com.jan.flc.firstlinecode.utils.LogUtils;

public class ReceiverActivity extends BaseActivity {

    public static final String BROADCAST_ACTION_F4 = "com.jan.flc.firstlinecode.action.F4";
    private F4Receiver f4Receiver;
    private EditText input;
    private ImageView image;
    private LocalBroadcastManager localBroadcastManager;
    private static final String TAG = "ReceiverActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        input = (EditText) findViewById(R.id.input);
        image = (ImageView) findViewById(R.id.image);
        f4Receiver = new F4Receiver();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(BROADCAST_ACTION_F4);
        localBroadcastManager.registerReceiver(f4Receiver, filter);
    }

    public void sendBroadcast(View v) {
        if (!TextUtils.isEmpty(input.getText().toString())) {
            Intent intent = new Intent(BROADCAST_ACTION_F4);
            intent.putExtra("name", input.getText().toString());
            localBroadcastManager.sendBroadcast(intent);
        }
    }


    @Override
    protected void onDestroy() {
        localBroadcastManager.unregisterReceiver(f4Receiver);
        super.onDestroy();
    }

    class F4Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getStringExtra("name");
            if (name != null) {
                for (int i = 0; i < DouyuF4.NAMES.length; i++) {
                    if (name.equals(DouyuF4.NAMES[i])) {
                        image.setImageResource(DouyuF4.IMAGES_BIG[i]);
                        return;
                    }
                }
            }
            image.setImageResource(R.drawable.default_image);
        }
    }
}
