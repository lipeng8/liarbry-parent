package com.yctu.liarbry.pojo;

import java.util.Date;

public class YctuLiarbryOut {
    private Integer bookId;

    private Integer outStId;

    private Integer outOpId;

    private Integer outStaus;

    private String outDate;

    private Date createDate;

    private String ext1;

    private String ext2;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getOutStId() {
        return outStId;
    }

    public void setOutStId(Integer outStId) {
        this.outStId = outStId;
    }

    public Integer getOutOpId() {
        return outOpId;
    }

    public void setOutOpId(Integer outOpId) {
        this.outOpId = outOpId;
    }

    public Integer getOutStaus() {
        return outStaus;
    }

    public void setOutStaus(Integer outStaus) {
        this.outStaus = outStaus;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate == null ? null : outDate.trim();
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