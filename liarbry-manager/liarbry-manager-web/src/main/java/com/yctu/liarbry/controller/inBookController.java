package com.yctu.liarbry.controller;

import com.yctu.liarbry.pojo.YctuLiarbryIn;
import com.yctu.liarbry.service.interfaces.IBookInCSV;
import com.yctu.library.common.pojo.EUDataGridResult;
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
public class inBookController {
    @Autowired
    private IBookInCSV iBookInCSV;

    @RequestMapping("/book/in")
    @ResponseBody
    /**还书书操作
     *<p>@Description </p>
     *<p>@createDate 21:48 2018/4/28</p>
     *@author lipeng
     *@param [in]
     *@return com.yctu.library.common.pojo.SuccessMoneyCode
     */
    public SuccessMoneyCode insertIn(Integer bookId,Integer inStId,Integer inOpId,Integer inStaus,String ext1,String ext2) {
        YctuLiarbryIn in = new YctuLiarbryIn();
        in.setExt1(EncodeUtil.EncodeUtil(ext1));
        in.setExt2(EncodeUtil.EncodeUtil(ext2));
        in.setBookId(bookId);
        in.setInStaus(inStaus);
        in.setInStId(inStId);
        in.setInOpId(inOpId);
        SuccessMoneyCode successMoneyCode = iBookInCSV.insertIn(in);
        return successMoneyCode;
    }

    @RequestMapping("/book/inQry")
    @ResponseBody
    /**
     * 还书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:53 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryBookInbyIdorname(Integer in_st_id,String studentName, Integer page, Integer rows) {
        EUDataGridResult euDataGridResult = iBookInCSV.qryBookInname(in_st_id,EncodeUtil.EncodeUtil(studentName),page, rows);
        return euDataGridResult;
    }
    @RequestMapping("/book/QryStuIn")
    @ResponseBody
    /**
     * 还书记录查询
     * <p>@Description </p>
     * <p>@createDate 15:53 2018/4/26</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public EUDataGridResult qryBookIn( Integer page, Integer rows) {
        EUDataGridResult euDataGridResult = iBookInCSV.qryBookIn( page, rows);
        return euDataGridResult;
    }

}
