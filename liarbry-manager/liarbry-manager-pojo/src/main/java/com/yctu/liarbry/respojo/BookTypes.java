package com.yctu.liarbry.respojo;

import java.io.Serializable;

/**
 * @Author:LiPeng
 * @Date:2018/5/5--15:05
 */
public class BookTypes implements Serializable {
    private String bookType;
    private String bookName;

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
