<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String opId = request.getParameter("opId");//用request得到
%>
<div style="padding:10px 10px 10px 10px">
    <form id="saveopForm" class="saveopForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>管理员账号:</td>
                <td><input class="easyui-textbox" type="text" id="op_id" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>管理员密码:</td>
                <td><input class="easyui-textbox" type="text" id="op_pwd" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>管理员姓名:</td>
                <td><input class="easyui-textbox" type="text" id="op_name" data-options="required:true"
                           style="width: 280px;" ></input></td>
            </tr>
            <td>管理员权限:</td>
            <td>
                <input id='noneFlag' type="radio" name="bookFlag" value="2" checked="checked">普通管理员</input>
                <input id='flag2' type="radio" name="bookFlag" value="1">超级管理员</input>
            </td>
            </tr>
            <tr>
                <td>补充1:</td>
                <td><input class="easyui-textbox" type="text" id="ext1"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;"></input></td>
            </tr>
            <tr>
                <td>补充2:</td>
                <td><input class="easyui-textbox" type="text" id="ext2"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;"></input></td>
            </tr>
        </table>
        <input type="hidden" name="bookParams"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="backBook()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="inClear()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var radio = 2;
    $(function () {
        $(":radio").click(function () {
            radio = $(this).val();
        });
    });

    function backBook() {
        var op_id = $("#op_id").val();
        var op_pwd = $("#op_pwd").val();
        var op_name = $("#op_name").val();
        var ext1 = $("#ext1").val();
        var ext2 = $("#ext2").val();
        var opst = <%=opId%>;
        ext1 = encodeURI(encodeURI(ext1));
        ext2 = encodeURI(encodeURI(ext2));
        op_pwd = encodeURI(encodeURI(op_pwd));
        op_name = encodeURI(encodeURI(op_name));
        if ($("#op_id").val() == null || $("#op_id").val() == '' || $("#op_id").val() == undefined) {
            $.messager.alert('错误', "请输入管理员账号");
            return;
        }
        if ($("#op_pwd").val() == null || $("#op_pwd").val() == '' || $("#op_pwd").val() == undefined) {
            $.messager.alert('错误', "请输入管理员密码");
            return;
        }
        if ($("#op_name").val() == null || $("#op_name").val() == '' || $("#op_name").val() == undefined) {
            $.messager.alert('错误', "请输入管理员姓名");
            return;
        }
        console.log(opst)
        if (opst == null || opst == '' || opst == 0 || opst == undefined) {
            $.messager.alert('错误', "请登录操作员账号");
            return;
        }
        //Integer opId, String op_pwd, String op_name,Integer op_type,String ext1,String ext2
        $.post("/book/saveOp?op_id=" + op_id + "&op_pwd=" + op_pwd +"&op_name="+op_name+"&opId=<%=opId%>&ext1=" + ext1 + "&ext2=" + ext2 + "&op_type=" + radio, function (data) {
            if (data.rscode == 0) {
                    $.messager.alert("已成功添加", "成功");
            } else {
                console.log(data.rsdec)
                $.messager.alert("警告", data.rsdec);
            }
        });
    };

    function inClear() {
        $("#op_id").textbox("setValue", "");
        $("#op_pwd").textbox("setValue", "");
        $("#op_name").textbox("setValue", "");
        $($('.ui-select-item')[2]).addClass('checked');
        $("#ext1").textbox("setValue", "");
        $("#ext2").textbox("setValue", "");
    };
</script>