package com.yctu.library.common.utils;

/**
 * @Author:LiPeng
 * @Date:2018/5/1--22:39
 */
public class EncodeUtil {
    public static String EncodeUtil(String val){
        String val1 = null;
        try {
            val1 = java.net.URLDecoder.decode(val,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return val1;
    }
}
