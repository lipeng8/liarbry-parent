package com.yctu.liarbry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yctu.liarbry.mapper.YctuLiarbryOutMapper;
import com.yctu.liarbry.pojo.*;
import com.yctu.liarbry.respojo.TeaQryStu;
import com.yctu.liarbry.service.interfaces.*;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.pojo.SuccessMoneyCode;
import com.yctu.library.common.utils.BookTimeUtil;
import com.yctu.library.common.utils.SuccessUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:36
 */
@Service
public class BookOutCSVImpl implements IBookOutCSV {
    /**
     * 全局log
     */
    private static final Log log = LogFactory.getLog(BookOutCSVImpl.class);
    @Autowired
    private YctuLiarbryOutMapper mapper;
    @Autowired
    private IQryBooksCSV booksCSV;
    @Autowired
    private IStudentsCSV studentsCSV;
    @Autowired
    private ITeacherCSV teacherCSV;
    @Autowired
    private ILibraryOpCSV libraryOpCSV;
    @Autowired
    private IBookHisCSV hisCSV;
    @Autowired
    private IDsBookCSV dsBookCSV;
    @Autowired
    private IQryBookTypeCSV bookTypeCSV;

    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 18:56 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public List<YctuLiarbryOut> qryBookOut(Integer out_st_id, Integer book_id) {
        log.info("借书记录查询开始：out_st_id="+out_st_id+" book_id="+book_id);
        YctuLiarbryOutExample example = new YctuLiarbryOutExample();
        YctuLiarbryOutExample.Criteria criteria = example.createCriteria();
        criteria.andOutStIdEqualTo(out_st_id);
        criteria.andBookIdEqualTo(book_id);
        List<YctuLiarbryOut> outs = mapper.selectByExample(example);
        log.info("借书记录查询结束：out_st_id="+out_st_id+" book_id="+book_id);
        return outs;
    }

    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 18:56 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public List<YctuLiarbryOut> qryBookOut(Integer out_st_id) {
        log.info("借书记录查询开始：out_st_id="+out_st_id);
        YctuLiarbryOutExample example = new YctuLiarbryOutExample();
        YctuLiarbryOutExample.Criteria criteria = example.createCriteria();
        criteria.andOutStIdEqualTo(out_st_id);
        List<YctuLiarbryOut> outs = mapper.selectByExample(example);
        log.info("借书记录查询结束：out_st_id="+out_st_id);
        return outs;
    }

    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:55 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public EUDataGridResult teaOutQry(Integer teacher_id, String studentName,Integer out_st_id, Integer page, Integer rows) {
        log.info("借书记录查询开始：out_st_id="+out_st_id+" teacher_id="+teacher_id+"  studentName="+studentName);
        List<YctuLiarbryStudents> list =  studentsCSV.studentByIdOrNname(teacher_id,out_st_id,studentName);
            YctuLiarbryStudents students = new YctuLiarbryStudents();
            if (list !=null || list.size()>0){
                 students=list.get(0);
            }
            List<TeaQryStu> teaQryStus = new ArrayList<TeaQryStu>();
            if (students!=null ) {
                //执行查询 分页
                YctuLiarbryOutExample example = new YctuLiarbryOutExample();
                YctuLiarbryOutExample.Criteria criteria = example.createCriteria();
                criteria.andOutStIdEqualTo(students.getStudentId());
                //分页处理
                PageHelper.startPage(page, rows);
                List<YctuLiarbryOut> outs = mapper.selectByExample(example);
                for (YctuLiarbryOut yctuLiarbryOut : outs) {
                    TeaQryStu teaQryStu = new TeaQryStu();
                    teaQryStu.setStudent_name(students.getStudentName());
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
                //创建一个返回值对象
                EUDataGridResult euDataGridResult = new EUDataGridResult();
                euDataGridResult.setRows(teaQryStus);
                //取出total
                PageInfo<TeaQryStu> pageInfo = new PageInfo<>(teaQryStus);
                long total = pageInfo.getTotal();
                euDataGridResult.setTotal(total);
                log.info("借书记录查询结束：out_st_id="+out_st_id+" teacher_id="+teacher_id+"  studentName="+studentName);
                return euDataGridResult;
            }

        return null;
    }
    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:55 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public EUDataGridResult qryBookOutList(String studentName,Integer out_st_id, Integer page, Integer rows) {
        log.info("借书记录查询开始：out_st_id="+out_st_id+"  studentName="+studentName);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryStudents students = new YctuLiarbryStudents();
            if (StringUtils.isBlank(studentName)) {
                students = studentsCSV.qryStduent(out_st_id);
            }else {
                students = studentsCSV.studentByNname(studentName);
            }
            List<TeaQryStu> teaQryStus = new ArrayList<TeaQryStu>();
            if (students!=null ) {
                //执行查询 分页
                YctuLiarbryOutExample example = new YctuLiarbryOutExample();
                YctuLiarbryOutExample.Criteria criteria = example.createCriteria();
                criteria.andOutStIdEqualTo(students.getStudentId());
                //分页处理
                PageHelper.startPage(page, rows);
                List<YctuLiarbryOut> outs = mapper.selectByExample(example);
                for (YctuLiarbryOut yctuLiarbryOut : outs) {
                    TeaQryStu teaQryStu = new TeaQryStu();
                    teaQryStu.setStudent_name(students.getStudentName());
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
                //创建一个返回值对象
                EUDataGridResult euDataGridResult = new EUDataGridResult();
                euDataGridResult.setRows(teaQryStus);
                //取出total
                PageInfo<TeaQryStu> pageInfo = new PageInfo<>(teaQryStus);
                long total = pageInfo.getTotal();
                euDataGridResult.setTotal(total);
                return euDataGridResult;
            }else {
                throw new Exception("14");
            }
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(0);
                if (out_st_id != null) {
                    his.setStId(out_st_id);
                }else {
                    his.setStId(0);
                }
                his.setType(studentName+":借书记录查询");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(0);
                if (out_st_id != null) {
                    his.setStId(out_st_id);
                }else {
                    his.setStId(0);
                }
                his.setType(studentName+":借书记录查询");
            }
            log.info("借书记录查询结束：out_st_id="+out_st_id+"  studentName="+studentName);
            hisCSV.insertHis(his);
        }
        return null;
    }

    /**
     * 添加借书记录
     * <p>@Description </p>
     * <p>@createDate 13:51 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public SuccessCode insertOut(YctuLiarbryOut out) {
        log.info("添加借书记录开始：opid="+out.getOutOpId());
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            if (out.getOutOpId() == 0||out.getOutOpId()==null){
                throw new Exception("19");
            }
            YctuLiarbryOp op = libraryOpCSV.qryOpName(out.getOutOpId());
            if (op == null) {
                throw new Exception("06");
            } else {
                if (op.getOpType() > 2) {
                    throw new Exception("01");
                }
            }
            YctuLiarbryBooks books = booksCSV.qryBooksLocation(out.getBookId());
            if (books == null) {
                throw new Exception("05");
            }
            if (books.getBookNumber() <= 0) {
                throw new Exception("03");
            }
            YctuLiarbryStudents students = studentsCSV.qryStduent(out.getOutStId());
            if (students == null) {
                YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(out.getOutStId());
                if (teachers == null) {
                    throw new Exception("02");
                }
                if (teachers.getTeacherBooknbs() <= 0) {
                    List<YctuLiarbryDsbook022018> list = dsBookCSV.qryDsBook(out.getOutStId());
                    int x = teachers.getTeacherBooknbs() - list.size();
                    if (x <= 0) {
                        throw new Exception("04");
                    }
                    throw new Exception("04");
                }
                teachers.setTeacherBooknbs(teachers.getTeacherBooknbs() - 1);
                teacherCSV.updateTeacher(out.getOutStId(), teachers);
            }else if (students.getStudentBooknbs() <= 0) {
                throw new Exception("04");
            } else if(students.getStudentBooknbs() > 0) {
                List<YctuLiarbryDsbook022018> list = dsBookCSV.qryDsBook(out.getOutStId());
                int y = students.getStudentBooknbs() - list.size();
                if (y <= 0) {
                    throw new Exception("04");
                }
                students.setStudentBooknbs(students.getStudentBooknbs() - 1);
                studentsCSV.updateStudent(out.getOutStId(), students);
            }
            books.setBookNumber(books.getBookNumber() - 1);
            booksCSV.updateBook(out.getBookId(), books);
            out.setOutDate(BookTimeUtil.currentTimes());
            out.setCreateDate(BookTimeUtil.opTimes());
            mapper.insert(out);
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(out.getOutOpId());
                his.setStId(out.getOutStId());
                his.setType("借书");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(out.getOutOpId());
                his.setStId(out.getOutStId());
                his.setType("借书");
            }
            hisCSV.insertHis(his);
            log.info("添加借书记录结束：opid="+out.getOutOpId());
            return successCode;
        }
    }

    /**
     * 删除借书记录 by st_id
     * <p>@Description </p>
     * <p>@createDate 13:57 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public SuccessMoneyCode deleteOut(Integer out_st_id, Integer book_id) {
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        SuccessMoneyCode successMoneyCode = new SuccessMoneyCode();
        try {
            YctuLiarbryOutExample example = new YctuLiarbryOutExample();
            //添加查询条件
            YctuLiarbryOutExample.Criteria criteria = example.createCriteria();
            criteria.andOutStIdEqualTo(out_st_id);
            YctuLiarbryBooks books = booksCSV.qryBooksLocation(book_id);
            if (books == null) {
                throw new Exception("05");
            }
            if (books.getBookNumber() <= 0) {
                throw new Exception("03");
            }
            successMoneyCode.setMoney(String.valueOf(books.getBookPrice()));
            //应该加异常
            mapper.deleteByExample(example);
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(10001);
                his.setStId(out_st_id);
                his.setType("删除借书记录");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(10001);
                his.setStId(out_st_id);
                his.setType("删除借书记录");
            }
            hisCSV.insertHis(his);
            successMoneyCode.setRscode(his.getCode());
            successMoneyCode.setRsdec(his.getCodeMsg());
            return successMoneyCode;
        }
    }

    /**
     * 更改借书信息
     * <p>@Description </p>
     * <p>@createDate 14:00 2018/4/27</p>
     * 0:失效 1：生效
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public SuccessCode updateOut(Integer out_st_id, Integer book_id, YctuLiarbryOut out) {
        log.info("更改借书记录开始：opid="+out.getOutOpId()+"  out_st_id="+out_st_id+" book_id="+book_id);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryOutExample example = new YctuLiarbryOutExample();
            YctuLiarbryOutExample.Criteria criteria = example.createCriteria();
            criteria.andOutStIdEqualTo(out_st_id);
            criteria.andBookIdEqualTo(book_id);
            out.setOutStaus(0);
            mapper.updateByExample(out, example);
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                successCode.setRscode(00);
                successCode.setRsdec("成功");
            }
            log.info("更改借书记录结束：opid="+out.getOutOpId()+"  out_st_id="+out_st_id+" book_id="+book_id);
            return successCode;
        }
    }
}
