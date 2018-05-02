package com.yctu.liarbry.pojo;

import java.io.Serializable;

/**
 * @Author:LiPeng
 * @Date:2018/4/29--14:35
 */
public class Param implements Serializable {
    //Integer lg_id, String lg_pwd, Integer lg_type
    private Integer lg_id;
    private String lg_pwd;
    private Integer lg_type;

    public Integer getLg_id() {
        return lg_id;
    }

    public void setLg_id(Integer lg_id) {
        this.lg_id = lg_id;
    }

    public String getLg_pwd() {
        return lg_pwd;
    }

    public void setLg_pwd(String lg_pwd) {
        this.lg_pwd = lg_pwd;
    }

    public Integer getLg_type() {
        return lg_type;
    }

    public void setLg_type(Integer lg_type) {
        this.lg_type = lg_type;
    }
}
