package com.yctu.liarbry.service.interfaces;

import com.yctu.library.common.pojo.EUDataGridResult;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--20:41
 */
public interface ITeaQryStuCSV {
    /**
     * 老师查询学生图书借阅情况
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
     EUDataGridResult teaQryStu(Integer teacher_id, Integer page, Integer rows);
    /**
     * 学生图书借阅情况
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
     EUDataGridResult QryStu( Integer page, Integer rows);
    /**
     * 老师查询学生
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult student(Integer teacher_id, Integer page, Integer rows);
    /**
     * 老师查询学生信息根据学生编号
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult qryStudentById(Integer teacher_id,Integer studentId, Integer page, Integer rows);
    /**
     * 老师查询学生信息根据学生姓名
     * <p>@Description </p>
     * <p>@createDate 20:47 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    EUDataGridResult qryStudentByName(Integer teacher_id,String studentName, Integer page, Integer rows);
}
