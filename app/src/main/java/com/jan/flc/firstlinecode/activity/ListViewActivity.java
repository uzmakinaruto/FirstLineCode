package com.jan.flc.firstlinecode.activity;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_ui_listview);
        persons = DouyuF4.getRandomPerson(20);
        ListView lv = (ListView) findViewById(R.id.lv);
        PersonLVAdapter adapter = new PersonLVAdapter(this, R.layout.item_person_hor, persons);
        lv.setAdapter(adapter);
    }
}
