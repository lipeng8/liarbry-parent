package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryHis;
import com.yctu.liarbry.pojo.YctuLiarbryHisExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryHisMapper {
    int countByExample(YctuLiarbryHisExample example);

    int deleteByExample(YctuLiarbryHisExample example);

    int insert(YctuLiarbryHis record);

    int insertSelective(YctuLiarbryHis record);

    List<YctuLiarbryHis> selectByExample(YctuLiarbryHisExample example);

    int updateByExampleSelective(@Param("record") YctuLiarbryHis record, @Param("example") YctuLiarbryHisExample example);

    int updateByExample(@Param("record") YctuLiarbryHis record, @Param("example") YctuLiarbryHisExample example);
}