package com.yctu.library.common.utils;

import com.yctu.library.common.pojo.SuccessCode;

/**
 * @Author:LiPeng
 * @Date:2018/4/27--14:31
 */
public class SuccessUtil {
    public SuccessCode rsutils(String rsCode){
        SuccessCode successCode = new SuccessCode();
        if ("01".equals(rsCode) ){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("当前操作员无此权限  请核实信息");
            return  successCode;
        } else if ("02".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("无该卡信息  请核实校园卡");
            return  successCode;
        }else  if ("03".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("该图书已借完   敬请谅解");
            return  successCode;
        }else  if ("04".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("该卡借书次数已用完  请还书之后再进行借书操作");
            return  successCode;
        }else  if ("05".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("无该图书信息 请重新核实");
            return  successCode;
        }else  if ("06".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("无该操作员信息 请重新核实");
            return  successCode;
        }else  if ("07".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("图书已存在 请重新核实");
            return  successCode;
        } else  if ("08".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("学生信息不存在 请重新核实");
            return  successCode;
        }else  if ("09".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("存在未归还图书 不能删除信息");
            return  successCode;
        }else  if ("10".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("非此班级任课教师 请核实");
            return  successCode;
        }else  if ("11".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("图书记录已失效 请核实");
            return  successCode;
        }else  if ("12".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("图书记录不存在 请重新核实");
            return  successCode;
        }else  if ("13".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("此借书卡未借此书 请重新核实");
            return  successCode;
        }else  if ("14".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("没有可查阅学生 请重新核实");
            return  successCode;
        }else  if ("15".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("密码错误 请重新输入");
            return  successCode;
        }else  if ("16".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("密码错误次数已满 请30分后重新输入");
            return  successCode;
        }else  if ("17".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("无该教师信息 请重新核实");
            return  successCode;
        }else  if ("18".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("资料信息不准确 请重新核实");
            return  successCode;
        }else  if ("19".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("没有获取到用户登陆 请登录");
            return  successCode;
        }else  if ("20".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("该账号已存在 请重新输入");
            return  successCode;
        }else  if ("21".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("该学生学号已存在 请重新输入");
            return  successCode;
        }else  if ("22".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("该老师账号已存在 请重新输入");
            return  successCode;
        }else  if ("23".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("该老师信息不存在 请重新输入");
            return  successCode;
        }else  if ("24".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("无科目信息 请重新输入");
            return  successCode;
        }else  if ("25".equals(rsCode)){
            successCode.setRscode(Integer.valueOf(rsCode));
            successCode.setRsdec("只能删除普通管理员、删除超级管理员请向学校申请");
            return  successCode;
        }
        successCode.setRscode(99);
        successCode.setRsdec("系统异常");
        return  successCode;
    }
}
