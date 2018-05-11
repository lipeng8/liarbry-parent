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
<div style="position: absolute;top: 32px;left:730px;">
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

    }, {

    }];
</script>