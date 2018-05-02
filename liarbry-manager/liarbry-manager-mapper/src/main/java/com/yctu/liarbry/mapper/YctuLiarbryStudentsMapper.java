package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryStudents;
import com.yctu.liarbry.pojo.YctuLiarbryStudentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryStudentsMapper {
    int countByExample(YctuLiarbryStudentsExample example);

    int deleteByExample(YctuLiarbryStudentsExample example);

    int deleteByPrimaryKey(Integer studentId);

    int insert(YctuLiarbryStudents record);

    int insertSelective(YctuLiarbryStudents record);

    List<YctuLiarbryStudents> selectByExample(YctuLiarbryStudentsExample example);

    YctuLiarbryStudents selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("record") YctuLiarbryStudents record, @Param("example") YctuLiarbryStudentsExample example);

    int updateByExample(@Param("record") YctuLiarbryStudents record, @Param("example") YctuLiarbryStudentsExample example);

    int updateByPrimaryKeySelective(YctuLiarbryStudents record);

    int updateByPrimaryKey(YctuLiarbryStudents record);
}