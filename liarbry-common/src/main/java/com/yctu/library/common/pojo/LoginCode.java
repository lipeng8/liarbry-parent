package com.yctu.library.common.pojo;

import java.io.Serializable;

/**
 * @Author:LiPeng
 * @Date:2018/5/1--20:15
 */
public class LoginCode implements Serializable {
    //返回标志
    private int rscode;
    //返回描述
    private String rsdec;
    //登陆人员名称
    private String name;

    public int getRscode() {
        return rscode;
    }

    public void setRscode(int rscode) {
        this.rscode = rscode;
    }

    public String getRsdec() {
        return rsdec;
    }

    public void setRsdec(String rsdec) {
        this.rsdec = rsdec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
