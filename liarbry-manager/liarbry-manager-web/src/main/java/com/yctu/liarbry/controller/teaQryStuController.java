package com.yctu.liarbry.controller;

import com.yctu.liarbry.service.interfaces.ITeaQryStuCSV;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.utils.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--21:26
 */
@Controller
public class teaQryStuController {
    @Autowired
    private ITeaQryStuCSV teaQryStuCSV;

    @RequestMapping("/book/teaQryStu")
    @ResponseBody
    /**
     * 老师查询学生图书借阅情况
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult teaQryStu(Integer teacher_id, Integer page, Integer rows) {
        EUDataGridResult euDataGridResult = teaQryStuCSV.teaQryStu(teacher_id, page, rows);
        return euDataGridResult;
    }
    @RequestMapping("/book/QryStu")
    @ResponseBody
    /**
     * 学生图书借阅情况
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult QryStu( Integer page, Integer rows) {
        EUDataGridResult euDataGridResult = teaQryStuCSV.QryStu( page, rows);
        return euDataGridResult;
    }

    @RequestMapping("/book/student")
    @ResponseBody
    /**
     * 老师查询学生
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */


    public EUDataGridResult student(Integer teacher_id, Integer page, Integer rows) {
        EUDataGridResult euDataGridResult = teaQryStuCSV.student(teacher_id, page, rows);
        return euDataGridResult;
    }

    @RequestMapping("/book/studentId")
    @ResponseBody
    /**
     * 老师查询学生信息根据学生学号
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */


    public EUDataGridResult qryStudentById(Integer teacher_id, Integer studentId, Integer page, Integer rows) {
        EUDataGridResult euDataGridResult = teaQryStuCSV.qryStudentById(teacher_id, studentId, page, rows);
        return euDataGridResult;
    }

    @RequestMapping("/book/studentName")
    @ResponseBody
    /**
     * 老师查询学生信息学生姓名
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryStudentByName(Integer teacher_id, String studentName, Integer page, Integer rows) {
        EUDataGridResult euDataGridResult = teaQryStuCSV.qryStudentByName(teacher_id, EncodeUtil.EncodeUtil(studentName), page, rows);
        return euDataGridResult;
    }
}
