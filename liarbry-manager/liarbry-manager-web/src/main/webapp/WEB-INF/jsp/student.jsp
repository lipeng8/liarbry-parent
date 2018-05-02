<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String opId = request.getParameter("opId");//用request得到
%>
<table class="easyui-datagrid" id="studentList" title="学生列表" style="position: relative"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/book/student?teacher_id=<%=opId%>',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'student_id',width:70">学生学号</th>
        <th data-options="field:'student_name',width:200">学生姓名</th>
        <th data-options="field:'student_class',width:150">学生班级</th>
        <th data-options="field:'studentBooknbs',width:50">学生可借图书数量</th>
        <th data-options="field:'studentBooks',width:90,align:'right'">学生本学期借书数量</th>
        <th data-options="field:'ext1',width:90,align:'right'">补充</th>
        <th data-options="field:'ext2',width:90,align:'right'">注释</th>

    </tr>
    </thead>
</table>
<div id="bookEditWindow" class="easyui-window" title="借书" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/book-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div style="position: absolute;top: 32px;left:730px;">
    <input id="filterText" class="easyui-textbox" type="text" />
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="qryById()">根据Id搜索</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="qryByName()">根据名称搜索</a>
</div>
<script>
    function qryById(){
        var student_id = $("#filterText").val();
        if(student_id == '' || student_id == null){
            $.messager.alert('错误', "请输入学生学号");
            return;
        }
        $("#studentList").datagrid({
            url:'/book/studentId?teacher_id=<%=opId%>&studentId='+student_id
        });
    }
    /*Integer teacher_id, Integer studentId, Integer page, Integer rows*/
    function qryByName(){
        var student_name = $("#filterText").val();
        student_name = encodeURI(encodeURI(student_name));
        console.log(student_name);
        if(student_name == '' || student_name == null){
            $.messager.alert('错误', "请输入学生姓名");
            return;
        }
        $("#studentList").datagrid({
            url:'/book/studentName?studentName='+student_name+'&teacher_id=<%=opId%>'
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
    },{
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