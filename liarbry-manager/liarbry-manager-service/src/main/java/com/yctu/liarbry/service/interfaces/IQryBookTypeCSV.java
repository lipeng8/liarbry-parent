package com.yctu.liarbry.service.interfaces;

import com.yctu.liarbry.pojo.YctuLiarbryBooktypes;
import com.yctu.liarbry.respojo.BookTypes;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--14:18
 */
public interface IQryBookTypeCSV {
    /**
     * 查询科目
     * <p>@Description </p>
     * <p>@createDate 14:32 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    YctuLiarbryBooktypes qryBookTypes(Integer typeId);
    /**
     * 查询科目
     * <p>@Description </p>
     * <p>@createDate 14:32 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    List<BookTypes> qryBookTypes();
    /**
     * 新增科目
     * <p>@Description </p>
     * <p>@createDate 14:40 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void insertBookTypes(Integer typeId, String typename);

    /**
     * 删除科目
     * <p>@Description </p>
     * <p>@createDate 14:25 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void deleteBookTypes(Integer typeId);

    /**
     * 更改科目
     * <p>@Description </p>
     * <p>@createDate 14:40 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    void updateBookTypes(Integer typeId, String typename);
}
