package com.ciklum.spocksample.obj;

/**
 * @author tsv@ciklum.com
 */
public class Message {

    private String text;
    private long size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
