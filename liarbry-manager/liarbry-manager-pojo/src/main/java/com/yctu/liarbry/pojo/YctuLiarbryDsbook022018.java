package com.yctu.liarbry.pojo;

import java.util.Date;

public class YctuLiarbryDsbook022018 extends YctuLiarbryDsbook022018Key {
    private Integer opId;

    private String money;

    private Date createDate;

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}