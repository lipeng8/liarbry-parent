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
            <tr>
                <td>新增老师账号:</td>
                <td><input class="easyui-textbox" type="text" id="teaClass_id" data-options="required:true"
                           style="width: 280px;"></input></td>
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
        var teaClass_id = $("#teaClass_id").val();
        var opst = <%=opId%>;
        if ($("#teaClass_id").val() == null || $("#teaClass_id").val() == '' || $("#teaClass_id").val() == undefined) {
            $.messager.alert('错误', "请输入任课教师账号");
            return;
        }
        console.log(opst)
        if (opst == null || opst == '' || opst == 0 || opst == undefined) {
            $.messager.alert('错误', "请登录教师账号");
            return;
        }
        $.post("/book/saveTeaClass?teacher_id=<%=opId%>&teaClass_id=" + teaClass_id , function (data) {
            if (data.rscode == 0) {
                $.messager.alert("已成功添加", "成功");
            } else {
                console.log(data.rsdec)
                $.messager.alert("警告", data.rsdec);
            }
        });
    };
    function inClear() {
        $("#teaclass_id").textbox("setValue", "");
    };
</script>