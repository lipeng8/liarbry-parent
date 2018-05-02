package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryBooktypes;
import com.yctu.liarbry.pojo.YctuLiarbryBooktypesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryBooktypesMapper {
    int countByExample(YctuLiarbryBooktypesExample example);

    int deleteByExample(YctuLiarbryBooktypesExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(YctuLiarbryBooktypes record);

    int insertSelective(YctuLiarbryBooktypes record);

    List<YctuLiarbryBooktypes> selectByExample(YctuLiarbryBooktypesExample example);

    YctuLiarbryBooktypes selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") YctuLiarbryBooktypes record, @Param("example") YctuLiarbryBooktypesExample example);

    int updateByExample(@Param("record") YctuLiarbryBooktypes record, @Param("example") YctuLiarbryBooktypesExample example);

    int updateByPrimaryKeySelective(YctuLiarbryBooktypes record);

    int updateByPrimaryKey(YctuLiarbryBooktypes record);
}