package com.tommy.chat.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Message {
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private Date date = new Date();
    private String content;
    private String sender;
    private String time = dateFormat.format(date);

    @Override
    public String toString() {
        return time + ": " + sender + ": " + content;
    }
}
