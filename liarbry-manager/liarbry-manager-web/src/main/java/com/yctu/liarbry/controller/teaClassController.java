package com.yctu.liarbry.controller;

import com.yctu.liarbry.service.interfaces.ITeaClassCSV;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:LiPeng
 * @Date:2018/5/8--14:20
 */
@Controller
public class teaClassController {
    @Autowired
    private ITeaClassCSV teaClassCSV;

    /**
     * 添加任课教师
     * <p>@Description </p>
     * <p>@createDate 16:37 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @RequestMapping("/book/saveTeaClass")
    @ResponseBody
   public SuccessCode insertTeaClass(Integer teaClass_id, Integer teacher_id){
       SuccessCode successCode = teaClassCSV.insertTeaClass(teaClass_id,teacher_id);
       return  successCode;
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
    @RequestMapping("/book/qrtTeaClass")
    @ResponseBody
    public  EUDataGridResult qryTeaClass(Integer class_id, Integer teacher_id, Integer page, Integer rows){
        EUDataGridResult euDataGridResult = teaClassCSV.qryTeaClass(class_id,teacher_id,page,rows);
        return euDataGridResult;
    }
}
