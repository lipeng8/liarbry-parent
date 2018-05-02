package com.yctu.liarbry.pojo;

import java.util.Date;

public class YctuLiarbryTeachers {
    private Integer teacherId;

    private String teacherPwd;

    private String teacherName;

    private Integer teacherClass;

    private Date createDate;

    private Integer teacherBooknbs;

    private String ext1;

    private String ext2;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd == null ? null : teacherPwd.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Integer getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(Integer teacherClass) {
        this.teacherClass = teacherClass;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getTeacherBooknbs() {
        return teacherBooknbs;
    }

    public void setTeacherBooknbs(Integer teacherBooknbs) {
        this.teacherBooknbs = teacherBooknbs;
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