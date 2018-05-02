package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.mapper.YctuLiarbryDsbook022018Mapper;
import com.yctu.liarbry.pojo.*;
import com.yctu.liarbry.service.interfaces.*;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.utils.SuccessUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/26--15:34
 */
@Service
public class DsBookCSVImpl implements IDsBookCSV {
    @Autowired
    private YctuLiarbryDsbook022018Mapper mapper;
    @Autowired
    private IBookHisCSV hisCSV;
    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:58 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public List<YctuLiarbryDsbook022018> qryDsBook(Integer st_id) {
        YctuLiarbryDsbook022018Example example = new YctuLiarbryDsbook022018Example();
//添加查询条件
        YctuLiarbryDsbook022018Example.Criteria criteria = example.createCriteria();
        criteria.andStIdEqualTo(st_id);
        List<YctuLiarbryDsbook022018> list = mapper.selectByExample(example);
        return list;
    }

    /**
     * 添加损坏记录
     * <p>@Description </p>
     * <p>@createDate 13:54 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @Override
    public void insertDSBook(YctuLiarbryDsbook022018 dsbook) {
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        try {
            mapper.insert(dsbook);
        }catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode=successUtil.rsutils(Integer.valueOf(rscode));
        } finally {
            if ("".equals(rscode) || rscode == null) {
                his.setCode(00);
                his.setCodeMsg("成功");
                his.setOpId(dsbook.getOpId());
                his.setStId(dsbook.getStId());
                his.setType("损坏记录");
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(dsbook.getOpId());
                his.setStId(dsbook.getStId());
                his.setType("损坏记录");
            }
            hisCSV.insertHis(his);
        }
    }
}
