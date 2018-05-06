
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <td><input class="easyui-textbox" type="text" id="" data-options="required:true"
                       style="width: 280px;" /><input id="qryClass" type="button" value="搜索">></td>
        </tr>
    </table>
    <table class="easyui-datagrid" id="classList" title="图书列表" style="position: relative;display: none;">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'bookId',width:70">图书id</th>
            <th data-options="field:'bookName',width:200">图书名称</th>
            <th data-options="field:'bookUser',width:150">图书作者</th>
            <th data-options="field:'bookNumber',width:50">图书数量</th>
            <th data-options="field:'bookType',width:90,align:'right'">图书类别</th>
            <th data-options="field:'bookUser2',width:100,align:'right'">图书译者</th>
            <th data-options="field:'bookPrice',width:60,align:'right'">图书价格</th>
            <th data-options="field:'bookLocation',width:80">图书位置</th>
            <th data-options="field:'createDate',width:160,align:'center',formatter:LIBRARY.formatDateTime">创建时间</th>
            <th data-options="field:'ext1',width:50">EXT1</th>className
            <th data-options="field:'ext2',width:50">EXT2</th>
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
           $.post("/book/in?bookId=" + bookId + "&inStId=" + inStId + "&inOpId=<%=opId%>&ext1=" + ext1 + "&ext2=" + ext2 + "&inStaus=" + radio, function (data) {
               if (data.rscode == 0) {
                   $("#classList").attr("diaplay","block");
                   $("#classList").datagrid({
                       url:'/book/bookId?bookName=null&className='+className
                   });
               } else {
                   $.messager.alert("警告", data.rsdec);
               }
           });
       });
    });
</script>
</body>
</html>
