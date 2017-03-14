package com.jan.flc.firstlinecode.data;

import com.jan.flc.firstlinecode.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangje on 17-3-9.
 */

public class DouyuF4 {

    public static final String[] NAMES = new String[]{"陈一发儿", "周二珂", "冯提莫", "大表姐"};
    public static final String[] WEIBO_URLS = new String[]{
            "http://weibo.com/thebs",
            "http://weibo.com/u/1910672761",
            "http://weibo.com/u/1672384324",
            "http://weibo.com/u/5279748872"
    };
    public static final int[] IMAGES = new int[]{R.drawable.cyfe, R.drawable.zek, R.drawable.ftm, R.drawable.dbj};
    public static final int[] IMAGES_BIG = new int[]{R.drawable.cyfe_big, R.drawable.ek_big, R.drawable.ftm_big, R.drawable.dbj_big};
    private int imageId;
    private int bigImageId;
    private String name;
    private String url;
    private int id;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBigImageId() {
        return bigImageId;
    }

    public void setBigImageId(int bigImageId) {
        this.bigImageId = bigImageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static List<DouyuF4> getRandomPerson(int count) {
        List<DouyuF4> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int random = (int) (Math.random() * 4);
            DouyuF4 person = new DouyuF4();
            person.setName(NAMES[random]);
            person.setImageId(IMAGES[random]);
            person.setBigImageId(IMAGES_BIG[random]);
            person.setUrl(WEIBO_URLS[random]);
            person.setId(random);
            persons.add(person);
        }
        return persons;
    }

    public static List<DouyuF4> getRandomPerson2(int count) {
        List<DouyuF4> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int random = (int) (Math.random() * 4);
            DouyuF4 person = new DouyuF4();
            person.setName(getRandomLengthString(NAMES[random]));
            person.setImageId(IMAGES[random]);
            persons.add(person);
        }
        return persons;
    }

    private static String getRandomLengthString(String origin) {
        StringBuilder sb = new StringBuilder();
        int random = (int) (Math.random() * 20) + 1;
        for (int i = 0; i < random; i++) {
            sb.append(origin);
        }
        return sb.toString();
    }
}
