package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.mapper.YctuLiarbryHisMapper;
import com.yctu.liarbry.pojo.YctuLiarbryHis;
import com.yctu.liarbry.pojo.YctuLiarbryHisExample;
import com.yctu.liarbry.service.interfaces.IBookHisCSV;
import com.yctu.library.common.utils.BookTimeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:35
 */
@Service
public class BookHisCSVImpl implements IBookHisCSV {
    /**
     * 全局log
     */
    private static final Log log = LogFactory.getLog(BookHisCSVImpl.class);

    @Autowired
    private YctuLiarbryHisMapper mapper ;

    /**
     * 历史查询
     * <p>@Description </p>
     * <p>@createDate 15:50 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public List<YctuLiarbryHis> qryBookHis(Integer st_id) {
        YctuLiarbryHisExample example = new YctuLiarbryHisExample();
        //添加查询条件
        YctuLiarbryHisExample.Criteria criteria = example.createCriteria();
        criteria.andStIdEqualTo(st_id);
        List<YctuLiarbryHis> list = mapper.selectByExample(example);
        if (list != null && list.size() > 0) {
//            YctuLiarbryHis bookHis = list.get(0);
            return list;
        }
        return null;
    }

    /**
     * 添加记录
     * <p>@Description </p>
     * <p>@createDate 13:55 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void insertHis(YctuLiarbryHis his) {
        log.info("添加操作记录开始"+his.getOpId());
        his.setHisDate(BookTimeUtil.opTimes());
        mapper.insert(his);
        log.info("添加操作记录结束"+his.getOpId());
    }
}
