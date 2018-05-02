package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryOp;
import com.yctu.liarbry.pojo.YctuLiarbryOpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryOpMapper {
    int countByExample(YctuLiarbryOpExample example);

    int deleteByExample(YctuLiarbryOpExample example);

    int deleteByPrimaryKey(Integer opId);

    int insert(YctuLiarbryOp record);

    int insertSelective(YctuLiarbryOp record);

    List<YctuLiarbryOp> selectByExample(YctuLiarbryOpExample example);

    YctuLiarbryOp selectByPrimaryKey(Integer opId);

    int updateByExampleSelective(@Param("record") YctuLiarbryOp record, @Param("example") YctuLiarbryOpExample example);

    int updateByExample(@Param("record") YctuLiarbryOp record, @Param("example") YctuLiarbryOpExample example);

    int updateByPrimaryKeySelective(YctuLiarbryOp record);

    int updateByPrimaryKey(YctuLiarbryOp record);
}