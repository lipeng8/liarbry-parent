package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryTeaclass;
import com.yctu.liarbry.pojo.YctuLiarbryTeaclassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryTeaclassMapper {
    int countByExample(YctuLiarbryTeaclassExample example);

    int deleteByExample(YctuLiarbryTeaclassExample example);

    int insert(YctuLiarbryTeaclass record);

    int insertSelective(YctuLiarbryTeaclass record);

    List<YctuLiarbryTeaclass> selectByExample(YctuLiarbryTeaclassExample example);

    int updateByExampleSelective(@Param("record") YctuLiarbryTeaclass record, @Param("example") YctuLiarbryTeaclassExample example);

    int updateByExample(@Param("record") YctuLiarbryTeaclass record, @Param("example") YctuLiarbryTeaclassExample example);
}