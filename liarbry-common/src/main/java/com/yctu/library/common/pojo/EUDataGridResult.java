package com.yctu.library.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/22--20:24
 */
public class EUDataGridResult implements Serializable{
    private long total ;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
