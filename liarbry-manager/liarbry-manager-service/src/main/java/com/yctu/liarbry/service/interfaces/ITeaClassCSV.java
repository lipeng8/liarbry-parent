package com.yctu.liarbry.service.interfaces;

import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;

/**
 * @Author:LiPeng
 * @Date:2018/5/8--13:32
 */
public interface ITeaClassCSV {
    /**
     * 添加任课教师
     * <p>@Description </p>
     * <p>@createDate 16:37 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
   SuccessCode insertTeaClass(Integer teaClass_id, Integer teacher_id);
    /**
     * 任课教师查询学生借阅情况
     * <p>@Description </p>
     * <p>@createDate 16:37 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
     EUDataGridResult qryTeaClass(Integer class_id, Integer teacher_id, Integer page, Integer rows);
}
