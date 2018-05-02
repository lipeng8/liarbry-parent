package com.yctu.liarbry.respojo;

import java.io.Serializable;

/**
 * @Author:LiPeng
 * @Date:2018/5/2--15:33
 */
public class Inbookqry implements Serializable{
    private String type_name;
    private String ext1;
    private String ext2;
    private String student_name;
    private String op_name;
    private String book_name;
    private String in_date;
    //图书是否损坏
    private String inStaus;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getOp_name() {
        return op_name;
    }

    public void setOp_name(String op_name) {
        this.op_name = op_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getIn_date() {
        return in_date;
    }

    public void setIn_date(String in_date) {
        this.in_date = in_date;
    }

    public String getInStaus() {
        return inStaus;
    }

    public void setInStaus(String inStaus) {
        this.inStaus = inStaus;
    }
}
