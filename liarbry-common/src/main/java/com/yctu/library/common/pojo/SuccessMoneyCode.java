package com.yctu.library.common.pojo;

/**
 * @Author:LiPeng
 * @Date:2018/4/27--13:39
 */
public class SuccessMoneyCode {
    //返回标志
    private int rscode;
    //返回描述
    private String rsdec;
    //应扣钱数
    private String money;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
