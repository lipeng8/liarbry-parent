<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="css/library.css"/>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <title>管理员登录</title>
</head>
<body style="background-color: #F3F3F3">
<form id="loginForm" class="loginForm" method="post">
    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false"
         style="width:400px;height:300px;padding:10px;">
        <div style="margin-left: 50px;margin-top: 50px;">
            <div style="margin-bottom:20px;">
                <div>
                    用户名: <input id="username" class="easyui-textbox" data-options="required:true"
                                style="width:200px;height:32px"/>
                </div>
            </div>
            <div style="margin-bottom:20px">
                <div>
                    密&nbsp;&nbsp;&nbsp;码: <input id="password" class="easyui-textbox" data-options="required:true" type="password"
                                           style="width:200px;height:32px" data-options=""/>
                </div>
            </div>
            <div>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm()"
                   style="width:100px;height:32px;margin-left: 10px">管理员登录</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submit()"
                   style="width:100px;height:32px;margin-left: 30px">教师登录</a>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript">
    function submitForm() {
        var userName = $("#username").val();
        var passWord = $("#password").val();
        if (userName == null || userName == '' || userName == undefined) {
            $.messager.alert('错误', "请输入用户名");
            return;
        }
        if (passWord == null || passWord == '' || passWord == undefined) {
            $.messager.alert('错误', "请输入密码");
            return;
        }

        $.post("/book/login?lg_id=" + userName + "&lg_pwd=" + passWord + "&lg_type=" + 1, function (data) {
            if (data.rscode == 0) {
                window.location.href = "/index.jsp?opId="+userName+"&opName="+data.name;
            }else {
                $.messager.alert("警告",data.rsdec);
            }
        });
    };
    function submit() {
        var userName = $("#username").val();
        var passWord = $("#password").val();
        if (userName == null || userName == '' || userName == undefined) {
            $.messager.alert('错误', "请输入用户名");
            return;
        }
        if (passWord == null || passWord == '' || passWord == undefined) {
            $.messager.alert('错误', "请输入密码");
            return;
        }

        $.post("/book/login?lg_id=" + userName + "&lg_pwd=" + passWord + "&lg_type=" + 2, function (data) {
            if (data.rscode == 0) {
                window.location.href =  "/teacher.jsp?opId="+userName+"&opName="+data.name;
            }else {
                $.messager.alert("警告",data.rsdec);
            }
        });
    };
</script>
</body>
</html>