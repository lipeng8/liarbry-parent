package com.yctu.liarbry.service.impl;

import com.yctu.liarbry.pojo.YctuLiarbryHis;
import com.yctu.liarbry.pojo.YctuLiarbryOp;
import com.yctu.liarbry.pojo.YctuLiarbryTeachers;
import com.yctu.liarbry.service.interfaces.*;
import com.yctu.library.common.pojo.LoginCode;
import com.yctu.library.common.pojo.SuccessCode;
import com.yctu.library.common.utils.SuccessUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:LiPeng
 * @Date:2018/4/28--21:29
 */
@Service
public class LoginCSVImpl implements ILoginCSV {
    /**
     * 全局log
     */
    private static final Log log = LogFactory.getLog(LoginCSVImpl.class);
    @Autowired
    private ILibraryOpCSV libraryOpCSV;
    @Autowired
    private IBookHisCSV hisCSV;
    @Autowired
    private ITeacherCSV teacherCSV;


    /**
     * 登陆
     * <p>@Description </p>
     * <p>@createDate 21:30 2018/4/28</p>
     *
     * @param
     * @return
     * @author lipeng
     */
    public LoginCode login(Integer lg_id, String lg_pwd, Integer lg_type) {
        log.info("登陆开始：lg_id" + lg_id);
        String rscode = "";
        YctuLiarbryHis his = new YctuLiarbryHis();
        SuccessCode successCode = new SuccessCode();
        LoginCode loginCode = new LoginCode();
        try {
            if (lg_type == 1) {
                YctuLiarbryOp op = libraryOpCSV.qryOpName(lg_id);
                if (op != null) {
                    if (!op.getOpPassword().equals(lg_pwd)) {
                        throw new Exception("15");
                    }
                    loginCode.setName(op.getOpName());
                } else {
                    throw new Exception("06");
                }
            } else if (lg_type == 2) {
                YctuLiarbryTeachers teachers = teacherCSV.qryTeacher(lg_id);
                if (teachers != null) {
                    if (!teachers.getTeacherPwd().equals(lg_pwd)) {
                        throw new Exception("15");
                    }
                    loginCode.setName(teachers.getTeacherName());
                } else {
                    throw new Exception("17");
                }
            } else {
                throw new Exception("18");
            }
        } catch (Exception e) {
            rscode = e.getMessage();
            SuccessUtil successUtil = new SuccessUtil();
            successCode = successUtil.rsutils(rscode);

        } finally {
            if (lg_type == 1) {
                if ("".equals(rscode) || rscode == null) {
                    his.setCode(00);
                    his.setCodeMsg("成功");
                    his.setOpId(lg_id);
                    his.setStId(0);
                    his.setType("管理员登陆");
                    loginCode.setRscode(00);
                    loginCode.setRsdec("成功");

                } else {
                    his.setCode(successCode.getRscode());
                    his.setCodeMsg(successCode.getRsdec());
                    his.setOpId(lg_id);
                    his.setStId(0);
                    his.setType("管理员登陆");
                    loginCode.setRscode(successCode.getRscode());
                    loginCode.setRsdec(successCode.getRsdec());
                }
            } else if (lg_type == 2) {
                if ("".equals(rscode) || rscode == null) {
                    his.setCode(00);
                    his.setCodeMsg("成功");
                    his.setOpId(0);
                    his.setStId(lg_id);
                    his.setType("教师登陆");
                    loginCode.setRscode(00);
                    loginCode.setRsdec("成功");
                } else {
                    his.setCode(successCode.getRscode());
                    his.setCodeMsg(successCode.getRsdec());
                    his.setOpId(0);
                    his.setStId(lg_id);
                    his.setType("教师登陆");
                    loginCode.setRscode(successCode.getRscode());
                    loginCode.setRsdec(successCode.getRsdec());
                }
            } else {
                his.setCode(successCode.getRscode());
                his.setCodeMsg(successCode.getRsdec());
                his.setOpId(0);
                his.setStId(lg_id);
                his.setType("类型不对");
                loginCode.setRscode(successCode.getRscode());
                loginCode.setRsdec(successCode.getRsdec());
            }
            hisCSV.insertHis(his);
            log.info("登陆结束：lg_id=" + lg_id + "  rsdec=" + successCode.getRsdec());
            return loginCode;
        }
    }
}
