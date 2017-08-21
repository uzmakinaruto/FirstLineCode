package com.jan.flc.firstlinecode.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.adapter.RoomAdapter;
import com.jan.flc.firstlinecode.data.DYRoom;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by huangje on 2017/8/21.
 */

public class LitePalActivity extends BaseActivity {

    private ListView lv;
    private List<DYRoom> rooms;
    private RoomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        lv = (ListView) findViewById(R.id.lv);
        rooms = DataSupport.findAll(DYRoom.class);
        adapter = new RoomAdapter(this, R.layout.item_dyroom, rooms);
        lv.setAdapter(adapter);
    }

    public void insert(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View root = LayoutInflater.from(this).inflate(R.layout.dialog_room, null);
        final EditText title = (EditText) root.findViewById(R.id.titleInput);
        final EditText host = (EditText) root.findViewById(R.id.hostInput);
        final EditText gifts = (EditText) root.findViewById(R.id.giftsInput);
        final EditText concerns = (EditText) root.findViewById(R.id.concernsInput);
        final EditText roomNumber = (EditText) root.findViewById(R.id.roomNumberInput);
        builder.setView(root);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!TextUtils.isEmpty(title.getText().toString()) &&
                        !TextUtils.isEmpty(host.getText().toString()) &&
                        !TextUtils.isEmpty(gifts.getText().toString()) &&
                        !TextUtils.isEmpty(concerns.getText().toString()) &&
                        !TextUtils.isEmpty(roomNumber.getText().toString())) {

                }
            }
        }).create().show();
    }
}
