<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String opId = request.getParameter("opId");//用request得到
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="padding:10px 10px 10px 10px">
    <table cellpadding="5">
        <tr>
            <td>班级名称:</td>
            <td><input class="easyui-textbox" type="text" id="className" data-options="required:true"
                       style="width: 280px;" /><input id="qryClass" type="button" iconCls="icon-ok" value="搜索" style=" margin-left: 20px"></td>
        </tr>
    </table>
    <table class="easyui-datagrid" id="classList" title="图书列表" style="position: relative;display: none;">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'student_name',width:70">学生姓名</th>
            <th data-options="field:'book_name',width:200">图书名称</th>
            <th data-options="field:'out_date',width:150">借书日期</th>
            <th data-options="field:'outStaus',width:50">状态</th>
            <th data-options="field:'type_name',width:90,align:'right'">图书类别</th>
            <th data-options="field:'ext1',width:90,align:'right'">补充</th>
            <th data-options="field:'ext2',width:90,align:'right'">注释</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    $(function () {
       $("#qryClass").off().on("click",function() {
           var className = $("#className").val();
           if(className == '' || className == null){
               $.messager.alert('错误', "请输入班级编号");
               return;
           }

           $("#classList").attr("diaplay","block");
           $("#classList").datagrid({
               url:'/book/qrtTeaClass?teacher_id=<%=opId%>&page=1&rows=30&class_id='+className
           });
       });
    });
</script>
</body>
</html>
