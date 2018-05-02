package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryOut;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.pojo.SuccessMoneyCode;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:36
 */
public interface IBookOutCSV {
    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 18:56 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    List<YctuLiarbryOut> qryBookOut(Integer out_st_id, Integer book_id);

    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 18:56 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    List<YctuLiarbryOut> qryBookOut(Integer out_st_id);

    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:55 2018/4/26</p>
     *teaOutQry
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult qryBookOutList(String studentName,Integer out_st_id, Integer page, Integer rows);
    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:55 2018/4/26</p>
     *teaOutQry
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult teaOutQry(Integer teacher_id, String studentName,Integer out_st_id, Integer page, Integer rows);
    /**
     * 添加借书记录
     * <p>@Description </p>
     * <p>@createDate 13:52 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    SuccessCode insertOut(YctuLiarbryOut out);

    /**
     * 删除借书记录 by st_id
     * <p>@Description </p>
     * <p>@createDate 13:57 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    SuccessMoneyCode deleteOut(Integer out_st_id, Integer book_id);

    /**
     * 更改借书信息
     * <p>@Description </p>
     * <p>@createDate 14:00 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    SuccessCode updateOut(Integer out_st_id, Integer book_id,YctuLiarbryOut out);
}
