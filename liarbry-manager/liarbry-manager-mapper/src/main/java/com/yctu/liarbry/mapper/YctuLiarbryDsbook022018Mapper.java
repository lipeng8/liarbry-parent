package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryDsbook022018;
import com.yctu.liarbry.pojo.YctuLiarbryDsbook022018Example;
import com.yctu.liarbry.pojo.YctuLiarbryDsbook022018Key;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryDsbook022018Mapper {
    int countByExample(YctuLiarbryDsbook022018Example example);

    int deleteByExample(YctuLiarbryDsbook022018Example example);

    int deleteByPrimaryKey(YctuLiarbryDsbook022018Key key);

    int insert(YctuLiarbryDsbook022018 record);

    int insertSelective(YctuLiarbryDsbook022018 record);

    List<YctuLiarbryDsbook022018> selectByExample(YctuLiarbryDsbook022018Example example);

    YctuLiarbryDsbook022018 selectByPrimaryKey(YctuLiarbryDsbook022018Key key);

    int updateByExampleSelective(@Param("record") YctuLiarbryDsbook022018 record, @Param("example") YctuLiarbryDsbook022018Example example);

    int updateByExample(@Param("record") YctuLiarbryDsbook022018 record, @Param("example") YctuLiarbryDsbook022018Example example);

    int updateByPrimaryKeySelective(YctuLiarbryDsbook022018 record);

    int updateByPrimaryKey(YctuLiarbryDsbook022018 record);
}