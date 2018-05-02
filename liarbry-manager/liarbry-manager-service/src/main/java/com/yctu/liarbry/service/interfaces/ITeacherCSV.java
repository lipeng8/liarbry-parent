package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryTeachers;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:40
 */
public interface ITeacherCSV {
    /**
     * 查询老师
     * <p>@Description </p>
     * <p>@createDate 16:09 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    YctuLiarbryTeachers qryTeacher(Integer teacher_id);

    /**
     * 添加老师
     * <p>@Description </p>
     * <p>@createDate 13:48 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void insertTeacher(YctuLiarbryTeachers teachers);

    /**
     * 删除老师 by teacher_id
     * <p>@Description </p>
     * <p>@createDate 13:59 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void deleteTeacher(Integer teacher_id);

    /**
     * 删除老师根据姓名
     * <p>@Description </p>
     * <p>@createDate 13:58 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void deleteTeacher(String teacher_name);

    /**
     * 更改老师信息
     * <p>@Description </p>
     * <p>@createDate 14:03 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void updateTeacher(Integer teacher_id, YctuLiarbryTeachers teachers);
}
