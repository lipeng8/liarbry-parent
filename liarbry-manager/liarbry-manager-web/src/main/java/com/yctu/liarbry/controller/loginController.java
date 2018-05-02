package com.yctu.liarbry.controller;

import com.yctu.liarbry.service.interfaces.ILoginCSV;
import com.yctu.library.common.pojo.LoginCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--21:30
 */
@Controller
public class loginController {
    @Autowired
    private ILoginCSV loginCSV;

    @RequestMapping("/book/login")
    @ResponseBody
    /**登陆验证
     *<p>@Description </p>
     *<p>@createDate 21:46 2018/4/28</p>
     *@author lipeng
     *@param [lg_id, lg_pwd, lg_type]
     *@return com.yctu.library.common.pojo.SuccessCode
     */
    public LoginCode login(Integer lg_id, String lg_pwd, Integer lg_type) {
        LoginCode login = loginCSV.login(lg_id, lg_pwd, lg_type);
        return login;
    }
}
