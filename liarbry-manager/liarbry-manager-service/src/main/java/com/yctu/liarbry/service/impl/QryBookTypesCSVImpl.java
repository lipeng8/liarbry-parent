package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.mapper.YctuLiarbryBooktypesMapper;
import com.yctu.liarbry.pojo.YctuLiarbryBooktypes;
import com.yctu.liarbry.pojo.YctuLiarbryBooktypesExample;
import com.yctu.liarbry.respojo.BookTypes;
import com.yctu.liarbry.service.interfaces.IQryBookTypeCSV;
import com.yctu.library.common.utils.BookTimeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--14:18
 */
@Service
public class QryBookTypesCSVImpl implements IQryBookTypeCSV {
    /**
     * 全局log
     */
    private static final Log log = LogFactory.getLog(QryBookTypesCSVImpl.class);
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
        log.info("图书科目查询：开始：typeId=" + typeId);
        YctuLiarbryBooktypesExample example = new YctuLiarbryBooktypesExample();
        //添加查询条件
        YctuLiarbryBooktypesExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(typeId);
        List<YctuLiarbryBooktypes> list = liarbryBooktypesMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            YctuLiarbryBooktypes booktypes = list.get(0);
            log.info("图书科目查询：结束：typeId=" + typeId);
            return booktypes;
        }
        return null;
    }
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
    public  List<BookTypes> qryBookTypes() {
        log.info("图书科目查询：开始：typeId=" );
        YctuLiarbryBooktypesExample example = new YctuLiarbryBooktypesExample();
        //添加查询条件
        List<YctuLiarbryBooktypes> list = liarbryBooktypesMapper.selectByExample(example);
        List<BookTypes> bookTypes = new ArrayList<BookTypes>();
        for (YctuLiarbryBooktypes liarbryBooktypes : list){
            BookTypes bookTypes1 = new BookTypes();
            bookTypes1.setBookType(String.valueOf(liarbryBooktypes.getTypeId()));
            bookTypes1.setBookName(liarbryBooktypes.getTypeName());
            bookTypes.add(bookTypes1);
        }
        log.info("图书科目查询：结束：typeId=" );
        return bookTypes;
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
        log.info("添加科目：开始：typeId=" + typeId);
        YctuLiarbryBooktypes booktypes = new YctuLiarbryBooktypes();
        booktypes.setTypeId(typeId);
        booktypes.setTypeName(typename);
        booktypes.setCreateDate(BookTimeUtil.opTimes());
        liarbryBooktypesMapper.insert(booktypes);
        log.info("添加科目：结束：typeId=" + typeId);
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
        log.info("删除科目：开始：typeId=" + typeId);
        YctuLiarbryBooktypesExample example = new YctuLiarbryBooktypesExample();
//添加查询条件
        YctuLiarbryBooktypesExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(typeId);
        //应该加异常
        liarbryBooktypesMapper.deleteByExample(example);
        log.info("删除科目：结束：typeId=" + typeId);

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
        log.info("更改科目：开始：typeId=" + typeId);
        YctuLiarbryBooktypesExample example = new YctuLiarbryBooktypesExample();
        //添加查询条件
        YctuLiarbryBooktypes booktypes = new YctuLiarbryBooktypes();
        booktypes = qryBookTypes(typeId);
        YctuLiarbryBooktypesExample.Criteria criteria = example.createCriteria();
        criteria.andTypeNameEqualTo(typename);
        liarbryBooktypesMapper.updateByExample(booktypes, example);
        log.info("更改科目：结束：typeId=" + typeId);
    }
}
