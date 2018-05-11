package com.yctu.liarbry.controller;

import com.yctu.liarbry.service.interfaces.IQryBooksCSV;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.utils.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:LiPeng
 * @Date:2018/4/20--18:24
 */
@Controller
public class booksController {
    @Autowired
    private IQryBooksCSV qryBooksCSV;

    @RequestMapping("/book/bookId")
    @ResponseBody
    public EUDataGridResult getByBookId(Integer bookId) {

        EUDataGridResult euDataGridResult = qryBooksCSV.qryBooksLoc(bookId,null);
        return euDataGridResult;
    }
    @RequestMapping("/book/bookName")
    @ResponseBody
    public EUDataGridResult getByBookId(String bookName) {

        EUDataGridResult euDataGridResult = qryBooksCSV.qryBooksLoc(0, EncodeUtil.EncodeUtil(bookName));
        return euDataGridResult;
    }

    /**
     * 图书列表
     * <p>@Description </p>
     * <p>@createDate 21:26 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @RequestMapping("/book/list")
    @ResponseBody
    public EUDataGridResult getBookList(Integer page, Integer rows) {
        EUDataGridResult euDataGridResult = qryBooksCSV.getBookList(page, rows);
        return euDataGridResult;
    }

    /**
     * 删除图书
     * <p>@Description </p>
     * <p>@createDate 21:26 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @RequestMapping("/book/delete")
    @ResponseBody
    public SuccessCode deleteBook(Integer bookId, Integer op_id) {
        SuccessCode successCode = qryBooksCSV.deleteBook(bookId,op_id);
        return successCode;
    }

    /**
     * 添加图书
     * <p>@Description </p>
     * <p>@createDate 16:37 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @RequestMapping("/book/insert")
    @ResponseBody
    public SuccessCode insertBook(String user,String user2,String book_loca,String book_name,String booktype,Double book_price,Integer book_number,
                                  Integer op_id,String ext1,String ext2) {
        SuccessCode successCode = qryBooksCSV.insertBook(EncodeUtil.EncodeUtil(user),EncodeUtil.EncodeUtil(user2),EncodeUtil.EncodeUtil(book_loca),EncodeUtil.EncodeUtil(book_name),booktype,book_price,book_number,op_id,EncodeUtil.EncodeUtil(ext1),EncodeUtil.EncodeUtil(ext2));
        return successCode;
    }
}
