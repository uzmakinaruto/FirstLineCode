package com.jan.flc.firstlinecode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jan.flc.firstlinecode.R;

public class DataStorageActivity extends BaseActivity {

    public static final String[] items = new String[]{
            "文件存储", "SharedPreferences", "SQLite", "LitePal"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(DataStorageActivity.this, FileStorageActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(DataStorageActivity.this, SharedPreferencesActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(DataStorageActivity.this, SqliteActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(DataStorageActivity.this, LitePalActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
