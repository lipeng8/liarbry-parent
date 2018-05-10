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
    <form id="inBookForm" class="inBookForm" method="post">
        <table cellpadding="5">
            <td>图书是否损坏:</td>
            <td>
                <input id='noneFlag' type="radio" name="bookFlag" value="0" checked="checked">操作员</input>
                <input id='flag1' type="radio" name="bookFlag" value="1">学生</input>
                <input id='flag2' type="radio" name="bookFlag" value="2">老师</input>
            </td>
            <tr>
                <td>人员编号:</td>
                <td><input class="easyui-textbox" type="text" id="Id" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>

        </table>
        <input type="hidden" name="bookParams"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="backBook()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="inClear()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var radio = 0;
    $(function () {
        $(":radio").click(function () {
            radio = $(this).val();
        });
    });

    function backBook() {
        var Id = $("#Id").val();
        var opst = <%=opId%>;
        if ($("#Id").val() == null || $("#Id").val() == '' || $("#Id").val() == undefined) {
            $.messager.alert('错误', "请输入人员编号");
            return;
        }
        console.log(opst)
        if (opst == null || opst == '' || opst == 0 || opst == undefined) {
            $.messager.alert('错误', "请登录操作员账号");
            return;
        }
        $.post("/book/deleteSTO?id=" + Id + "&opId=<%=opId%>&type=" + radio, function (data) {
            if (data.rscode == 0) {
                    $.messager.alert("成功", "删除");
            } else {
                $.messager.alert("警告", data.rsdec);
            }
        });
    };

    function inClear() {
        $("#Id").textbox("setValue", "");
        $($('.ui-select-item')[0]).addClass('checked');
    };
</script>