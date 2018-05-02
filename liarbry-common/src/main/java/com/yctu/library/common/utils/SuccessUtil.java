package com.yctu.library.common.utils;

import com.yctu.library.common.pojo.SuccessCode;

/**
 * @Author:LiPeng
 * @Date:2018/4/27--14:31
 */
public class SuccessUtil {
    public SuccessCode rsutils(int rsCode){
        SuccessCode successCode = new SuccessCode();
        if (rsCode==01 ){
            successCode.setRscode(rsCode);
            successCode.setRsdec("当前操作员无此权限  请核实信息");
            return  successCode;
        } else if (rsCode==02){
            successCode.setRscode(rsCode);
            successCode.setRsdec("无该卡信息  请核实校园卡");
            return  successCode;
        }else  if (rsCode==03){
            successCode.setRscode(rsCode);
            successCode.setRsdec("该图书已借完   敬请谅解");
            return  successCode;
        }else  if (rsCode==04){
            successCode.setRscode(rsCode);
            successCode.setRsdec("该卡借书次数已用完  请还书之后再进行借书操作");
            return  successCode;
        }else  if (rsCode==05){
            successCode.setRscode(rsCode);
            successCode.setRsdec("无该图书信息 请重新核实");
            return  successCode;
        }else  if (rsCode==06){
            successCode.setRscode(rsCode);
            successCode.setRsdec("无该操作员信息 请重新核实");
            return  successCode;
        }else  if (rsCode==07){
            successCode.setRscode(rsCode);
            successCode.setRsdec("图书已存在 请重新核实");
            return  successCode;
        }else  if (rsCode==11){
            successCode.setRscode(rsCode);
            successCode.setRsdec("图书记录已失效 请核实");
            return  successCode;
        }else  if (rsCode==12){
            successCode.setRscode(rsCode);
            successCode.setRsdec("图书记录不存在 请重新核实");
            return  successCode;
        }else  if (rsCode==13){
            successCode.setRscode(rsCode);
            successCode.setRsdec("此借书卡未借此书 请重新核实");
            return  successCode;
        }else  if (rsCode==14){
            successCode.setRscode(rsCode);
            successCode.setRsdec("没有可查阅学生 请重新核实");
            return  successCode;
        }else  if (rsCode==15){
            successCode.setRscode(rsCode);
            successCode.setRsdec("密码错误 请重新输入");
            return  successCode;
        }else  if (rsCode==16){
            successCode.setRscode(rsCode);
            successCode.setRsdec("密码错误次数已满 请30分后重新输入");
            return  successCode;
        }else  if (rsCode==17){
            successCode.setRscode(rsCode);
            successCode.setRsdec("无该教师信息 请重新核实");
            return  successCode;
        }else  if (rsCode==18){
            successCode.setRscode(rsCode);
            successCode.setRsdec("资料信息不准确 请重新核实");
            return  successCode;
        }else  if (rsCode==19){
            successCode.setRscode(rsCode);
            successCode.setRsdec("没有获取到用户登陆 请登录");
            return  successCode;
        }else  if (rsCode==20){
            successCode.setRscode(rsCode);
            successCode.setRsdec("该账号已存在 请重新输入");
            return  successCode;
        }else  if (rsCode==21){
            successCode.setRscode(rsCode);
            successCode.setRsdec("该学生学号已存在 请重新输入");
            return  successCode;
        }else  if (rsCode==22){
            successCode.setRscode(rsCode);
            successCode.setRsdec("该老师账号已存在 请重新输入");
            return  successCode;
        }else  if (rsCode==23){
            successCode.setRscode(rsCode);
            successCode.setRsdec("该老师信息不存在 请重新输入");
            return  successCode;
        }
        successCode.setRscode(99);
        successCode.setRsdec("系统异常");
        return  successCode;
    }
}
