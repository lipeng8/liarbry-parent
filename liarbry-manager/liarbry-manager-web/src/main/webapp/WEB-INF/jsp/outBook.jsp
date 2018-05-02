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
    <form id="outBookForm" class="outBookForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>图书编号:</td>
                <td><input class="easyui-textbox" type="text" id="Id" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>借书卡编号:</td>
                <td><input class="easyui-textbox" type="text" id="SId" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>描述:</td>
                <td><input class="easyui-textbox" type="text" id="title" data-options="required:true"
                           style="width: 280px;" value="自动读卡功能未完善" readonly="readonly"></input></td>
            </tr>
            <tr>
                <td>补充1:</td>
                <td><input class="easyui-textbox" type="text" id="ext11"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;"></input></td>
            </tr>
            <tr>
                <td>补充2:</td>
                <td><input class="easyui-textbox" type="text" id="ext12"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;"></input></td>
            </tr>
        </table>
        <input type="hidden" name="bookParams"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="outForm()">借书</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="outClear()">重置</a>
    </div>
</div>
<script type="text/javascript">
    function outForm() {
        var bookId = $("#Id").val();
        var outStId = $("#SId").val();
        var ext1 = $("#ext11").val();
        var ext2 = $("#ext12").val();
        ext1 = encodeURI(encodeURI(ext1));
        ext2 = encodeURI(encodeURI(ext2));
        var opst = <%=opId%>;
        if ($("#Id").val() == null || $("#Id").val() == '' || $("#Id").val() == undefined) {
            $.messager.alert('错误', "请输入图书编号");
            return;
        }
        if ($("#SId").val() == null || $("#SId").val() == '' || $("#SId").val() == undefined) {
            $.messager.alert('错误', "请输入借书卡编号");
            return;
        }
        console.log(opst)
        if (opst == null || opst == '' || opst == 0 || opst == undefined) {
            $.messager.alert('错误', "请登录操作员账号");
            return;
        }
        $.post("/book/out?bookId=" + bookId + "&outStId=" + outStId + "&outOpId=<%=opId%>&ext1=" + ext1 + "&ext2=" + ext2, function (data) {
            if (data.rscode == 0) {
                $.messager.alert(data.rsdec, "已成功借书");
            } else {
                $.messager.alert("警告", data.rsdec);
            }
        });
    };

    function outClear() {
        $("#Id").textbox("setValue", "");
        $("#SId").textbox("setValue", "");
        $("#ext11").textbox("setValue", "");
        $("#ext12").textbox("setValue", "");
    };
</script>