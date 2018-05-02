package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.mapper.YctuLiarbryBooktypesMapper;
import com.yctu.liarbry.pojo.YctuLiarbryBooktypes;
import com.yctu.liarbry.pojo.YctuLiarbryBooktypesExample;
import com.yctu.liarbry.service.interfaces.IQryBookTypeCSV;
import com.yctu.library.common.utils.BookTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--14:18
 */
@Service
public class QryBookTypesCSVImpl implements IQryBookTypeCSV {
    @Autowired
    private YctuLiarbryBooktypesMapper liarbryBooktypesMapper;

    /**
     * 图书科目
     * <p>@Description </p>
     * <p>@createDate 14:25 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public YctuLiarbryBooktypes qryBookTypes(Integer typeId) {
        YctuLiarbryBooktypesExample example = new YctuLiarbryBooktypesExample();
        //添加查询条件
        YctuLiarbryBooktypesExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(typeId);
        List<YctuLiarbryBooktypes> list = liarbryBooktypesMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            YctuLiarbryBooktypes booktypes = list.get(0);
            return booktypes;
        }
        return null;
    }

    /**
     * 添加科目
     * <p>@Description </p>
     * <p>@createDate 14:25 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void insertBookTypes(Integer typeId, String typename) {
        YctuLiarbryBooktypes booktypes = new YctuLiarbryBooktypes();
        booktypes.setTypeId(typeId);
        booktypes.setTypeName(typename);
        booktypes.setCreateDate(BookTimeUtil.opTimes());
        liarbryBooktypesMapper.insert(booktypes);
    }

    /**
     * 删除科目
     * <p>@Description </p>
     * <p>@createDate 14:25 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void deleteBookTypes(Integer typeId) {
        YctuLiarbryBooktypesExample example = new YctuLiarbryBooktypesExample();
//添加查询条件
        YctuLiarbryBooktypesExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(typeId);
        //应该加异常
        liarbryBooktypesMapper.deleteByExample(example);

    }

    /**
     * 更改科目
     * <p>@Description </p>
     * <p>@createDate 14:26 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void updateBookTypes(Integer typeId, String typename) {
        YctuLiarbryBooktypesExample example = new YctuLiarbryBooktypesExample();
        //添加查询条件
        YctuLiarbryBooktypes booktypes = new YctuLiarbryBooktypes();
        booktypes = qryBookTypes(typeId);
        YctuLiarbryBooktypesExample.Criteria criteria = example.createCriteria();
        criteria.andTypeNameEqualTo(typename);
        liarbryBooktypesMapper.updateByExample(booktypes, example);
    }
}
