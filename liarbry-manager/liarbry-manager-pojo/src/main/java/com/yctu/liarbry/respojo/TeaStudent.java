package com.yctu.liarbry.respojo;

import java.io.Serializable;

/**
 * @Author:LiPeng
 * @Date:2018/5/1--18:19
 */
public class TeaStudent implements Serializable{
    private Integer student_id;

    private String student_name;

    private Integer student_class;

    private String studentBooknbs;

    private String studentBooks;

    private String ext1;

    private String ext2;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getStudent_class() {
        return student_class;
    }

    public void setStudent_class(Integer student_class) {
        this.student_class = student_class;
    }

    public String getStudentBooknbs() {
        return studentBooknbs;
    }

    public void setStudentBooknbs(String studentBooknbs) {
        this.studentBooknbs = studentBooknbs;
    }

    public String getStudentBooks() {
        return studentBooks;
    }

    public void setStudentBooks(String studentBooks) {
        this.studentBooks = studentBooks;
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
}
