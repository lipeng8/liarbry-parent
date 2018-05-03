<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String opId = request.getParameter("opId");//用request得到
%>
<table class="easyui-datagrid" id="bookList" title="图书列表" style="position: relative"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/book/list',method:'get',pageSize:30,toolbar:toolbar">
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
            <th data-options="field:'ext1',width:50">EXT1</th>
            <th data-options="field:'ext2',width:50">EXT2</th>
        </tr>
    </thead>
</table>
<div id="bookEditWindow" class="easyui-window" title="借书" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/book-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div style="position: absolute;top: 41px;left:730px;">
    <input id="filterText" class="easyui-textbox" type="text" ></input>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="qryById()">根据Id搜索</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="qryByName()">根据名称搜索</a>
</div>
<script>

    function qryById(){
        var bookId = $("#filterText").val();
        if(bookId == '' || bookId == null){
            $.messager.alert('错误', "请输入图书编号");
            return;
        }
        $("#bookList").datagrid({
            url:'/book/bookId?bookName=null&bookId='+bookId
        });
    }
    function qryByName(){
        var bookName= $("#filterText").val();
        bookName = encodeURI(encodeURI(bookName));
        if(bookName == '' || bookName == null){
            $.messager.alert('错误', "请输入图书名称");
            return;
        }
        $("#bookList").datagrid({
            url:'/book/bookName?bookId=0&bookName='+bookName
        });
    }

    function getSelectionsIds(){
    	var sels = $("#bookList").datagrid("getChecked");
    	var ids = [];
        for(var i=1 in sels){
            ids.push(sels[i].bookId);
        }
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增图书')").parent().click();
        }
    }/*,{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	
        	$("#bookEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#bookList").datagrid("getSelections")[0];
        			data.priceView = LIBRARY.formatPrice(data.price);
        			$("#bookeEditForm").form("load",data);
        			
        			// 加载商品描述
        			$.getJSON('/rest/book/query/book/desc/'+data.id,function(_data){
        				if(_data.status == 200){
        					//UM.getEditor('bookeEditDescEditor').setContent(_data.data.bookDesc, false);
        					bookEditEditor.html(_data.data.bookDesc);
        				}
        			});
        			
        			//加载商品规格
        			$.getJSON('/rest/book/param/book/query/'+data.id,function(_data){
        				if(_data && _data.status == 200 && _data.data && _data.data.paramData){
        					$("#bookeEditForm .params").show();
        					$("#bookeEditForm [name=bookParams]").val(_data.data.paramData);
        					$("#bookeEditForm [name=bookParamId]").val(_data.data.id);
        					
        					//回显商品规格
        					 var paramData = JSON.parse(_data.data.paramData);
        					
        					 var html = "<ul>";
        					 for(var i in paramData){
        						 var pd = paramData[i];
        						 html+="<li><table>";
        						 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
        						 
        						 for(var j in pd.params){
        							 var ps = pd.params[j];
        							 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
        						 }
        						 
        						 html+="</li></table>";
        					 }
        					 html+= "</ul>";
        					 $("#bookeEditForm .params td").eq(1).html(html);
        				}
        			});
        			
        			LIBRARY.init({
        				"pics" : data.image,
        				"cid" : data.cid,
        				fun:function(node){
        					LIBRARY.changeBookParam(node, "bookeEditForm");
        				}
        			});
        		}
        	}).window("open");
        }
    },*/,{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','请选择一条处理!');
                return ;
            }
        	/*if(ids.length != 1 ){
        		$.messager.alert('提示','只能选中一条处理!');
        		return ;
        	}*/
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的图书吗？',function(r){
        	    if (r){
                    var sels = $("#bookList").datagrid("getChecked");
                    for(var i=1 in sels){
                        $.post("/book/delete?op_id=<%=opId%>&bookId="+sels[i].bookId, function(data){
                            if(data.status == 200){
                                $.messager.alert('提示','删除商品成功!',undefined,function(){
                                    $("#bookList").datagrid("reload");
                                });
                            }
                        });
                    }

        	    }
        	});
        }
    }/*,'-',{
        text:'借书',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/book/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','下架商品成功!',undefined,function(){
            					$("#bookList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'还书',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/book/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#bookList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }*/];
</script>