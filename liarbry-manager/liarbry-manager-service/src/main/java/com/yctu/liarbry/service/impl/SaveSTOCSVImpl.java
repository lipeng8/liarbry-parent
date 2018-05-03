package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.pojo.YctuLiarbryHis;
import com.yctu.liarbry.pojo.YctuLiarbryOp;
import com.yctu.liarbry.pojo.YctuLiarbryStudents;
import com.yctu.liarbry.pojo.YctuLiarbryTeachers;
import com.yctu.liarbry.service.interfaces.*;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.utils.BookTimeUtil;
import com.yctu.library.common.utils.SuccessUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--20:22
 */
@Service
public class SaveSTOCSVImpl implements ISaveSTOCSV {
    /**
     * 全局log
     */
    private static final Logger log = LoggerFactory.getLogger(SaveSTOCSVImpl.class);
    @Autowired
    private ILibraryOpCSV opCSV;
    @Autowired
    private IQryBooksCSV booksCSV;
    @Autowired
    private IStudentsCSV studentsCSV;
    @Autowired
    private ITeacherCSV teacherCSV;
    @Autowired
    private IBookHisCSV hisCSV;
    @Autowired
    private IBookOutCSV outCSV;
    @Autowired
    private IDsBookCSV dsBookCSV;
    @Autowired
    private IQryBookTypeCSV bookTypeCSV;

    /**
     * 添加管理员
     * <p>@Description </p>
     * <p>@createDate 17:12 2018/5/2</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public SuccessCode saveOp(Integer op_id, Integer opId, String op_pwd, String op_name, Integer op_type, String ext1, String ext2) {
        log.info("添加管理员：开始：op_id=" + op_id);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryOp opid = opCSV.qryOpName(opId);
            if (opid == null) {
                throw new Exception("06");
            }
            if (opid.getOpType() > 1) {
                throw new Exception("01");
            }
            YctuLiarbryOp op = opCSV.qryOpName(op_id);
            if (op == null) {
                YctuLiarbryOp liarbryOp = new YctuLiarbryOp();
                liarbryOp.setCreateDate(BookTimeUtil.opTimes());
                liarbryOp.setExt1(ext1);
                liarbryOp.setExt2(ext2);
                liarbryOp.setOpId(op_id);
                liarbryOp.setOpName(op_name);
                liarbryOp.setOpPassword(op_pwd);
                liarbryOp.setOpType(op_type);
                opCSV.insertOp(liarbryOp);
            } else {
                throw new Exception("20");
            }

        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(opId);
                his.setStId(0);
                his.setType("新增操作员");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(opId);
                his.setStId(0);
                his.setType("新增操作员");
            }
            hisCSV.insertHis(his);
            log.info("添加管理员：结束：op_id=" + op_id);
        }
        return successCode;
    }

    /**
     * 添加学生
     * <p>@Description </p>
     * <p>@createDate 17:12 2018/5/2</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public SuccessCode saveStudent(Integer student_id, Integer opId, String student_name, Integer student_class, Integer teacher_id, String ext1, String ext2) {
        log.info("添加学生：开始：op_id=" + opId);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryOp opid = opCSV.qryOpName(opId);
            if (opid == null) {
                throw new Exception("06");
            }
            if (opid.getOpType() > 2) {
                throw new Exception("01");
            }
            YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(teacher_id);
            if (teachers == null) {
                throw new Exception("23");
            }
            YctuLiarbryStudents students = studentsCSV.qryStduent(student_id);
            if (students == null) {
                YctuLiarbryStudents student = new YctuLiarbryStudents();
                student.setCreateDate(BookTimeUtil.opTimes());
                student.setExt1(ext1);
                student.setExt2(ext2);
                student.setStudentBooknbs(3);
                student.setStudentClass(student_class);
                student.setStudentId(student_id);
                student.setTeacherId(teacher_id);
                student.setStudentName(student_name);
                studentsCSV.insertStudent(student);
            } else {
                throw new Exception("21");
            }

        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(opId);
                his.setStId(student_id);
                his.setType("新增学生");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(opId);
                his.setStId(student_id);
                his.setType("新增学生");
            }
            hisCSV.insertHis(his);
            log.info("添加学生：结束：op_id=" + opId);
        }
        return successCode;
    }

    /**
     * 添加老师
     * <p>@Description </p>
     * <p>@createDate 17:12 2018/5/2</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public SuccessCode saveTeacher(Integer teacher_id, Integer opId, String teacher_pwd, String teacher_name, Integer teacher_class, String ext1, String ext2) {
        log.info("添加老师：开始：op_id=" + opId);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            YctuLiarbryOp opid = opCSV.qryOpName(opId);
            if (opid == null) {
                throw new Exception("06");
            }
            if (opid.getOpType() > 2) {
                throw new Exception("01");
            }
            YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(teacher_id);
            if (teachers == null) {
                YctuLiarbryTeachers teacher = new YctuLiarbryTeachers();
                teacher.setCreateDate(BookTimeUtil.opTimes());
                teacher.setExt1(ext1);
                teacher.setExt2(ext2);
                teacher.setTeacherBooknbs(5);
                teacher.setTeacherClass(teacher_class);
                teacher.setTeacherId(teacher_id);
                teacher.setTeacherName(teacher_name);
                teacher.setTeacherPwd(teacher_pwd);
                teacherCSV.insertTeacher(teacher);
            } else {
                throw new Exception("22");
            }
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(opId);
                his.setStId(teacher_id);
                his.setType("新增老师");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(opId);
                his.setStId(teacher_id);
                his.setType("新增老师");
            }
            hisCSV.insertHis(his);
            log.info("添加老师：结束：op_id=" + opId);
        }
        return successCode;
    }
}
