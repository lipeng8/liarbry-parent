package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.mapper.YctuLiarbryOpMapper;
import com.yctu.liarbry.pojo.YctuLiarbryOp;
import com.yctu.liarbry.pojo.YctuLiarbryOpExample;
import com.yctu.liarbry.service.interfaces.ILibraryOpCSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:38
 */
@Service
public class LibraryOpCSVImpl implements ILibraryOpCSV {
    /**
     * 全局log
     */
    private static final Logger log = LoggerFactory.getLogger(LibraryOpCSVImpl.class);
    @Autowired
    private YctuLiarbryOpMapper mapper;

    /**
     * 查询操作员
     * <p>@Description </p>
     * <p>@createDate 16:02 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public YctuLiarbryOp qryOpName(Integer op_id) {
        log.info("查询操作员开始：op_id=" + op_id);
        YctuLiarbryOpExample example = new YctuLiarbryOpExample();
        //添加查询条件
        YctuLiarbryOpExample.Criteria criteria = example.createCriteria();
        criteria.andOpIdEqualTo(op_id);
        List<YctuLiarbryOp> list = mapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            YctuLiarbryOp opName = list.get(0);
            log.info("查询操作员结束：op_id=" + op_id);
            return opName;
        }
        return null;
    }

    /**
     * 添加操作员
     * <p>@Description </p>
     * <p>@createDate 13:49 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void insertOp(YctuLiarbryOp op) {
        log.info("查询操作员开始：");
        mapper.insert(op);
        log.info("查询操作员结束：");
    }

    /**
     * 删除操作员by op_id
     * <p>@Description </p>
     * <p>@createDate 13:57 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void deleteOp(Integer op_id) {
        log.info("删除操作员开始：op_id=" + op_id);
        YctuLiarbryOpExample example = new YctuLiarbryOpExample();
//添加查询条件
        YctuLiarbryOpExample.Criteria criteria = example.createCriteria();
        criteria.andOpIdEqualTo(op_id);
        //应该加异常
        mapper.deleteByExample(example);
        log.info("删除操作员结束：op_id=" + op_id);

    }

    /**
     * 删除操作员根据姓名
     * <p>@Description </p>
     * <p>@createDate 13:59 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void deleteOp(String op_name) {
        log.info("删除操作员开始：op_name=" + op_name);
        YctuLiarbryOpExample example = new YctuLiarbryOpExample();
//添加查询条件
        YctuLiarbryOpExample.Criteria criteria = example.createCriteria();
        criteria.andOpNameEqualTo(op_name);
        //应该加异常
        mapper.deleteByExample(example);
        log.info("删除操作员结束：op_name=" + op_name);

    }

    /**
     * 更改操作员信息
     * <p>@Description </p>
     * <p>@createDate 14:00 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void updateOp(Integer op_id, YctuLiarbryOp op) {
        log.info("更改操作员信息开始：op_id=" + op_id);
        YctuLiarbryOpExample example = new YctuLiarbryOpExample();
        //添加查询条件
        YctuLiarbryOpExample.Criteria criteria = example.createCriteria();
        criteria.andOpIdEqualTo(op_id);
        mapper.updateByExample(op, example);
        log.info("更改操作员信息结束：op_id=" + op_id);
    }
}
