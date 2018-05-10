package com.yctu.liarbry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yctu.liarbry.mapper.YctuLiarbryDsbook022018Mapper;
import com.yctu.liarbry.pojo.*;
import com.yctu.liarbry.respojo.DsBook;
import com.yctu.liarbry.service.interfaces.*;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.utils.SuccessUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:34
 */
@Service
public class DsBookCSVImpl implements IDsBookCSV {
    /**
     * 全局log
     */
    private static final Log log = LogFactory.getLog(DsBookCSVImpl.class);
    @Autowired
    private YctuLiarbryDsbook022018Mapper mapper;
    @Autowired
    private IBookHisCSV hisCSV;
    @Autowired
    private IQryBooksCSV booksCSV;
    @Autowired
    private IStudentsCSV studentsCSV;
    @Autowired
    private ITeacherCSV teacherCSV;
    @Autowired
    private ILibraryOpCSV libraryOpCSV;

    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:58 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public List<YctuLiarbryDsbook022018> qryDsBook(Integer st_id) {
        log.info("损坏记录查询开始：st_id=" + st_id);
        YctuLiarbryDsbook022018Example example = new YctuLiarbryDsbook022018Example();
        //添加查询条件
        YctuLiarbryDsbook022018Example.Criteria criteria = example.createCriteria();
        criteria.andStIdEqualTo(st_id);
        List<YctuLiarbryDsbook022018> list = mapper.selectByExample(example);
        log.info("损坏记录查询结束：st_id=" + st_id);
        return list;
    }

    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:59 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryDsBookByStId(Integer st_id, Integer page, Integer rows) {
        log.info("损坏记录查询开始：st_id=" + st_id);
        YctuLiarbryDsbook022018Example example = new YctuLiarbryDsbook022018Example();
        //添加查询条件
        YctuLiarbryDsbook022018Example.Criteria criteria = example.createCriteria();
        criteria.andStIdEqualTo(st_id);
        PageHelper.startPage(page, rows);
        List<YctuLiarbryDsbook022018> dsbook022018s = mapper.selectByExample(example);
        List<DsBook> dsBooks = new ArrayList<DsBook>();
        for (YctuLiarbryDsbook022018 dsbook022018 : dsbook022018s) {
            DsBook dsBook = new DsBook();
            YctuLiarbryStudents students = studentsCSV.qryStduent(dsbook022018.getStId());
            if (students == null) {
                YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(dsbook022018.getStId());
                dsBook.setStId(teachers.getTeacherId());
                dsBook.setStName(teachers.getTeacherName());
            } else {
                dsBook.setStId(students.getStudentId());
                dsBook.setStName(students.getStudentName());
            }
            YctuLiarbryOp op = libraryOpCSV.qryOpName(dsbook022018.getOpId());
            dsBook.setOpId(op.getOpId());
            dsBook.setOpName(op.getOpName());
            YctuLiarbryBooks books = booksCSV.qryBooksLocation(dsbook022018.getBookId());
            dsBook.setBookId(books.getBookId());
            dsBook.setBookName(books.getBookName());
            if (Integer.valueOf(dsbook022018.getMoney()) != 0) {
                dsBook.setMoney(dsbook022018.getMoney() + "元");
            } else {
                dsBook.setMoney("部分破损不影响借阅" + "元");
            }
            dsBook.setCreateDate(dsbook022018.getCreateDate());
            dsBooks.add(dsBook);
        }
        //创建一个返回值对象
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(dsBooks);
        //取出total
        PageInfo<DsBook> pageInfo = new PageInfo<>(dsBooks);
        long total = dsBooks.size();
        euDataGridResult.setTotal(total);
        log.info("损坏记录查询结束：st_id=" + st_id);
        return euDataGridResult;
    }

    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:59 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryDsBookByOp(Integer op_id, Integer page, Integer rows) {
        log.info("损坏记录查询开始：op_id=" + op_id);
        YctuLiarbryDsbook022018Example example = new YctuLiarbryDsbook022018Example();
        //添加查询条件
        YctuLiarbryDsbook022018Example.Criteria criteria = example.createCriteria();
        criteria.andOpIdEqualTo(op_id);
        PageHelper.startPage(page, rows);
        List<YctuLiarbryDsbook022018> dsbook022018s = mapper.selectByExample(example);
        List<DsBook> dsBooks = new ArrayList<DsBook>();
        for (YctuLiarbryDsbook022018 dsbook022018 : dsbook022018s) {
            DsBook dsBook = new DsBook();
            YctuLiarbryStudents students = studentsCSV.qryStduent(dsbook022018.getStId());
            if (students == null) {
                YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(dsbook022018.getStId());
                dsBook.setStId(teachers.getTeacherId());
                dsBook.setStName(teachers.getTeacherName());
            } else {
                dsBook.setStId(students.getStudentId());
                dsBook.setStName(students.getStudentName());
            }
            YctuLiarbryOp op = libraryOpCSV.qryOpName(dsbook022018.getOpId());
            dsBook.setOpId(op.getOpId());
            dsBook.setOpName(op.getOpName());
            YctuLiarbryBooks books = booksCSV.qryBooksLocation(dsbook022018.getBookId());
            dsBook.setBookId(books.getBookId());
            dsBook.setBookName(books.getBookName());
            if (Integer.valueOf(dsbook022018.getMoney()) != 0) {
                dsBook.setMoney(dsbook022018.getMoney() + "元");
            } else {
                dsBook.setMoney("部分破损不影响借阅" + "元");
            }
            dsBook.setCreateDate(dsbook022018.getCreateDate());
            dsBooks.add(dsBook);
        }
        //创建一个返回值对象
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(dsBooks);
        //取出total
        PageInfo<DsBook> pageInfo = new PageInfo<>(dsBooks);
        long total = dsBooks.size();
        euDataGridResult.setTotal(total);
        log.info("损坏记录查询结束：op_id=" + op_id);
        return euDataGridResult;
    }

    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:59 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryDsBook(Integer page, Integer rows) {
        log.info("损坏记录查询开始：");
        //执行查询 分页
        YctuLiarbryDsbook022018Example example = new YctuLiarbryDsbook022018Example();
        PageHelper.startPage(page, rows);
        List<YctuLiarbryDsbook022018> dsbook022018s = mapper.selectByExample(example);

        List<DsBook> dsBooks = new ArrayList<DsBook>();
        for (YctuLiarbryDsbook022018 dsbook022018 : dsbook022018s) {
            DsBook dsBook = new DsBook();
            YctuLiarbryStudents students = studentsCSV.qryStduent(dsbook022018.getStId());
            if (students == null) {
                YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(dsbook022018.getStId());
                dsBook.setStId(teachers.getTeacherId());
                dsBook.setStName(teachers.getTeacherName());
            } else {
                dsBook.setStId(students.getStudentId());
                dsBook.setStName(students.getStudentName());
            }
            YctuLiarbryOp op = libraryOpCSV.qryOpName(dsbook022018.getOpId());
            dsBook.setOpId(op.getOpId());
            dsBook.setOpName(op.getOpName());
            YctuLiarbryBooks books = booksCSV.qryBooksLocation(dsbook022018.getBookId());
            dsBook.setBookId(books.getBookId());
            dsBook.setBookName(books.getBookName());
            if (Integer.valueOf(dsbook022018.getMoney()) != 0) {
                dsBook.setMoney(dsbook022018.getMoney() + "元");
            } else {
                dsBook.setMoney("部分破损不影响借阅" + "元");
            }
            dsBook.setCreateDate(dsbook022018.getCreateDate());
            dsBooks.add(dsBook);
        }
        //创建一个返回值对象
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(dsBooks);
        //取出total
        PageInfo<DsBook> pageInfo = new PageInfo<>(dsBooks);
        long total = dsBooks.size();
        euDataGridResult.setTotal(total);
        log.info("损坏记录查询结束：");
        return euDataGridResult;
    }

    /**
     * 添加损坏记录
     * <p>@Description </p>
     * <p>@createDate 13:54 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void insertDSBook(YctuLiarbryDsbook022018 dsbook) {
        log.info("添加损坏记录开始：opid=" + dsbook.getOpId());
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            mapper.insert(dsbook);
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(rscode);
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(dsbook.getOpId());
                his.setStId(dsbook.getStId());
                his.setType("损坏记录");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(dsbook.getOpId());
                his.setStId(dsbook.getStId());
                his.setType("损坏记录");
            }
            hisCSV.insertHis(his);
            log.info("添加损坏记录结束：opid=" + dsbook.getOpId());
        }
    }
}
