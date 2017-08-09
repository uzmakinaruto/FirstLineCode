package com.jan.flc.firstlinecode.data;

/**
 * Created by huangje on 17-3-10.
 */

public class ChatMessage {

    public static final int MESSAGE_TYPE_SEND = 0;
    public static final int MESSAGE_TYPE_RECEIVE = 1;
    private int messageType;
    private int imageId;
    private String name;
    private String message;

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
