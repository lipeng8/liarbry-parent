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
            <tr>
                <td>图书编号:</td>
                <td><input class="easyui-textbox" type="text" id="bookId" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>借书卡编号:</td>
                <td><input class="easyui-textbox" type="text" id="inStId" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>描述:</td>
                <td><input class="easyui-textbox" type="text" id="title" data-options="required:true"
                           style="width: 280px;" value="自动读卡功能未完善" readonly="readonly"></input></td>
            </tr>
            <td>图书是否损坏:</td>
            <td>
                <input id='noneFlag' type="radio" name="bookFlag" value="0" checked="checked">无损坏</input>
                <input id='flag1' type="radio" name="bookFlag" value="1">图书轻微折损不影响再次借阅</input>
                <input id='flag2' type="radio" name="bookFlag" value="2">图书损坏严重或丢失</input>
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="backBook()">还书</a>
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
        var bookId = $("#bookId").val();
        var inStId = $("#inStId").val();
        var ext1 = $("#ext1").val();
        var ext2 = $("#ext2").val();
        var opst = <%=opId%>;
        ext1 = encodeURI(encodeURI(ext1));
        ext2 = encodeURI(encodeURI(ext2));
        if ($("#bookId").val() == null || $("#bookId").val() == '' || $("#bookId").val() == undefined) {
            $.messager.alert('错误', "请输入图书编号");
            return;
        }
        if ($("#inStId").val() == null || $("#inStId").val() == '' || $("#inStId").val() == undefined) {
            $.messager.alert('错误', "请输入借书卡编号");
            return;
        }
        console.log(opst)
        if (opst == null || opst == '' || opst == 0 || opst == undefined) {
            $.messager.alert('错误', "请登录操作员账号");
            return;
        }
        $.post("/book/in?bookId=" + bookId + "&inStId=" + inStId + "&inOpId=<%=opId%>&ext1=" + ext1 + "&ext2=" + ext2 + "&inStaus=" + radio, function (data) {
            if (data.rscode == 0) {
                if (data.money == 0.00) {
                    $.messager.alert("已成功还书", "谢谢阅读");
                } else {
                    $.messager.alert("已成功还书", "需要支付:" + data.money);
                }
            } else {
                $.messager.alert("警告", data.rsdec);
            }
        });
    };

    function inClear() {
        $("#bookId").textbox("setValue", "");
        $("#inStId").textbox("setValue", "");
        $($('.ui-select-item')[0]).addClass('checked');
        $("#ext1").textbox("setValue", "");
        $("#ext2").textbox("setValue", "");
    };
</script>