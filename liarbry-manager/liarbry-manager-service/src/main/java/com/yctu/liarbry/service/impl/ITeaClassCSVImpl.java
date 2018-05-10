package com.yctu.liarbry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yctu.liarbry.mapper.YctuLiarbryTeaclassMapper;
import com.yctu.liarbry.pojo.*;
import com.yctu.liarbry.respojo.TeaQryStu;
import com.yctu.liarbry.service.interfaces.*;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.utils.BookTimeUtil;
import com.yctu.library.common.utils.PageUtil;
import com.yctu.library.common.utils.SuccessUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/5/8--13:33
 */
@Service
public class ITeaClassCSVImpl implements ITeaClassCSV {
    /**
     * 全局log
     */
    private static final Log log = LogFactory.getLog(ITeaClassCSVImpl.class);
    @Autowired
    private YctuLiarbryTeaclassMapper mapper;
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
     * 添加任课教师
     * <p>@Description </p>
     * <p>@createDate 16:37 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public SuccessCode insertTeaClass(Integer teaClass_id, Integer teacher_id) {
        log.info("开始 添加任课教师：" + teaClass_id + "  班主任：" + teacher_id);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(teacher_id);
            if (teachers != null) {
                YctuLiarbryTeachers teacher = teacherCSV.qryTeacher(teaClass_id);
                if (teacher != null) {
                    YctuLiarbryTeaclass teaclass = new YctuLiarbryTeaclass();
                    teaclass.setCreateDate(BookTimeUtil.opTimes());
                    teaclass.setStudentClass(teachers.getTeacherClass());
                    teaclass.setTeacherId(teaClass_id);
                    mapper.insert(teaclass);
                } else {
                    throw new Exception("17");
                }
            } else {
                throw new Exception("19");
            }
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(rscode);
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(0);
                his.setStId(teacher_id);
                his.setType("添加任课教师：" + teaClass_id);
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(0);
                his.setStId(teacher_id);
                his.setType("添加任课教师：" + teaClass_id);
            }
            hisCSV.insertHis(his);
            log.info("结束 添加任课教师：" + teaClass_id + "  班主任：" + teacher_id);
            return successCode;
        }
    }

    /**
     * 任课教师查询学生借阅情况
     * <p>@Description </p>
     * <p>@createDate 16:37 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public EUDataGridResult qryTeaClass(Integer class_id, Integer teacher_id,Integer page, Integer rows) {
        log.info("开始 任课教师查询学生借阅情况：" + teacher_id);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(teacher_id);
            //分页处理
//            PageHelper.startPage(page, rows);
            List<TeaQryStu> teaQryStus = new ArrayList<TeaQryStu>();
            if (teachers != null) {
                YctuLiarbryTeaclassExample example = new YctuLiarbryTeaclassExample();
                YctuLiarbryTeaclassExample.Criteria criteria = example.createCriteria();
                criteria.andTeacherIdEqualTo(teacher_id);
                criteria.andStudentClassEqualTo(class_id);
                List<YctuLiarbryTeaclass> teaList = mapper.selectByExample(example);
                if(teaList!=null||teaList.size()>0) {
                        List<YctuLiarbryStudents> list = studentsCSV.qryTeaClass(class_id);
                        for (YctuLiarbryStudents students : list) {
                            List<YctuLiarbryOut> outs = outCSV.qryBookOut(students.getStudentId());
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
                        }

                }else {
                    throw new Exception("10");
                }

            } else {
                throw new Exception("19");
            }
            //创建一个返回值对象
            EUDataGridResult euDataGridResult = new EUDataGridResult();
            euDataGridResult.setRows(PageUtil.page(teaQryStus,page,rows));
            //取出total
//            PageInfo<TeaQryStu> pageInfo = new PageInfo<>(teaQryStus);
            long total =teaQryStus.size();
            euDataGridResult.setTotal(total);
            return euDataGridResult;
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(rscode);
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(0);
                his.setStId(teacher_id);
                his.setType("任课教师查询学生借阅情况：");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(0);
                his.setStId(teacher_id);
                his.setType("任课教师查询学生借阅情况：");
            }
            hisCSV.insertHis(his);
            log.info("结束 任课教师查询学生借阅情况：" + teacher_id);
        }
        return null;
    }
}
