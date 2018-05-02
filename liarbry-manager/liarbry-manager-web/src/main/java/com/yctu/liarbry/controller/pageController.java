package com.yctu.liarbry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 *
 * @Author:LiPeng
 * @Date:2018/4/21--12:29
 */
@Controller
public class pageController {
    /**
     * 打开首页
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
     /**
      * 展示其他页面
      *<p>@Description </p>
      *<p>@createDate 12:40 2018/4/21</p>
      *@author lipeng
      *@param
      *@return
      */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
