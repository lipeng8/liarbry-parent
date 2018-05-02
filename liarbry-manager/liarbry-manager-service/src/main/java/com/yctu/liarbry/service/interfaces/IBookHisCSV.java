package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryHis;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:35
 */
public interface IBookHisCSV {
    /**
     * 历史查询
     * <p>@Description </p>
     * <p>@createDate 15:50 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    List<YctuLiarbryHis> qryBookHis(Integer st_id);

    /**
     * 添加记录
     * <p>@Description </p>
     * <p>@createDate 13:56 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void insertHis(YctuLiarbryHis his);
}
