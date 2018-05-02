<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="bookAddForm" class="bookForm" method="post">
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
				<td><input class="easyui-numberbox" type="text" name="ext1" data-options="min:1,max:99999999,precision:0" /></td>
			</tr>
			<tr>
				<td>补充:</td>
				<td><input class="easyui-numberbox" type="text" name="ext2" data-options="min:1,max:99999999,precision:0" /></td>
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
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#bookAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//取商品价格，单位为“分”
		$("#bookAddForm [name=price]").val(eval($("#bookAddForm [name=priceView]").val()) * 100);
		//同步文本框中的商品描述
		bookAddEditor.sync();
		//取商品的规格
		var paramJson = [];
		$("#bookAddForm .params li").each(function(i,e){
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
		//把json对象转换成字符串
		paramJson = JSON.stringify(paramJson);
		$("#bookAddForm [name=bookParams]").val(paramJson);
		
		//ajax的post方式提交表单
		//$("#bookAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("/book/save",$("#bookAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增商品成功!');
			}
		});
	}
	
	function clearForm(){
		$('#bookAddForm').form('reset');
		bookAddEditor.html('');
	}
</script>
