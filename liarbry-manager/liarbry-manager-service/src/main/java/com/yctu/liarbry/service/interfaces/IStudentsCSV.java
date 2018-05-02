package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryStudents;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:39
 */
public interface IStudentsCSV {
    /**
     * 查询学生信息
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
     YctuLiarbryStudents studentByNname(String student_name);
    /**
     * 老师查询学生信息
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    List<YctuLiarbryStudents> studentByIdOrNname(Integer teacher_id,Integer student_id,String student_name);
    /**
     * 老师查询学生借书情况
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    List<YctuLiarbryStudents> teaQryStu(Integer teacher_id);
    /**
     * 老师查询学生借书情况
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    List<YctuLiarbryStudents> QryStu();

    /**
     * 查询可借阅图书学生
     * <p>@Description </p>
     * <p>@createDate 16:06 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    YctuLiarbryStudents qryStduent(Integer student_id);

    /**
     * 添加学生
     * <p>@Description </p>
     * <p>@createDate 13:47 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void insertStudent(YctuLiarbryStudents students);

    /**
     * 删除学生by student_id
     * <p>@Description </p>
     * <p>@createDate 13:57 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void deleteStudent(Integer student_id);

    /**
     * 删除学生根据姓名
     * <p>@Description </p>
     * <p>@createDate 13:59 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void deleteStudent(String student_name);

    /**
     * 更改学生信息
     * <p>@Description </p>
     * <p>@createDate 14:00 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void updateStudent(Integer student_id, YctuLiarbryStudents students);
}
