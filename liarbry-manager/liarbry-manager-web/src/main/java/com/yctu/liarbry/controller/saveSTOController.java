package com.yctu.liarbry.controller;

import com.yctu.liarbry.service.interfaces.ISaveSTOCSV;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.utils.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--21:27
 */
@Controller
public class saveSTOController {
    @Autowired
    private ISaveSTOCSV saveSTOCSV;

    @RequestMapping("/book/saveOp")
    @ResponseBody
    /**新增操作员
     *<p>@Description </p>
     *<p>@createDate 21:46 2018/4/28</p>
     *@author lipeng
     *@param [lg_id, lg_pwd, lg_type]
     *@return com.yctu.library.common.pojo.SuccessCode
     */
    public SuccessCode saveOp(Integer op_id, Integer opId, String op_pwd, String op_name, Integer op_type, String ext1, String ext2) {
        SuccessCode successCode = saveSTOCSV.saveOp(op_id, opId, EncodeUtil.EncodeUtil(op_pwd), EncodeUtil.EncodeUtil(op_name), op_type, EncodeUtil.EncodeUtil(ext1), EncodeUtil.EncodeUtil(ext2));
        return successCode;
    }

    @RequestMapping("/book/saveStudent")
    @ResponseBody
    /**新增学生
     *<p>@Description </p>
     *<p>@createDate 21:46 2018/4/28</p>
     *@author lipeng
     *@param [lg_id, lg_pwd, lg_type]
     *@return com.yctu.library.common.pojo.SuccessCode
     */
    public SuccessCode saveStudent(Integer student_id, Integer opId, String student_name, Integer student_class, Integer teacher_id, String ext1, String ext2) {
        SuccessCode successCode = saveSTOCSV.saveStudent(student_id, opId, EncodeUtil.EncodeUtil(student_name), student_class, teacher_id, EncodeUtil.EncodeUtil(ext1), EncodeUtil.EncodeUtil(ext2));
        return successCode;
    }

    @RequestMapping("/book/saveTeacher")
    @ResponseBody
    /**新增老师
     *<p>@Description </p>
     *<p>@createDate 21:46 2018/4/28</p>
     *@author lipeng
     *@param [lg_id, lg_pwd, lg_type]
     *@return com.yctu.library.common.pojo.SuccessCode
     */
    public SuccessCode saveTeacher(Integer teacher_id, Integer opId, String teacher_pwd, String teacher_name, Integer teacher_class, String ext1, String ext2) {
        SuccessCode successCode = saveSTOCSV.saveTeacher(teacher_id, opId, EncodeUtil.EncodeUtil(teacher_pwd), EncodeUtil.EncodeUtil(teacher_name), teacher_class, EncodeUtil.EncodeUtil(ext1), EncodeUtil.EncodeUtil(ext2));
        return successCode;
    }
    @RequestMapping("/book/deleteSTO")
    @ResponseBody
    /**删除操作员，学生，老师
     *<p>@Description </p>
     *<p>@createDate 21:46 2018/4/28</p>
     *@author lipeng
     *@param [lg_id, lg_pwd, lg_type]
     *@return com.yctu.library.common.pojo.SuccessCode
     */
    public SuccessCode deleteSTO(Integer id,Integer opId,Integer type){
        SuccessCode successCode = saveSTOCSV.deleteSTO(id,opId,type);
        return  successCode;
    }
}
