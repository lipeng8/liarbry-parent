<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String opId = request.getParameter("opId");//用request得到
%>
<table class="easyui-datagrid" id="dsBookList" title="损坏图书列表" style="position: relative"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/book/qryDsBook',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'opId',width:70">操作员编号</th>
        <th data-options="field:'opName',width:70">操作员姓名</th>
        <th data-options="field:'bookId',width:70">图书编号</th>
        <th data-options="field:'bookName',width:200">图书名称</th>
        <th data-options="field:'stId',width:90">学生或老师编号</th>
        <th data-options="field:'stName',width:90,align:'right'">学生姓名</th>
        <th data-options="field:'money',width:150,align:'right'">罚款</th>
        <th data-options="field:'createDate',width:160,align:'center',formatter:LIBRARY.formatDateTime">创建时间</th>

    </tr>
    </thead>
</table>
<div id="bookEditWindow" class="easyui-window" title="借书"
     data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/book-edit'"
     style="width:80%;height:80%;padding:10px;">
</div>
<div style="position: absolute;top: 42px;left:630px;">
    <input id="filterText" class="easyui-textbox" type="text"></input>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="qryById()">根据学生或老师编号搜索</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="qryByName()">根据操作员编号搜索</a>
</div>
<script>
    function qryById() {
        var student_id = $("#filterText").val();
        if (student_id == '' || student_id == null) {
            $.messager.alert('错误', "请输入学生学号");
            return;
        }
        $("#dsBookList").datagrid({
            url: '/book/qryDsBookByStId?st_id=' + student_id
        });
    }

    function qryByName() {
        var op_id = $("#filterText").val();
        if (op_id == '' || op_id == null) {
            $.messager.alert('错误', "请输入操作员编号");
            return;
        }
        $("#dsBookList").datagrid({
            url: '/book/qryDsBookByOp?opId=' + op_id
        });
    }

    /*function getSelectionsIds(){
        var sels = $("#teacherList").datagrid("getChecked");
        var ids = [];
        for(var i=1 in sels){
            ids.push(sels[i].student_name);
        }
        ids = ids.join(",");
        return ids;
    }*/

    var toolbar = [{
        /*text:'新增',*/
        /*iconCls:'icon-add',*/
        /* handler:function(){
             $(".tree-title:contains('新增图书')").parent().click();
         }*/
    }, {
        /* text:'删除',*/
        /* iconCls:'icon-cancel',*/
        /*        handler:function(){
                    var ids = getSelectionsIds();
                    if(ids.length == 0){
                        $.messager.alert('提示','未选中商品!');
                        return ;
                    }
                    $.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
                        if (r){
                            var params = {"ids":ids};
                            $.post("/rest/book/delete",params, function(data){
                                if(data.status == 200){
                                    $.messager.alert('提示','删除商品成功!',undefined,function(){
                                        $("#teacherList").datagrid("reload");
                                    });
                                }
                            });
                        }
                    });
                }*/
    }];
</script>