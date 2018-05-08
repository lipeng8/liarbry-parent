package com.yctu.liarbry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yctu.liarbry.pojo.*;
import com.yctu.liarbry.respojo.TeaStudent;
import com.yctu.liarbry.service.interfaces.*;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.liarbry.respojo.TeaQryStu;
import com.yctu.library.common.utils.SuccessUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--20:41
 */
@Service
public class TeaQryStuCSVImpl implements ITeaQryStuCSV {
    private static final Log log = LogFactory.getLog(TeaQryStuCSVImpl.class);
    @Autowired
    private IStudentsCSV studentsCSV;
    @Autowired
    private IBookOutCSV outCSV;
    @Autowired
    private IQryBooksCSV booksCSV;
    @Autowired
    private IQryBookTypeCSV bookTypeCSV;
    @Autowired
    private IBookHisCSV hisCSV;

    /**
     * 老师查询学生图书借阅情况
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public EUDataGridResult teaQryStu(Integer teacher_id, Integer page, Integer rows) {
        log.info("老师查询学生图书借阅情况：开始：teacher_id=" + teacher_id);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            //分页处理
            PageHelper.startPage(page, rows);
            List<YctuLiarbryStudents> students = studentsCSV.teaQryStu(teacher_id);
            List<TeaQryStu> teaQryStus = new ArrayList<TeaQryStu>();
            if (students != null && students.size() > 0) {
                for (YctuLiarbryStudents yctuLiarbryStudents : students) {
                    List<YctuLiarbryOut> outs = outCSV.qryBookOut(yctuLiarbryStudents.getStudentId());
                    for (YctuLiarbryOut yctuLiarbryOut : outs) {
                        TeaQryStu teaQryStu = new TeaQryStu();
                        teaQryStu.setStudent_name(yctuLiarbryStudents.getStudentName());
                        teaQryStu.setOut_date(yctuLiarbryOut.getOutDate());
                        if (yctuLiarbryOut.getOutStaus() == 1) {
                            teaQryStu.setOutStaus("借阅中");
                        } else {
                            teaQryStu.setOutStaus("借阅完毕");
                        }
                        YctuLiarbryBooks books = booksCSV.qryBooksLocation(yctuLiarbryOut.getBookId());
                        teaQryStu.setBook_name(books.getBookName());
                        YctuLiarbryBooktypes booktypes = bookTypeCSV.qryBookTypes(Integer.valueOf(books.getBookType()));
                        teaQryStu.setType_name(booktypes.getTypeName());
                        teaQryStu.setExt1(yctuLiarbryOut.getExt1());
                        teaQryStu.setExt2(yctuLiarbryOut.getExt2());
                        teaQryStus.add(teaQryStu);
                    }
                }
            } else {
                throw new Exception("14");
            }

            //创建一个返回值对象
            EUDataGridResult euDataGridResult = new EUDataGridResult();
            euDataGridResult.setRows(teaQryStus);
            //取出total
            PageInfo<TeaQryStu> pageInfo = new PageInfo<>(teaQryStus);
            long total = teaQryStus.size();
            euDataGridResult.setTotal(total);
            return euDataGridResult;

        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(0);
                his.setStId(teacher_id);
                his.setType("教师关爱学生");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(0);
                his.setStId(teacher_id);
                his.setType("教师关爱学生");
            }
            hisCSV.insertHis(his);
            log.info("老师查询学生图书借阅情况：结束：teacher_id=" + teacher_id);
        }
        return null;
    }
    /**
     * 学生图书借阅情况
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public EUDataGridResult QryStu( Integer page, Integer rows) {
        log.info("学生图书借阅情况：开始：" );
            //分页处理
            PageHelper.startPage(page, rows);
            List<YctuLiarbryStudents> students = studentsCSV.QryStu();
            List<TeaQryStu> teaQryStus = new ArrayList<TeaQryStu>();
            if (students != null && students.size() > 0) {
                for (YctuLiarbryStudents yctuLiarbryStudents : students) {
                    List<YctuLiarbryOut> outs = outCSV.qryBookOut(yctuLiarbryStudents.getStudentId());
                    for (YctuLiarbryOut yctuLiarbryOut : outs) {
                        TeaQryStu teaQryStu = new TeaQryStu();
                        teaQryStu.setStudent_name(yctuLiarbryStudents.getStudentName());
                        teaQryStu.setOut_date(yctuLiarbryOut.getOutDate());
                        if (yctuLiarbryOut.getOutStaus() == 1) {
                            teaQryStu.setOutStaus("借阅中");
                        } else {
                            teaQryStu.setOutStaus("借阅完毕");
                        }
                        YctuLiarbryBooks books = booksCSV.qryBooksLocation(yctuLiarbryOut.getBookId());
                        teaQryStu.setBook_name(books.getBookName());
                        YctuLiarbryBooktypes booktypes = bookTypeCSV.qryBookTypes(Integer.valueOf(books.getBookType()));
                        teaQryStu.setType_name(booktypes.getTypeName());
                        teaQryStu.setExt1(yctuLiarbryOut.getExt1());
                        teaQryStu.setExt2(yctuLiarbryOut.getExt2());
                        teaQryStus.add(teaQryStu);
                    }
                }
            //创建一个返回值对象
            EUDataGridResult euDataGridResult = new EUDataGridResult();
            euDataGridResult.setRows(teaQryStus);
            //取出total
            PageInfo<TeaQryStu> pageInfo = new PageInfo<>(teaQryStus);
            long total = teaQryStus.size();
            euDataGridResult.setTotal(total);
                log.info("学生图书借阅情况：结束：" );
            return euDataGridResult;
            }
        return null;
    }
    /**
     * 老师查询学生
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public EUDataGridResult student(Integer teacher_id, Integer page, Integer rows) {
        log.info("老师查询学生：开始： teacher_id=" +teacher_id);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            //分页处理
            PageHelper.startPage(page, rows);
            List<YctuLiarbryStudents> students = studentsCSV.teaQryStu(teacher_id);
            List<TeaStudent> teaStudents = new ArrayList<TeaStudent>();
            if (students != null && students.size() > 0) {
                for (YctuLiarbryStudents yctuLiarbryStudents : students) {
                    TeaStudent teaStudent = new TeaStudent();
                    teaStudent.setStudent_id(yctuLiarbryStudents.getStudentId());
                    teaStudent.setStudent_name(yctuLiarbryStudents.getStudentName());
                    teaStudent.setStudent_class(yctuLiarbryStudents.getStudentClass());
                    teaStudent.setStudentBooknbs(yctuLiarbryStudents.getStudentBooknbs()+"本");
                    teaStudent.setExt1(yctuLiarbryStudents.getExt1());
                    teaStudent.setExt2(yctuLiarbryStudents.getExt2());
                    List<YctuLiarbryOut> outs = outCSV.qryBookOut(yctuLiarbryStudents.getStudentId());
                    teaStudent.setStudentBooks(outs.size()+"本");
                    teaStudents.add(teaStudent);
                }
            } else {
                throw new Exception("14");
            }

            //创建一个返回值对象
            EUDataGridResult euDataGridResult = new EUDataGridResult();
            euDataGridResult.setRows(teaStudents);
            //取出total
            PageInfo<TeaStudent> pageInfo = new PageInfo<>(teaStudents);
            long total = teaStudents.size();
            euDataGridResult.setTotal(total);
            return euDataGridResult;

        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(0);
                his.setStId(teacher_id);
                his.setType("老师查询学生");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(0);
                his.setStId(teacher_id);
                his.setType("老师查询学生");
            }
            hisCSV.insertHis(his);
            log.info("老师查询学生：结束： teacher_id=" +teacher_id);
        }
        return null;
    }
    /**
     * 老师查询学生信息根据学生编号
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
   public EUDataGridResult qryStudentById(Integer teacher_id,Integer studentId, Integer page, Integer rows){
       log.info("老师查询学生信息根据学生编号：开始： teacher_id=" +teacher_id);
       //分页处理
       PageHelper.startPage(page, rows);
       List<YctuLiarbryStudents> students = studentsCSV.studentByIdOrNname(teacher_id,studentId,null);
       List<TeaStudent> teaStudents = new ArrayList<TeaStudent>();
       if (students != null && students.size() > 0) {
           for (YctuLiarbryStudents yctuLiarbryStudents : students) {
               TeaStudent teaStudent = new TeaStudent();
               teaStudent.setStudent_id(yctuLiarbryStudents.getStudentId());
               teaStudent.setStudent_name(yctuLiarbryStudents.getStudentName());
               teaStudent.setStudent_class(yctuLiarbryStudents.getStudentClass());
               teaStudent.setStudentBooknbs(yctuLiarbryStudents.getStudentBooknbs()+"本");
               teaStudent.setExt1(yctuLiarbryStudents.getExt1());
               teaStudent.setExt2(yctuLiarbryStudents.getExt2());
               List<YctuLiarbryOut> outs = outCSV.qryBookOut(yctuLiarbryStudents.getStudentId());
               teaStudent.setStudentBooks(outs.size()+"本");
               teaStudents.add(teaStudent);
           }
       }
       //创建一个返回值对象
       EUDataGridResult euDataGridResult = new EUDataGridResult();
       euDataGridResult.setRows(teaStudents);
       //取出total
       PageInfo<TeaStudent> pageInfo = new PageInfo<>(teaStudents);
       long total =teaStudents.size();
       euDataGridResult.setTotal(total);
       log.info("老师查询学生信息根据学生编号：结束： teacher_id=" +teacher_id);
       return euDataGridResult;
   }
    /**
     * 老师查询学生信息根据学生姓名
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryStudentByName(Integer teacher_id,String studentName, Integer page, Integer rows){
        log.info("老师查询学生信息根据学生姓名：开始： teacher_id=" +teacher_id);
        //分页处理
        PageHelper.startPage(page, rows);
        List<YctuLiarbryStudents> students = studentsCSV.studentByIdOrNname(teacher_id,0,studentName);
        List<TeaStudent> teaStudents = new ArrayList<TeaStudent>();
        if (students != null && students.size() > 0) {
            for (YctuLiarbryStudents yctuLiarbryStudents : students) {
                TeaStudent teaStudent = new TeaStudent();
                teaStudent.setStudent_id(yctuLiarbryStudents.getStudentId());
                teaStudent.setStudent_name(yctuLiarbryStudents.getStudentName());
                teaStudent.setStudent_class(yctuLiarbryStudents.getStudentClass());
                teaStudent.setStudentBooknbs(yctuLiarbryStudents.getStudentBooknbs()+"本");
                teaStudent.setExt1(yctuLiarbryStudents.getExt1());
                teaStudent.setExt2(yctuLiarbryStudents.getExt2());
                List<YctuLiarbryOut> outs = outCSV.qryBookOut(yctuLiarbryStudents.getStudentId());
                teaStudent.setStudentBooks(outs.size()+"本");
                teaStudents.add(teaStudent);
            }
        }
        //创建一个返回值对象
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(teaStudents);
        //取出total
        PageInfo<TeaStudent> pageInfo = new PageInfo<>(teaStudents);
        long total = teaStudents.size();
        euDataGridResult.setTotal(total);
        log.info("老师查询学生信息根据学生姓名：开始： teacher_id=" +teacher_id);
        return euDataGridResult;
    }
}
