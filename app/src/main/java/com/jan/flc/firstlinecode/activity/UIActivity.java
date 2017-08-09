package com.jan.flc.firstlinecode.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jan.flc.firstlinecode.R;

/**
 * Created by huangje on 17-3-8.
 */

public class UIActivity extends BaseActivity {

    public static final String[] UI_SECTIONS = new String[]{
            "常用控件", "布局-百分比布局", "ListView", "RecyclerView", "聊天界面"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_ui);
        ListView lv = (ListView) findViewById(R.id.uiChapterList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, UI_SECTIONS);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(UIActivity.this, BaseUIActivity.class));
                        break;

                    case 1:
                        startActivity(new Intent(UIActivity.this, PercentLayoutActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(UIActivity.this, ListViewActivity.class));
                        break;

                    case 3:
                        setRecyclerViewStyle();
                        break;

                    case 4:
                        startActivity(new Intent(UIActivity.this, ChatActivity.class));
                        break;
                    default:
                        break;
                }

            }
        });
    }

    private void setRecyclerViewStyle() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setItems(new String[]{"纵向", "横向", "表格", "瀑布流"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                        intent.putExtra("style", i);
                        startActivity(intent);
                    }
                });
        builder.create().show();
    }
}
