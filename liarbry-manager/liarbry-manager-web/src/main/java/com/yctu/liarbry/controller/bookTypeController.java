package com.yctu.liarbry.controller;

import com.yctu.liarbry.respojo.BookTypes;
import com.yctu.liarbry.service.interfaces.IQryBookTypeCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/5/5--15:01
 */
@Controller
public class bookTypeController {
    @Autowired
    private IQryBookTypeCSV bookTypeCSV;
    /**
     * 删除图书
     * <p>@Description </p>
     * <p>@createDate 21:26 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    @RequestMapping("/book/bookType")
    @ResponseBody
    public List<BookTypes> qryBookTypes(){
        List<BookTypes> list = bookTypeCSV.qryBookTypes();
        return  list;
    }


}
