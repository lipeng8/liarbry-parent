package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.mapper.YctuLiarbryTeachersMapper;
import com.yctu.liarbry.pojo.YctuLiarbryTeachers;
import com.yctu.liarbry.pojo.YctuLiarbryTeachersExample;
import com.yctu.liarbry.service.interfaces.ITeacherCSV;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:40
 */
@Service
public class TeacherCSVImpl implements ITeacherCSV {
    /**
     * 全局log
     */
    private static final Log log = LogFactory.getLog(TeacherCSVImpl.class);
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
        log.info("查询老师：开始：teacher_id=" + teacher_id);
        YctuLiarbryTeachersExample example = new YctuLiarbryTeachersExample();
//添加查询条件
        YctuLiarbryTeachersExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherIdEqualTo(teacher_id);
        List<YctuLiarbryTeachers> list = mapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            YctuLiarbryTeachers teacher = list.get(0);
            log.info("查询老师：结束：teacher_id=" + teacher_id);
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
        log.info("查询老师：开始：teacher_id=" + teachers.getTeacherId());
        mapper.insert(teachers);
        log.info("查询老师：结束：teacher_id=" + teachers.getTeacherId());
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
        log.info("删除老师by：开始：teacher_id=" + teacher_id);
        YctuLiarbryTeachersExample example = new YctuLiarbryTeachersExample();
//添加查询条件
        YctuLiarbryTeachersExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherIdEqualTo(teacher_id);
        //应该加异常
        mapper.deleteByExample(example);
        log.info("删除老师by：结束：teacher_id=" + teacher_id);

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
        log.info("删除老师by：开始：teacher_name=" + teacher_name);
        YctuLiarbryTeachersExample example = new YctuLiarbryTeachersExample();
//添加查询条件
        YctuLiarbryTeachersExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherNameEqualTo(teacher_name);
        //应该加异常
        mapper.deleteByExample(example);
        log.info("删除老师by：结束：teacher_name=" + teacher_name);

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
        log.info("更改老师信息：开始：teacher_id=" + teacher_id);
        YctuLiarbryTeachersExample example = new YctuLiarbryTeachersExample();
        //添加查询条件
        YctuLiarbryTeachersExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherIdEqualTo(teacher_id);
        mapper.updateByExample(teachers, example);
        log.info("更改老师信息：结束：teacher_id=" + teacher_id);
    }
}
