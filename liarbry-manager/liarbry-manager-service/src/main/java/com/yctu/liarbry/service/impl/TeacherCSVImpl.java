package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.mapper.YctuLiarbryTeachersMapper;
import com.yctu.liarbry.pojo.YctuLiarbryTeachers;
import com.yctu.liarbry.pojo.YctuLiarbryTeachersExample;
import com.yctu.liarbry.service.interfaces.ITeacherCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:40
 */
@Service
public class TeacherCSVImpl implements ITeacherCSV {
    @Autowired
    private YctuLiarbryTeachersMapper mapper;

    /**
     * 查询老师
     * <p>@Description </p>
     * <p>@createDate 16:08 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public YctuLiarbryTeachers qryTeacher(Integer teacher_id) {
        YctuLiarbryTeachersExample example = new YctuLiarbryTeachersExample();
//添加查询条件
        YctuLiarbryTeachersExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherIdEqualTo(teacher_id);
        List<YctuLiarbryTeachers> list = mapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            YctuLiarbryTeachers teacher = list.get(0);
            return teacher;
        }
        return null;
    }

    /**
     * 添加老师
     * <p>@Description </p>
     * <p>@createDate 13:48 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void insertTeacher(YctuLiarbryTeachers teachers) {
        mapper.insert(teachers);
    }

    /**
     * 删除老师by teacher_id
     * <p>@Description </p>
     * <p>@createDate 13:57 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void deleteTeacher(Integer teacher_id) {
        YctuLiarbryTeachersExample example = new YctuLiarbryTeachersExample();
//添加查询条件
        YctuLiarbryTeachersExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherIdEqualTo(teacher_id);
        //应该加异常
        mapper.deleteByExample(example);

    }

    /**
     * 删除老师根据姓名
     * <p>@Description </p>
     * <p>@createDate 13:59 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void deleteTeacher(String teacher_name) {
        YctuLiarbryTeachersExample example = new YctuLiarbryTeachersExample();
//添加查询条件
        YctuLiarbryTeachersExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherNameEqualTo(teacher_name);
        //应该加异常
        mapper.deleteByExample(example);

    }

    /**
     * 更改老师信息
     * <p>@Description </p>
     * <p>@createDate 14:00 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void updateTeacher(Integer teacher_id, YctuLiarbryTeachers teachers) {
        YctuLiarbryTeachersExample example = new YctuLiarbryTeachersExample();
        //添加查询条件
        YctuLiarbryTeachersExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherIdEqualTo(teacher_id);
        mapper.updateByExample(teachers, example);
    }
}
