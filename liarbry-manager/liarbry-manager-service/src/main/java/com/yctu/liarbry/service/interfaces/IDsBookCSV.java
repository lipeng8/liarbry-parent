package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryDsbook022018;
import com.yctu.library.common.pojo.SuccessCode;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:34
 */
public interface IDsBookCSV {
    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:59 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    List<YctuLiarbryDsbook022018> qryDsBook(Integer st_id);

    /**
     * 添加损坏记录
     * <p>@Description </p>
     * <p>@createDate 13:54 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void insertDSBook(YctuLiarbryDsbook022018 dsbook);
}
