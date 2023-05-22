package com.example.myapplication.object;

public class book {
    private String bookName, booknum, picLink;
    public book() {

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
