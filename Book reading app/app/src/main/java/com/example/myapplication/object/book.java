package com.example.myapplication.object;

import org.json.JSONException;
import org.json.JSONObject;

public class book {
    private String bookName, booknum, picLink;
    public book() {

    }
    public book(JSONObject o) throws JSONException {
        bookName = o.getString("bookName");
        booknum = o.getString("booknum");
        picLink = o.getString("picLink");
    }
    public book(String bookName, String booknum, String picLink) {
        this.bookName = bookName;
        this.booknum = booknum;
        this.picLink = picLink;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBooknum() {
        return booknum;
    }

    public void setBooknum(String booknum) {
        this.booknum = booknum;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }
}
