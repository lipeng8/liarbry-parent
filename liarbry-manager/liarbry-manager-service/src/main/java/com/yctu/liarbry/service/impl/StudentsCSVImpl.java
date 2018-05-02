package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.mapper.YctuLiarbryStudentsMapper;
import com.yctu.liarbry.pojo.YctuLiarbryStudents;
import com.yctu.liarbry.pojo.YctuLiarbryStudentsExample;
import com.yctu.liarbry.service.interfaces.IStudentsCSV;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:39
 */
@Service
public class StudentsCSVImpl implements IStudentsCSV {
    @Autowired
    private YctuLiarbryStudentsMapper mapper;
    /**
     * 老师查询学生信息
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public List<YctuLiarbryStudents> studentByIdOrNname(Integer teacher_id,Integer student_id,String student_name){
        YctuLiarbryStudentsExample example = new YctuLiarbryStudentsExample();
        //添加查询条件
        YctuLiarbryStudentsExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherIdEqualTo(teacher_id);
        if (StringUtils.isBlank(student_name)||"null".equals(student_name)){
            criteria.andStudentIdEqualTo(student_id);
        }else{
            criteria.andStudentNameEqualTo(student_name);
        }
        List<YctuLiarbryStudents> list = mapper.selectByExample(example);
        return list;
    }
    /**
     * 查询学生信息
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public YctuLiarbryStudents studentByNname(String student_name){
        YctuLiarbryStudentsExample example = new YctuLiarbryStudentsExample();
        //添加查询条件
        YctuLiarbryStudentsExample.Criteria criteria = example.createCriteria();
        criteria.andStudentNameEqualTo(student_name);
        List<YctuLiarbryStudents> list = mapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            YctuLiarbryStudents stduent = list.get(0);
            return stduent;
        }
        return null;
    }
    /**
     * 老师查询学生借书情况
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public  List<YctuLiarbryStudents> teaQryStu(Integer teacher_id) {
        YctuLiarbryStudentsExample example = new YctuLiarbryStudentsExample();
        //添加查询条件
        YctuLiarbryStudentsExample.Criteria criteria = example.createCriteria();
       criteria.andTeacherIdEqualTo(teacher_id);
        List<YctuLiarbryStudents> list = mapper.selectByExample(example);
        return list;
    }
    /**
     * 学生借书情况
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public  List<YctuLiarbryStudents> QryStu() {
        YctuLiarbryStudentsExample example = new YctuLiarbryStudentsExample();
        //添加查询条件
        List<YctuLiarbryStudents> list = mapper.selectByExample(example);
        return list;
    }

    /**
     * 查询可借阅图书学生
     * <p>@Description </p>
     * <p>@createDate 16:05 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public YctuLiarbryStudents qryStduent(Integer student_id) {
        YctuLiarbryStudentsExample example = new YctuLiarbryStudentsExample();
//添加查询条件
        YctuLiarbryStudentsExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(student_id);
        List<YctuLiarbryStudents> list = mapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            YctuLiarbryStudents stduent = list.get(0);
            return stduent;
        }
        return null;
    }

    /**
     * 添加学生
     * <p>@Description </p>
     * <p>@createDate 13:45 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void insertStudent(YctuLiarbryStudents students) {
        mapper.insert(students);
    }

    /**
     * 删除学生by student_id
     * <p>@Description </p>
     * <p>@createDate 13:57 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void deleteStudent(Integer student_id) {
        YctuLiarbryStudentsExample example = new YctuLiarbryStudentsExample();
//添加查询条件
        YctuLiarbryStudentsExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(student_id);
        //应该加异常
        mapper.deleteByExample(example);

    }

    /**
     * 删除学生根据姓名
     * <p>@Description </p>
     * <p>@createDate 13:59 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void deleteStudent(String student_name) {
        YctuLiarbryStudentsExample example = new YctuLiarbryStudentsExample();
        //添加查询条件
        YctuLiarbryStudentsExample.Criteria criteria = example.createCriteria();
        criteria.andStudentNameEqualTo(student_name);
        //应该加异常
        mapper.deleteByExample(example);

    }

    /**
     * 更改学生信息
     * <p>@Description </p>
     * <p>@createDate 14:00 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void updateStudent(Integer student_id, YctuLiarbryStudents students) {
        YctuLiarbryStudentsExample example = new YctuLiarbryStudentsExample();
        //添加查询条件
        YctuLiarbryStudentsExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(student_id);
        mapper.updateByExample(students, example);
    }
}
