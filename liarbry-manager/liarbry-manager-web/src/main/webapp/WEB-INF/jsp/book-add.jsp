<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<td >
					<input id="bookType" class="easyui-combobox" type="text" style="width: 280px;"></input>
				</td>
			</tr>
			<tr>
				<td>图书名称:</td>
				<td><input class="easyui-textbox" type="text" name="bookName" data-options="required:true" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>图书作者:</td>
				<td><input class="easyui-textbox" name="bookUser" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
			</tr>
			<tr>
				<td>图书数量:</td>
				<td><input class="easyui-numberbox" type="text" name="bookNumber" data-options="min:1,max:99999999,precision:0,required:true" /></td>
			</tr>
			<tr>
				<td>图书译者:</td>
				<td><input class="easyui-numberbox" type="text" name="bookUser2" data-options="min:1,max:99999999,precision:0,required:true" /></td>
			</tr>
			<tr>
				<td>图书价格:</td>
				<td><input class="easyui-numberbox" type="text" name="bookPrice" data-options="min:1,max:99999999,precision:2,required:true" />
					<input type="hidden" name="price"/>
				</td>
			</tr>
			<tr>
				<td>图书位置:</td>
				<td><input class="easyui-numberbox" type="text" name="bookLocation" data-options="min:1,max:99999999,precision:0,required:true" /></td>
			</tr>
			<tr>
				<td>补充:</td>
				<td><input class="easyui-numberbox" type="text" name="ext1" data-options="min:1,max:99999999,precision:0" /></td>
			</tr>
			<tr>
				<td>补充:</td>
				<td><input class="easyui-numberbox" type="text" name="ext2" data-options="min:1,max:99999999,precision:0" /></td>
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
	var bookAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//bookAddEditor = LIBRARY.createEditor("#bookAddForm [name=desc]");
		bookAddEditor = KindEditor.create("#bookAddForm [name=desc]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		LIBRARY.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			LIBRARY.changeBookParam(node, "bookAddForm");
		}});
        $.post("/book/bookType", function(data){

                $("#bookType").combobox({
					data:data,
                    valueField: 'bookType',
                    textField: 'bookName'
                });
        });
	});
    function submitForm() {
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
