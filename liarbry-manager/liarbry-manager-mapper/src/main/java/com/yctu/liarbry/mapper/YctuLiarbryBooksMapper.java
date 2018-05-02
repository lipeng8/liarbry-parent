package com.yctu.liarbry.mapper;

import com.yctu.liarbry.pojo.YctuLiarbryBooks;
import com.yctu.liarbry.pojo.YctuLiarbryBooksExample;
import com.yctu.liarbry.pojo.YctuLiarbryBooksKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YctuLiarbryBooksMapper {
    int countByExample(YctuLiarbryBooksExample example);

    int deleteByExample(YctuLiarbryBooksExample example);

    int deleteByPrimaryKey(YctuLiarbryBooksKey key);

    int insert(YctuLiarbryBooks record);

    int insertSelective(YctuLiarbryBooks record);

    List<YctuLiarbryBooks> selectByExample(YctuLiarbryBooksExample example);

    YctuLiarbryBooks selectByPrimaryKey(YctuLiarbryBooksKey key);

    int updateByExampleSelective(@Param("record") YctuLiarbryBooks record, @Param("example") YctuLiarbryBooksExample example);

    int updateByExample(@Param("record") YctuLiarbryBooks record, @Param("example") YctuLiarbryBooksExample example);

    int updateByPrimaryKeySelective(YctuLiarbryBooks record);

    int updateByPrimaryKey(YctuLiarbryBooks record);
}