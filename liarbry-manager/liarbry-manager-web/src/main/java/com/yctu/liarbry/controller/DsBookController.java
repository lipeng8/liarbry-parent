package com.yctu.liarbry.controller;

import com.yctu.liarbry.service.interfaces.IDsBookCSV;
import com.yctu.library.common.pojo.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:LiPeng
 * @Date:2018/5/3--8:51
 */
@Controller
public class DsBookController {
    @Autowired
    private IDsBookCSV dsBookCSV;
    @RequestMapping("/book/qryDsBookByStId")
    @ResponseBody
    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:59 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public  EUDataGridResult qryDsBookByStId(Integer st_id, Integer page, Integer rows){
        EUDataGridResult euDataGridResult = dsBookCSV.qryDsBookByStId(st_id,page,rows);
        return euDataGridResult;
    }

    @RequestMapping("/book/qryDsBookByOp")
    @ResponseBody

    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:59 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public  EUDataGridResult qryDsBookByOp(Integer opId, Integer page, Integer rows){
        EUDataGridResult euDataGridResult = dsBookCSV.qryDsBookByOp(opId,page,rows);
        return euDataGridResult;
    }

    @RequestMapping("/book/qryDsBook")
    @ResponseBody
    /**
     * 损坏记录查询
     * <p>@Description </p>
     * <p>@createDate 15:59 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public  EUDataGridResult qryDsBook( Integer page, Integer rows){
        EUDataGridResult euDataGridResult = dsBookCSV.qryDsBook(page,rows);
        return euDataGridResult;
    }
}
