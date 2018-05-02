package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryIn;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.pojo.SuccessMoneyCode;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:36
 */
public interface IBookInCSV {
    /**
     * 还书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:53 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult qryBookInname(Integer in_st_id,String studentName,  Integer page, Integer rows);
    /**
     * 还书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:53 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult qryBookIn( Integer page, Integer rows);

    /**
     * 添加还书记录
     * <p>@Description </p>
     * <p>@createDate 13:53 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    SuccessMoneyCode insertIn(YctuLiarbryIn in);

}
