package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryOut;
import com.yctu.liarbry.pojo.YctuLiarbryOutExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryOutMapper {
    int countByExample(YctuLiarbryOutExample example);

    int deleteByExample(YctuLiarbryOutExample example);

    int insert(YctuLiarbryOut record);

    int insertSelective(YctuLiarbryOut record);

    List<YctuLiarbryOut> selectByExample(YctuLiarbryOutExample example);

    int updateByExampleSelective(@Param("record") YctuLiarbryOut record, @Param("example") YctuLiarbryOutExample example);

    int updateByExample(@Param("record") YctuLiarbryOut record, @Param("example") YctuLiarbryOutExample example);
}