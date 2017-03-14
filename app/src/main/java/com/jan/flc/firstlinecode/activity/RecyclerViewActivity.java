package com.jan.flc.firstlinecode.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.adapter.PersonRVAdapter;
import com.jan.flc.firstlinecode.data.DouyuF4;

public class RecyclerViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_ui_recyclerview);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        int style = getIntent().getIntExtra("style", 0);
        RecyclerView.LayoutManager layoutManager = null;
        PersonRVAdapter adapter = null;
        switch (style) {
            case 0: {
                layoutManager = new LinearLayoutManager(this);
                ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
                adapter = new PersonRVAdapter(DouyuF4.getRandomPerson(20), R.layout.item_person_hor);

            }
            break;
            case 1: {
                layoutManager = new LinearLayoutManager(this);
                ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
                adapter = new PersonRVAdapter(DouyuF4.getRandomPerson(20), R.layout.item_person_ver);
            }
            break;

            case 2: {
                layoutManager = new GridLayoutManager(this, 3);
                adapter = new PersonRVAdapter(DouyuF4.getRandomPerson(40), R.layout.item_person_grid);
            }
            break;

            case 3: {
                layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                adapter = new PersonRVAdapter(DouyuF4.getRandomPerson2(40), R.layout.item_person_grid);
            }
            break;
            default:
                break;
        }
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }
}
