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
    <form id="saveStudentForm" class="saveStudentForm" method="post">
        <table cellpadding="5">
            <%-- student_id, student_name,  student_class, teacher_id,  ext1,  ext2--%>
            <tr>
                <td>学生学号:</td>
                <td><input class="easyui-textbox" type="text" id="student_id" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>学生姓名:</td>
                <td><input class="easyui-textbox" type="text" id="student_name" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>学生班级:</td>
                <td><input class="easyui-textbox" type="text" id="student_class" data-options="required:true"
                           style="width: 280px;" ></input></td>
            </tr>
            <tr>
                <td>学生班主任编号:</td>
                <td><input class="easyui-textbox" type="text" id="teacher_id" data-options="required:true"
                           style="width: 280px;" ></input></td>
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
    <%-- student_id, student_name,  student_class, teacher_id,  ext1,  ext2--%>
    function backBook() {
        var student_id = $("#student_id").val();
        var student_name = $("#student_name").val();
        var student_class = $("#student_class").val();
        var teacher_id = $("#teacher_id").val();
        var ext1 = $("#ext1").val();
        var ext2 = $("#ext2").val();
        var opst = <%=opId%>;
        ext1 = encodeURI(encodeURI(ext1));
        ext2 = encodeURI(encodeURI(ext2));
        student_name = encodeURI(encodeURI(student_name));
        if ($("#student_id").val() == null || $("#student_id").val() == '' || $("#student_id").val() == undefined) {
            $.messager.alert('错误', "请输入学生学号");
            return;
        }
        if ($("#student_name").val() == null || $("#student_name").val() == '' || $("#student_name").val() == undefined) {
            $.messager.alert('错误', "请输入学生姓名");
            return;
        }
        if ($("#student_class").val() == null || $("#student_class").val() == '' || $("#student_class").val() == undefined) {
            $.messager.alert('错误', "请输入学生班级");
            return;
        }
        if ($("#teacher_id").val() == null || $("#teacher_id").val() == '' || $("#teacher_id").val() == undefined) {
            $.messager.alert('错误', "请输入学生班主任");
            return;
        }
        console.log(opst)
        if (opst == null || opst == '' || opst == 0 || opst == undefined) {
            $.messager.alert('错误', "请登录操作员账号");
            return;
        }
        $.post("/book/saveStudent?student_id=" + student_id + "&student_name=" + student_name +"&student_class="+student_class+"&opId=<%=opId%>&ext1=" + ext1 + "&ext2=" + ext2 + "&teacher_id="+teacher_id, function (data) {
            if (data.rscode == 0) {
                $.messager.alert("已成功添加", "成功");
            } else {
                console.log(data.rsdec)
                $.messager.alert("警告", data.rsdec);
            }
        });
    };
    <%-- student_id, student_name,  student_class, teacher_id,  ext1,  ext2--%>
    function inClear() {
        $("#student_id").textbox("setValue", "");
        $("#student_name").textbox("setValue", "");
        $("#student_class").textbox("setValue", "");
        $("#teacher_id").textbox("setValue", "");
        $("#ext1").textbox("setValue", "");
        $("#ext2").textbox("setValue", "");
    };
</script>