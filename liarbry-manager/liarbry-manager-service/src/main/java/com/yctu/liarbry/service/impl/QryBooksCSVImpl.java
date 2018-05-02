package com.yctu.liarbry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yctu.liarbry.mapper.YctuLiarbryBooksMapper;
import com.yctu.liarbry.pojo.*;
import com.yctu.liarbry.service.interfaces.IBookHisCSV;
import com.yctu.liarbry.service.interfaces.ILibraryOpCSV;
import com.yctu.liarbry.service.interfaces.IQryBookTypeCSV;
import com.yctu.liarbry.service.interfaces.IQryBooksCSV;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.utils.SuccessUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 图书管理service
 *
 * @Author:LiPeng
 * @Date:2018/4/20--18:04
 */
@Service
public class QryBooksCSVImpl implements IQryBooksCSV {
    @Autowired
    private YctuLiarbryBooksMapper liarbryBooksMapper;
    @Autowired
    private IBookHisCSV hisCSV;
    @Autowired
    private ILibraryOpCSV libraryOpCSV;
    @Autowired
    private IQryBookTypeCSV bookTypeCSV;

    /**
     * 查询图书位置
     * <p>@Description </p>
     * <p>@createDate 14:26 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
   public EUDataGridResult qryBooksLoc(Integer bookId,String bookName){
       //执行查询 分页
       YctuLiarbryBooksExample example = new YctuLiarbryBooksExample();
       YctuLiarbryBooksExample.Criteria criteria = example.createCriteria();
       if (StringUtils.isBlank(bookName)) {
           criteria.andBookIdEqualTo(bookId);
       }else {
           criteria.andBookNameLike("%"+bookName+"%");
       }
       //分页处理
       PageHelper.startPage(1, 30);
       List<YctuLiarbryBooks> yctuLiarbryBooksList = liarbryBooksMapper.selectByExample(example);
       for (YctuLiarbryBooks books:yctuLiarbryBooksList){
           YctuLiarbryBooktypes booktypes=bookTypeCSV.qryBookTypes(Integer.valueOf(books.getBookType()));
           if (booktypes==null  || booktypes.getTypeName() == null) {
               books.setBookType(booktypes.getTypeName());
           }
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

           java.util.Date time=null;
           try {
               time= sdf.parse(sdf.format(books.getCreateDate()));

           } catch (ParseException e) {

               e.printStackTrace();
           }
           books.setCreateDate(time);
       }
       //创建一个返回值对象
       EUDataGridResult euDataGridResult = new EUDataGridResult();
       euDataGridResult.setRows(yctuLiarbryBooksList);
       //取出total
       PageInfo<YctuLiarbryBooks> pageInfo = new PageInfo<>(yctuLiarbryBooksList);
       long total = pageInfo.getTotal();
       euDataGridResult.setTotal(total);
       return euDataGridResult;
   }

    /**
     * 查询图书位置
     * <p>@Description </p>
     * <p>@createDate 14:27 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public YctuLiarbryBooks qryBooksLocation(Integer bookId) {
//        YctuLiarbryBooks yctuLiarbryBooks = liarbryBooksMapper.selectByPrimaryKey(bookid);
        YctuLiarbryBooksExample yctuLiarbryBooksExample = new YctuLiarbryBooksExample();
        //添加查询条件
        YctuLiarbryBooksExample.Criteria criteria = yctuLiarbryBooksExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        List<YctuLiarbryBooks> yctuLiarbryBooks = liarbryBooksMapper.selectByExample(yctuLiarbryBooksExample);
        if (yctuLiarbryBooks != null && yctuLiarbryBooks.size() > 0) {
            YctuLiarbryBooks liarbryBooks = yctuLiarbryBooks.get(0);
            return liarbryBooks;
        }
        return null;
    }

    /**
     * 图书列表
     * <p>@Description </p>
     * <p>@createDate 20:30 2018/4/22</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult getBookList(Integer page, Integer rows) {
        //执行查询 分页
        YctuLiarbryBooksExample example = new YctuLiarbryBooksExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<YctuLiarbryBooks> list = liarbryBooksMapper.selectByExample(example);
        for (YctuLiarbryBooks yctuLiarbryBooks:list){
            YctuLiarbryBooktypes booktypes=bookTypeCSV.qryBookTypes(Integer.valueOf(yctuLiarbryBooks.getBookType()));
            //处理图书科目问题
            if (booktypes==null  || booktypes.getTypeName() == null) {
                yctuLiarbryBooks.setBookType(booktypes.getTypeName());
            }else {
                yctuLiarbryBooks.setBookType(yctuLiarbryBooks.getBookType());
            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date time=null;
            try {
                time= sdf.parse(sdf.format(yctuLiarbryBooks.getCreateDate()));

            } catch (ParseException e) {

                e.printStackTrace();
            }
            yctuLiarbryBooks.setCreateDate(time);
        }
        //创建一个返回值对象
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(list);
        //取出total
        PageInfo<YctuLiarbryBooks> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        euDataGridResult.setTotal(total);
        return euDataGridResult;
    }

    /**
     * 删除图书
     * <p>@Description </p>
     * <p>@createDate 15:31 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public SuccessCode deleteBook(Integer bookId, Integer op_id) {
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryOp op = libraryOpCSV.qryOpName(op_id);
            if (op == null) {
                throw new Exception("06");
            }
            if (op.getOpType()<= 2) {
                throw new Exception("01");
            }
            YctuLiarbryBooksExample yctuLiarbryBooksExample = new YctuLiarbryBooksExample();
            //添加查询条件
            YctuLiarbryBooksExample.Criteria criteria = yctuLiarbryBooksExample.createCriteria();
            criteria.andBookIdEqualTo(bookId);
            List<YctuLiarbryBooks> yctuLiarbryBooks = liarbryBooksMapper.selectByExample(yctuLiarbryBooksExample);
            if (yctuLiarbryBooks == null && yctuLiarbryBooks.size() <= 0) {
                throw new Exception("05");
            }
            liarbryBooksMapper.deleteByExample(yctuLiarbryBooksExample);

        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(op_id);
                his.setStId(0);
                his.setType("删除图书");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(op_id);
                his.setStId(0);
                his.setType("删除图书");
            }
            hisCSV.insertHis(his);
            return successCode;
        }
    }
    /**
     * 添加图书
     *<p>@Description </p>
     *<p>@createDate 16:37 2018/4/28</p>
     *@author lipeng
     *@param
     *@return
     */
    public SuccessCode insertBook(YctuLiarbryBooks books, Integer op_id){
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryOp op = libraryOpCSV.qryOpName(op_id);
            if (op == null) {
                throw new Exception("06");
            }else{
                if (op.getOpType()<=2){
                    throw new Exception("01");
                }
            }
            YctuLiarbryBooksExample yctuLiarbryBooksExample = new YctuLiarbryBooksExample();
            //添加查询条件
            YctuLiarbryBooksExample.Criteria criteria = yctuLiarbryBooksExample.createCriteria();
            criteria.andBookIdEqualTo(books.getBookId());
            criteria.andBookNameEqualTo(books.getBookName());
            List<YctuLiarbryBooks> yctuLiarbryBooks = liarbryBooksMapper.selectByExample(yctuLiarbryBooksExample);
            if (yctuLiarbryBooks != null && yctuLiarbryBooks.size() > 0) {
                throw new Exception("07");
            }
           liarbryBooksMapper.insert(books);

        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(op_id);
                his.setStId(0);
                his.setType("添加图书");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(op_id);
                his.setStId(0);
                his.setType("添加图书");
            }
            hisCSV.insertHis(his);
            return successCode;
        }
    }
     /**修改图书信息
      *<p>@Description </p>
      *<p>@createDate 19:27 2018/4/28</p>
      *@author lipeng
      *@param
      *@return
      */
    @Override
    public void updateBook(Integer book_id, YctuLiarbryBooks books) {
        YctuLiarbryBooksExample example = new YctuLiarbryBooksExample();
        //添加查询条件
        YctuLiarbryBooksExample.Criteria criteria = example.createCriteria();
        criteria.andBookIdEqualTo(book_id);
        liarbryBooksMapper.updateByExample(books, example);
    }
}
