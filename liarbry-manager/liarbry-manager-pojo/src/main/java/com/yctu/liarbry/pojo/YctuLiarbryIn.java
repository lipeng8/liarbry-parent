package com.yctu.liarbry.pojo;

import java.util.Date;

public class YctuLiarbryIn {
    private Integer bookId;

    private Integer inStId;

    private Integer inOpId;

    private Integer inStaus;

    private String inDate;

    private Date createDate;

    private String ext1;

    private String ext2;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getInStId() {
        return inStId;
    }

    public void setInStId(Integer inStId) {
        this.inStId = inStId;
    }

    public Integer getInOpId() {
        return inOpId;
    }

    public void setInOpId(Integer inOpId) {
        this.inOpId = inOpId;
    }

    public Integer getInStaus() {
        return inStaus;
    }

    public void setInStaus(Integer inStaus) {
        this.inStaus = inStaus;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate == null ? null : inDate.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }
}