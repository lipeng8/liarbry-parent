package com.yctu.liarbry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yctu.liarbry.mapper.YctuLiarbryInMapper;
import com.yctu.liarbry.pojo.*;
import com.yctu.liarbry.respojo.Inbookqry;
import com.yctu.liarbry.service.interfaces.*;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.pojo.SuccessMoneyCode;
import com.yctu.library.common.utils.BookTimeUtil;
import com.yctu.library.common.utils.SuccessUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:36
 */
@Service
public class BookInCSVImpl implements IBookInCSV {
    @Autowired
    private YctuLiarbryInMapper mapper;
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
    private IBookOutCSV outCSV;
    @Autowired
    private IDsBookCSV dsBookCSV;
    @Autowired
    private IQryBookTypeCSV bookTypeCSV;

    /**
     * 还书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:53 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public EUDataGridResult qryBookInname(Integer in_st_id, String studentName, Integer page, Integer rows) {
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryStudents students = new YctuLiarbryStudents();
            if (StringUtils.isBlank(studentName)) {
                students = studentsCSV.qryStduent(in_st_id);
            } else {
                students = studentsCSV.studentByNname(studentName);
            }
            List<Inbookqry> inbookqries = new ArrayList<Inbookqry>();
            if (students != null) {
                //执行查询 分页
                YctuLiarbryInExample example = new YctuLiarbryInExample();
                YctuLiarbryInExample.Criteria criteria = example.createCriteria();
                criteria.andInStIdEqualTo(students.getStudentId());
                //分页处理
                PageHelper.startPage(page, rows);
                List<YctuLiarbryIn> ins = mapper.selectByExample(example);
                for (YctuLiarbryIn yctuLiarbryIn : ins) {
                    Inbookqry inbookqry = new Inbookqry();
                    inbookqry.setStudent_name(students.getStudentName());
                    inbookqry.setIn_date(yctuLiarbryIn.getInDate());
                    if (yctuLiarbryIn.getInStaus() == 0) {
                        inbookqry.setInStaus("完好");
                    } else {
                        inbookqry.setInStaus("破损");
                    }
                    YctuLiarbryBooks books = booksCSV.qryBooksLocation(yctuLiarbryIn.getBookId());
                    inbookqry.setBook_name(books.getBookName());
                    YctuLiarbryBooktypes booktypes = bookTypeCSV.qryBookTypes(Integer.valueOf(books.getBookType()));
                    inbookqry.setType_name(booktypes.getTypeName());
                    inbookqry.setExt1(yctuLiarbryIn.getExt1());
                    inbookqry.setExt2(yctuLiarbryIn.getExt2());
                    YctuLiarbryOp op = libraryOpCSV.qryOpName(yctuLiarbryIn.getInOpId());
                    if (op == null){
                        inbookqry.setOp_name("该操作员已离职");
                    }else {
                        inbookqry.setOp_name(op.getOpName());
                    }
                    inbookqries.add(inbookqry);
                }
                //创建一个返回值对象
                EUDataGridResult euDataGridResult = new EUDataGridResult();
                euDataGridResult.setRows(inbookqries);
                //取出total
                PageInfo<Inbookqry> pageInfo = new PageInfo<>(inbookqries);
                long total = pageInfo.getTotal();
                euDataGridResult.setTotal(total);
                return euDataGridResult;
            } else {
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
                his.setOpId(10001);
                if (in_st_id != null) {
                    his.setStId(in_st_id);
                }else {
                    his.setStId(0);
                }
                his.setType(studentName+"还书记录查询");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(10001);
                if (in_st_id != null) {
                    his.setStId(in_st_id);
                }else {
                    his.setStId(0);
                }
                his.setType(studentName+"还书记录查询");
            }
            hisCSV.insertHis(his);
        }
        return null;
    }

    /**
     * 还书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:53 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public EUDataGridResult qryBookIn(Integer page, Integer rows) {

        //执行查询 分页
        YctuLiarbryInExample example = new YctuLiarbryInExample();

        //分页处理
        PageHelper.startPage(page, rows);
        List<YctuLiarbryIn> ins = mapper.selectByExample(example);
        List<Inbookqry> inbookqries = new ArrayList<Inbookqry>();
        for (YctuLiarbryIn yctuLiarbryIn : ins) {
            YctuLiarbryStudents students = studentsCSV.qryStduent(yctuLiarbryIn.getInStId());
            Inbookqry inbookqry = new Inbookqry();
            inbookqry.setStudent_name(students.getStudentName());
            inbookqry.setIn_date(yctuLiarbryIn.getInDate());
            if (yctuLiarbryIn.getInStaus() == 0) {
                inbookqry.setInStaus("完好");
            } else {
                inbookqry.setInStaus("破损");
            }
            YctuLiarbryBooks books = booksCSV.qryBooksLocation(yctuLiarbryIn.getBookId());
            inbookqry.setBook_name(books.getBookName());
            YctuLiarbryBooktypes booktypes = bookTypeCSV.qryBookTypes(Integer.valueOf(books.getBookType()));
            inbookqry.setType_name(booktypes.getTypeName());
            inbookqry.setExt1(yctuLiarbryIn.getExt1());
            inbookqry.setExt2(yctuLiarbryIn.getExt2());
            YctuLiarbryOp op = libraryOpCSV.qryOpName(yctuLiarbryIn.getInOpId());
            if (op == null){
                inbookqry.setOp_name("该操作员已离职");
            }else {
                inbookqry.setOp_name(op.getOpName());
            }
            inbookqries.add(inbookqry);
        }
        //创建一个返回值对象
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(inbookqries);
        //取出total
        PageInfo<Inbookqry> pageInfo = new PageInfo<>(inbookqries);
        long total = pageInfo.getTotal();
        euDataGridResult.setTotal(total);
        return euDataGridResult;

    }

    /**
     * 添加还书记录
     * <p>@Description </p>
     * <p>@createDate 13:52 2018/4/27</p>
     * 疑问顺坏记录？
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public SuccessMoneyCode insertIn(YctuLiarbryIn in) {
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        SuccessMoneyCode successMoneyCode = new SuccessMoneyCode();
        try {
            if (in.getInOpId() == 0||in.getInOpId()==null){
                throw new Exception("19");
            }
            YctuLiarbryOp op = libraryOpCSV.qryOpName(in.getInOpId());
            if (op == null) {
                throw new Exception("06");
            } else {
                if (op.getOpType() > 2) {
                    throw new Exception("01");
                }
            }
            YctuLiarbryBooks books = booksCSV.qryBooksLocation(in.getBookId());
            if (books == null) {
                throw new Exception("05");
            }
            if (books.getBookNumber() <= 0) {
                throw new Exception("03");
            }
            in.setInDate(BookTimeUtil.currentTimes());
            in.setCreateDate(BookTimeUtil.opTimes());
            List<YctuLiarbryOut> outs = outCSV.qryBookOut(in.getInStId(), in.getBookId());
            if (outs == null || outs.size() <= 0) {
                throw new Exception("12");
            } else {
                YctuLiarbryOut out = null;
                for (int i = 0; i < outs.size(); i++) {
                    if (outs.get(i).getOutStaus() == 1) {
                        out = outs.get(i);
                    }
                }
                if (out == null) {
                    throw new Exception("11");
                }
                YctuLiarbryDsbook022018 dsbook = new YctuLiarbryDsbook022018();
                dsbook.setOpId(in.getInOpId());
                dsbook.setCreateDate(BookTimeUtil.opTimes());
                dsbook.setBookId(in.getBookId());
                dsbook.setStId(in.getInStId());
                if (!out.getOutStId().equals(in.getInStId())) {
                    throw new Exception("13");
                }
                YctuLiarbryStudents students = studentsCSV.qryStduent(in.getInStId());
                if (students == null) {
                    YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(in.getInStId());
                    if (teachers == null) {
                        throw new Exception("02");
                    }
                    teachers.setTeacherBooknbs(teachers.getTeacherBooknbs() + 1);
                    teacherCSV.updateTeacher(in.getInStId(), teachers);
                } else {
                    students.setStudentBooknbs(students.getStudentBooknbs() + 1);
                    studentsCSV.updateStudent(in.getInStId(), students);
                }
                if (in.getInStaus() == 1) {
                    successMoneyCode.setMoney(String.valueOf(BookTimeUtil.moneyTime(in.getInDate(), out.getOutDate())) + " 元");
                    dsbook.setMoney(0);
                    dsBookCSV.insertDSBook(dsbook);
                    books.setBookNumber(books.getBookNumber() + 1);
                    booksCSV.updateBook(in.getBookId(), books);
                } else if (in.getInStaus() == 2) {
                    successMoneyCode.setMoney(String.valueOf(BookTimeUtil.moneyTime(in.getInDate(), out.getOutDate()) + books.getBookPrice()) + " 元");
                    ///更改代码
                    dsbook.setMoney(1111111);
                    dsBookCSV.insertDSBook(dsbook);
                } else {
                    successMoneyCode.setMoney(String.valueOf(BookTimeUtil.moneyTime(in.getInDate(), out.getOutDate())) + " 元");
                    books.setBookNumber(books.getBookNumber() + 1);
                    booksCSV.updateBook(in.getBookId(), books);
                }
                mapper.insert(in);
                SuccessCode successCode1 = outCSV.updateOut(in.getInStId(), in.getBookId(), out);
                if (successCode1.getRscode() != 0) {
                    throw new Exception(String.valueOf(successCode1.getRscode()));
                }
            }

        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("还书成功");
                his.setOpId(in.getInOpId());
                his.setStId(in.getInStId());
                his.setType("添加还书记录");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(in.getInOpId());
                his.setStId(in.getInStId());
                his.setType("添加还书记录");
            }
            hisCSV.insertHis(his);
            successMoneyCode.setRscode(his.getCode());
            successMoneyCode.setRsdec(his.getCodeMsg());
            return successMoneyCode;
        }
    }

}
