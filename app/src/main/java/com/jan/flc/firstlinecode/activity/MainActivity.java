package com.jan.flc.firstlinecode.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jan.flc.firstlinecode.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    public static final String[] CHAPTERS = new String[]{
            "第1章 开始启程——你的第一行代码",
            "第2章 先从看得到的入手——探究活动",
            "第3章 软件也要拼脸蛋——UI开发的点点滴滴",
            "第4章 手机平板要兼顾——探究碎片",
            "第5章 全局大喇叭——详解广播机制",
            "第6章 数据存储全方案——详解持久化技术",
            "第7章 跨程序共享数据——探究内容提供器",
            "第8章 丰富你的程序——运用手机多媒体",
            "第9章 看看精彩的世界——使用网络技术",
            "第10章 后台默默的劳动者——探究服务",
            "第11章 Android特色开发——基于位置的服务",
            "第12章 最佳UI体验——Material Design实战",
            "第13章 继续进阶——你还应该掌握的高级技巧",
            "第14章 进入实战——开发酷欧天气",
            "第15章 最后一步——将应用发布到360应用商店"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_main);
        ListView lv = (ListView) findViewById(R.id.chaptersList);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, CHAPTERS);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 1:
                startActivity(new Intent(this, AtyChapterActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, UIActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, FragmentTestActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, ReceiverActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, DataStorageActivity.class));
                break;
            default:
                break;
        }
    }
}
