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
    <form id="saveTeacherForm" class="saveTeacherForm" method="post">
        <table cellpadding="5">
            <tr>
                <%-- teacher_id,teacher_pwd, teacher_name,  teacher_class,ext1,  ext2--%>
                <td>老师账号:</td>
                <td><input class="easyui-textbox" type="text" id="teacher_id" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>账号密码:</td>
                <td><input class="easyui-textbox" type="text" id="teacher_pwd" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>老师姓名:</td>
                <td><input class="easyui-textbox" type="text" id="teacher_name" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>老师班级:</td>
                <td><input class="easyui-textbox" type="text" id="teacher_class" data-options="required:true"
                           style="width: 280px;"></input></td>
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
    <%-- teacher_id,teacher_pwd, teacher_name,  teacher_class,ext1,  ext2--%>

    function backBook() {
        var teacher_id = $("#teacher_id").val();
        var teacher_pwd = $("#teacher_pwd").val();
        var teacher_name = $("#teacher_name").val();
        var teacher_class = $("#teacher_class").val();
        var ext1 = $("#ext1").val();
        var ext2 = $("#ext2").val();
        var opst = <%=opId%>;
        ext1 = encodeURI(encodeURI(ext1));
        ext2 = encodeURI(encodeURI(ext2));
        teacher_pwd = encodeURI(encodeURI(teacher_pwd));
        teacher_name = encodeURI(encodeURI(teacher_name));
        if ($("#teacher_id").val() == null || $("#teacher_id").val() == '' || $("#teacher_id").val() == undefined) {
            $.messager.alert('错误', "请输入老师账号");
            return;
        }
        if ($("#teacher_pwd").val() == null || $("#teacher_pwd").val() == '' || $("#teacher_pwd").val() == undefined) {
            $.messager.alert('错误', "请输入老师密码");
            return;
        }
        if ($("#teacher_name").val() == null || $("#teacher_name").val() == '' || $("#teacher_name").val() == undefined) {
            $.messager.alert('错误', "请输入老师姓名");
            return;
        }
        if ($("#teacher_class").val() == null || $("#teacher_class").val() == '' || $("#teacher_class").val() == undefined) {
            $.messager.alert('错误', "请输入老师班级");
            return;
        }
        console.log(opst)
        if (opst == null || opst == '' || opst == 0 || opst == undefined) {
            $.messager.alert('错误', "请登录操作员账号");
            return;
        }
        $.post("/book/saveTeacher?teacher_id=" + teacher_id + "&teacher_pwd=" + teacher_pwd + "&teacher_name=" + teacher_name + "&opId=<%=opId%>&ext1=" + ext1 + "&ext2=" + ext2 + "&teacher_class=" + teacher_class, function (data) {
            if (data.rscode == 0) {
                $.messager.alert("已成功添加", "成功");
            } else {
                console.log(data.rsdec)
                $.messager.alert("警告", data.rsdec);
            }
        });
    };

    function inClear() {
        $("#teacher_id").textbox("setValue", "");
        $("#teacher_pwd").textbox("setValue", "");
        $("#teacher_name").textbox("setValue", "");
        $("#teacher_class").textbox("setValue", "");
        $("#ext1").textbox("setValue", "");
        $("#ext2").textbox("setValue", "");
    };
</script>