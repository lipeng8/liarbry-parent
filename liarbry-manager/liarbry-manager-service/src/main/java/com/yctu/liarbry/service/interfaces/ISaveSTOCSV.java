package com.yctu.liarbry.service.interfaces;

import com.yctu.library.common.pojo.SuccessCode;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--20:23
 */
public interface ISaveSTOCSV {
    /**
     * 添加管理员
     *<p>@Description </p>
     *<p>@createDate 17:11 2018/5/2</p>
     *@author lipeng
     *@param
     *@return
     */
   SuccessCode saveOp(Integer op_id, Integer opId, String op_pwd, String op_name, Integer op_type, String ext1, String ext2);
    /**添加学生
     *<p>@Description </p>
     *<p>@createDate 17:12 2018/5/2</p>
     *@author lipeng
     *@param
     *@return
     */
   SuccessCode saveStudent(Integer student_id, Integer opId, String student_name, Integer student_class,Integer teacher_id, String ext1, String ext2);
    /**添加老师
     *<p>@Description </p>
     *<p>@createDate 17:12 2018/5/2</p>
     *@author lipeng
     *@param
     *@return
     */
 SuccessCode saveTeacher(Integer teacher_id, Integer opId, String teacher_pwd, String teacher_name, Integer teacher_class, String ext1, String ext2);
}
