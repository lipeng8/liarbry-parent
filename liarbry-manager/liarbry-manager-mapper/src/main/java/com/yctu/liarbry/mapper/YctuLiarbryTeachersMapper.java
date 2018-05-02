package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryTeachers;
import com.yctu.liarbry.pojo.YctuLiarbryTeachersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryTeachersMapper {
    int countByExample(YctuLiarbryTeachersExample example);

    int deleteByExample(YctuLiarbryTeachersExample example);

    int deleteByPrimaryKey(Integer teacherId);

    int insert(YctuLiarbryTeachers record);

    int insertSelective(YctuLiarbryTeachers record);

    List<YctuLiarbryTeachers> selectByExample(YctuLiarbryTeachersExample example);

    YctuLiarbryTeachers selectByPrimaryKey(Integer teacherId);

    int updateByExampleSelective(@Param("record") YctuLiarbryTeachers record, @Param("example") YctuLiarbryTeachersExample example);

    int updateByExample(@Param("record") YctuLiarbryTeachers record, @Param("example") YctuLiarbryTeachersExample example);

    int updateByPrimaryKeySelective(YctuLiarbryTeachers record);

    int updateByPrimaryKey(YctuLiarbryTeachers record);
}