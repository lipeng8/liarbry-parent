package com.yctu.library.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/27--13:39
 */
public class SuccessCode implements Serializable{
    //返回标志
    private int rscode;
    //返回描述
    private String rsdec;

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
}
