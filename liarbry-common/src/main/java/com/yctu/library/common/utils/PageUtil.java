package com.yctu.library.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/5/9--23:15
 */
public class PageUtil {

    public static List<?> page(List<?> list,Integer page,Integer rows) throws Exception {
        int startnum = 0;
        int endtnum = 0;
        List<?>  pagelist = new ArrayList<>();
        if (page < 1) {
            page = 1;
        }
            startnum = (page - 1) * rows;
            endtnum = page * rows;
            if(list.size()-1<= startnum){
                throw new Exception("集合长度小于开始截取长度");
            }else{
                if(list.size()<=endtnum){
                    pagelist = list.subList(startnum,list.size());
                    return  pagelist;
                }else if (list.size()>endtnum){
                    pagelist = list.subList(startnum,endtnum);
                    return  pagelist;
                }else {
                    throw new Exception("集合异常");
                }
            }
    }
}
