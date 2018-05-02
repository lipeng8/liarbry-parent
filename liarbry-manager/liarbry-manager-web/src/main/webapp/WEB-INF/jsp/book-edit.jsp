<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="bookeEditForm" class="bookForm" method="post">
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
	        <tr>
	            <td>图书类别:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectBookCat">选择科目</a>
	            	<input type="hidden" name="bookId" style="width: 280px;"></input>
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
	            <td>图书类别:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="bookType" data-options="validType:'length[1,30]'" />
	            </td>
	        </tr>
	        <tr>
	            <td>图书译者:</td>
				<td><input class="easyui-numberbox" type="text" name="bookUser2" data-options="min:1,max:99999999,precision:0,required:true" /></td>
			<%--<td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                <input type="hidden" name="image"/>
	            </td>--%>
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
				<td><input class="easyui-numberbox" type="text" name="ext1" data-options="min:1,max:99999999,precision:0,required:true" /></td>
			</tr>
			<tr>
				<td>补充:</td>
				<td><input class="easyui-numberbox" type="text" name="ext2" data-options="min:1,max:99999999,precision:0,required:true" /></td>
			</tr>
	        <%--<tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
	            </td>
	        </tr>
	        <tr class="params hide">
	        	<td>商品规格:</td>
	        	<td>
	        		
	        	</td>
	        </tr>--%>
	    </table>
	    <input type="hidden" name="bookParams"/>
	    <input type="hidden" name="bookParamId"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var bookEditEditor ;
	$(function(){
		//实例化编辑器
		bookEditEditor = LIBRARY.createEditor("#bookeEditForm [name=desc]");
	});
	
	function submitForm(){
		if(!$('#bookeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$("#bookeEditForm [name=price]").val(eval($("#bookeEditForm [name=bookPrice]").val()) * 1000);
		bookEditEditor.sync();
		
		var paramJson = [];
		$("#bookeEditForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		paramJson = JSON.stringify(paramJson);
		
		$("#bookeEditForm [name=bookParams]").val(paramJson);
		
		$.post("/rest/book/update",$("#bookeEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改商品成功!','info',function(){
					$("#bookEditWindow").window('close');
					$("#bookList").datagrid("reload");
				});
			}
		});
	}
</script>
