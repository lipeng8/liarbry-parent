package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryOp;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:37
 */
public interface ILibraryOpCSV {
    /**
     * 查询操作员
     *<p>@Description </p>
     *<p>@createDate 16:02 2018/4/26</p>
     *@author lipeng
     *@param
     *@return
     */
    YctuLiarbryOp qryOpName(Integer op_id);
    /**
     * 添加操作员
     *<p>@Description </p>
     *<p>@createDate 13:50 2018/4/27</p>
     *@author lipeng
     *@param
     *@return
     */
    void insertOp(YctuLiarbryOp op);
    /**删除操作员by op_id
     *<p>@Description </p>
     *<p>@createDate 13:57 2018/4/27</p>
     *@author lipeng
     *@param
     *@return
     */
  void deleteOp(Integer op_id) ;
    /**删除操作员根据姓名
     *<p>@Description </p>
     *<p>@createDate 13:59 2018/4/27</p>
     *@author lipeng
     *@param
     *@return
     */
   void deleteOp(String op_name);
    /**更改操作员信息
     *<p>@Description </p>
     *<p>@createDate 14:00 2018/4/27</p>
     *@author lipeng
     *@param
     *@return
     */
    void updateOp(Integer op_id ,YctuLiarbryOp op);
}
