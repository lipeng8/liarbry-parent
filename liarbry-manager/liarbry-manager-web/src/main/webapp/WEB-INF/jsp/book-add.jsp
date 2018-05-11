<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String opId = request.getParameter("opId");//用request得到
%>
<div style="padding:10px 10px 10px 10px">
    <form id="bookAddForm" class="bookForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>图书类别:</td>
                <td>
                    <input id="bookType" class="easyui-combobox" type="text" style="width: 280px;"></input>
                </td>
            </tr>
            <tr>
                <td>图书名称:</td>
                <td><input class="easyui-textbox" type="text" id="bookName" data-options="required:true"
                           style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>图书作者:</td>
                <td><input class="easyui-textbox" id="bookUser"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;" value="输入格式：user1,user2"></input></td>
            </tr>
            <tr>
                <td>图书数量:</td>
                <td><input class="easyui-numberbox" type="text" id="bookNumber"
                           data-options="min:1,max:99999999,precision:0,required:true"/></td>
            </tr>
            <tr>
                <td>图书译者:</td>
                <td><input class="easyui-textbox" id="bookUser2"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;" ></input></td>
            </tr>
            <tr>
                <td>图书价格:</td>
                <td><input class="easyui-numberbox" type="text" id="bookPrice"
                           data-options="min:1,max:99999999,precision:2,required:true"/>
                </td>
            </tr>
            <tr>
                <td>图书位置:</td>
                <td><input class="easyui-textbox" id="bookLocation"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;" value="输入格式：第x排第y列"></input></td>
            </tr>
            <tr>
                <td>补充:</td>
                <td><input class="easyui-textbox" id="ext1"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;"></input></td>
            </tr>
            <tr>
                <td>补充:</td>
                <td><input class="easyui-textbox" id="ext2"
                           data-options="multiline:true,validType:'length[0,150]'"
                           style="height:60px;width: 280px;"></input></td>
            </tr>
        </table>
        <input type="hidden" name="bookParams"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var bookAddEditor;
    //页面初始化完毕后执行此方法
    $(function () {
        //创建富文本编辑器
        //bookAddEditor = LIBRARY.createEditor("#bookAddForm [name=desc]");
        bookAddEditor = KindEditor.create("#bookAddForm [name=desc]", TT.kingEditorParams);
        //初始化类目选择和图片上传器
        LIBRARY.init({
            fun: function (node) {
                //根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
                LIBRARY.changeBookParam(node, "bookAddForm");
            }
        });
        $.post("/book/bookType", function (data) {

            $("#bookType").combobox({
                data: data,
                valueField: 'bookType',
                textField: 'bookName'
            });
        });
    });

    function submitForm() {
        var book_name = $("#bookName").val();
        var book_loca = $("#bookLocation").val();
        var user = $("#bookUser").val();
        var user2 = $("#bookUser2").val();
        var book_price = $("#bookPrice").val();
        var book_number = $("#bookNumber").val();
        var ext1 = $("#ext1").val();
        var ext2 = $("#ext2").val();
        var bookType = $("#bookType").combobox("getValue");
        ext1 = encodeURI(encodeURI(ext1));
        ext2 = encodeURI(encodeURI(ext2));
        book_name = encodeURI(encodeURI(book_name));
        book_loca = encodeURI(encodeURI(book_loca));
        user = encodeURI(encodeURI(user));
        user2 = encodeURI(encodeURI(user2));
        var opst = <%=opId%>;
        if ($("#bookType").combobox("getValue") == null || $("#bookType").combobox("getValue") == '' || $("#bookType").combobox("getValue") == undefined) {
            $.messager.alert('错误', "请选择图书科目");
            return;
        }
        if ($("#bookName").val() == null || $("#bookName").val() == '' || $("#bookName").val() == undefined) {
            $.messager.alert('错误', "请输入图书名称");
            return;
        }
        if ($("#bookUser").val() =="输入格式：user1,user2" ||$("#bookUser").val() == null || $("#bookUser").val() == '' || $("#bookUser").val() == undefined) {
            $.messager.alert('错误', "请输入图书作者");
            return;
        }
        if ($("#bookNumber").val() == null || $("#bookNumber").val() == '' || $("#bookNumber").val() == undefined) {
            $.messager.alert('错误', "请输入初始数量");
            return;
        }
        if ($("#bookPrice").val() == null || $("#bookPrice").val() == '' || $("#bookPrice").val() == undefined) {
            $.messager.alert('错误', "请输入图书价格");
            return;
        }
        if ($("#bookLocation").val()=="输入格式：第x排第y列"||$("#bookLocation").val() == null || $("#bookLocation").val() == '' || $("#bookLocation").val() == undefined) {
            $.messager.alert('错误', "请输入图书位置");
            return;
        }
        console.log(opst)
        console.log(bookType)
        if (opst == null || opst == '' || opst == 0 || opst == undefined) {
            $.messager.alert('错误', "请登录操作员账号");
            return;
        }
//        ( user, user2, book_loca, book_name, booktype, book_price, book_number,op_id, ext1, ext2
        $.post("/book/insert?op_id=<%=opId%>&user=" + user + "&user2=" + user2 + "&ext1=" + ext1 + "&ext2=" + ext2 + "&book_loca=" + book_loca + "&book_name=" + book_name + "&book_number=" + book_number + "&book_price=" + book_price + "&booktype=" + bookType, function (data) {
            if (data.rscode == 0) {
                $.messager.alert("成功",data.rsdec);
            } else {
                $.messager.alert("警告", data.rsdec);
            }
        });
    };

    function clearForm() {
        $("#bookName").textbox("setValue", "");
        $("#bookLocation").textbox("setValue", "");
        $("#bookUser").textbox("setValue", "");
        $("#bookUser2").textbox("setValue", "");
        $("#bookPrice").textbox("setValue", "");
        $("#bookNumber").textbox("setValue", "");
        $("#ext11").textbox("setValue", "");
        $("#ext12").textbox("setValue", "");
    };
</script>
