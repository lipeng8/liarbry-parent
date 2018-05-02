package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryIn;
import com.yctu.liarbry.pojo.YctuLiarbryInExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryInMapper {
    int countByExample(YctuLiarbryInExample example);

    int deleteByExample(YctuLiarbryInExample example);

    int insert(YctuLiarbryIn record);

    int insertSelective(YctuLiarbryIn record);

    List<YctuLiarbryIn> selectByExample(YctuLiarbryInExample example);

    int updateByExampleSelective(@Param("record") YctuLiarbryIn record, @Param("example") YctuLiarbryInExample example);

    int updateByExample(@Param("record") YctuLiarbryIn record, @Param("example") YctuLiarbryInExample example);
}