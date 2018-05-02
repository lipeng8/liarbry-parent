package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryBooks;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;

/**
 * @Author:LiPeng
 * @Date:2018/4/20--18:03
 */
public interface IQryBooksCSV {
    /**
     * 查询图书位置
     * <p>@Description </p>
     * <p>@createDate 14:26 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult qryBooksLoc(Integer bookId,String bookName);
    /**
     * 查询图书位置
     * <p>@Description </p>
     * <p>@createDate 14:26 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    YctuLiarbryBooks qryBooksLocation(Integer bookId);

    /**
     * 获取图书列表
     * <p>@Description </p>
     * <p>@createDate 14:26 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult getBookList(Integer page, Integer rows);
    /**
     * 删除图书
     * <p>@Description </p>
     * <p>@createDate 15:31 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    SuccessCode deleteBook(Integer bookId, Integer op_id);
    /**
     * 添加图书
     *<p>@Description </p>
     *<p>@createDate 16:37 2018/4/28</p>
     *@author lipeng
     *@param
     *@return
     */
   SuccessCode insertBook(YctuLiarbryBooks books, Integer op_id);
    /**修改图书信息
     *<p>@Description </p>
     *<p>@createDate 19:27 2018/4/28</p>
     *@author lipeng
     *@param
     *@return
     */
    void updateBook(Integer book_id, YctuLiarbryBooks books);
}
