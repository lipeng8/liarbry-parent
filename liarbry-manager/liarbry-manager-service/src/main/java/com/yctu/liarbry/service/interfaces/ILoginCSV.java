package com.yctu.liarbry.service.interfaces;


import com.yctu.library.common.pojo.LoginCode;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--21:29
 */
public interface ILoginCSV {
    /**
     * 登陆
     * <p>@Description </p>
     * <p>@createDate 21:30 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    LoginCode login(Integer lg_id, String lg_pwd, Integer lg_type);
}
