package com.yctu.liarbry.controller;

import com.yctu.liarbry.pojo.YctuLiarbryOut;
import com.yctu.liarbry.service.interfaces.IBookOutCSV;
import com.yctu.library.common.pojo.EUDataGridResult;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.pojo.SuccessMoneyCode;
import com.yctu.library.common.utils.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--21:27
 */
@Controller
public class outBookController {
    @Autowired
    private IBookOutCSV bookOutCSV;
    @RequestMapping("/book/out")
    @ResponseBody
    /**
     * 添加借书记录
     * <p>@Description </p>
     * <p>@createDate 13:52 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public SuccessCode insertOut(Integer bookId,Integer outStId,Integer outOpId,String ext1,String ext2){
        YctuLiarbryOut out = new YctuLiarbryOut();
        out.setBookId(bookId);
        out.setOutStId(outStId);
        out.setOutOpId(outOpId);
        out.setOutStaus(1);
        out.setExt1(EncodeUtil.EncodeUtil(ext1));
        out.setExt2(EncodeUtil.EncodeUtil(ext2));
        SuccessCode successCode = bookOutCSV.insertOut(out);
        return successCode;
    }
    @RequestMapping("/book/outQry")
    @ResponseBody

    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:55 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryBookOutList(String studentName,Integer out_st_id, Integer page, Integer rows){
        EUDataGridResult euDataGridResult = bookOutCSV.qryBookOutList(EncodeUtil.EncodeUtil(studentName),out_st_id,page,rows);
        return euDataGridResult;
    }
    @RequestMapping("/book/teaOutQry")
    @ResponseBody

    /**
     * 借书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:55 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryBookOutList(Integer teacher_id,String studentName,Integer out_st_id, Integer page, Integer rows){
        EUDataGridResult euDataGridResult = bookOutCSV.teaOutQry(teacher_id,EncodeUtil.EncodeUtil(studentName),out_st_id,page,rows);
        return euDataGridResult;
    }
    @RequestMapping("/book/outDetele")
    @ResponseBody
    /**
     * 删除借书记录 by st_id
     * <p>@Description </p>
     * <p>@createDate 13:57 2018/4/27</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public  SuccessMoneyCode deleteOut(Integer out_st_id, Integer book_id){
        SuccessMoneyCode successMoneyCode = bookOutCSV.deleteOut(out_st_id,book_id);
        return successMoneyCode;
    }
}
