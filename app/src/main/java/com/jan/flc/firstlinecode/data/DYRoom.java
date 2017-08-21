package com.jan.flc.firstlinecode.data;

import org.litepal.crud.DataSupport;

/**
 * Created by huangje on 2017/8/21.
 */

public class DYRoom extends DataSupport {

    private int id;
    private String title;
    private String host;
    private long roomNumber;
    private long concerns;
    private float gifts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getConcerns() {
        return concerns;
    }

    public void setConcerns(long concerns) {
        this.concerns = concerns;
    }

    public float getGifts() {
        return gifts;
    }

    public void setGifts(float gifts) {
        this.gifts = gifts;
    }
}
