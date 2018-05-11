<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="-Type" content="text/html; charset=UTF-8">
    <title>图书管理系统</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="css/library.css" />
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String name = request.getParameter("opId");//用request得到
        String opName1 = request.getParameter("opName");
        String opName = new String(opName1.getBytes("ISO-8859-1"),"utf-8");
    %>
</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'菜单',split:true" style="width:180px;background-image: url(../img/2.jpg);background-size: cover">
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
        <li>
            <span>学生管理</span>
            <ul>
                <li data-options="attributes:{'url':'book-list'}">查询图书</li>
                <li data-options="attributes:{'url':'student?opId=<%=name%>'}">学生</li>
                <li data-options="attributes:{'url':'saveteaclass?opId=<%=name%>'}">新增本班级任课教师</li>
                <li data-options="attributes:{'url':'teacher-list?opId=<%=name%>'}">本班级学生借书情况</li>
                <li data-options="attributes:{'url':'teaclass?opId=<%=name%>'}">任课班级学生借书情况</li>
            </ul>
        </li>
    </ul>
</div>
<div data-options="region:'center'" style ="position: relative">
    <div id="tabs" class="easyui-tabs tabsClass" style="margin-right: 0px">
        <div title="首页" style="padding:20px;">

        </div>
    </div>
    <div style="width: 150px;height: 40px;position: absolute;top: 2px;right: -2px;">
        <%if(name != null){%>
        <span>欢迎你：</span><span id="opId"><%=opName%></span><span>老师</span>
        <a id="cancel" style="text-decoration: underline;margin-left: 5px;cursor: pointer;">注销</a>
        <%}else{%>
        <span>无用户：</span>
        <a id="login" class="easyui-linkbutton" iconCls="icon-ok" >登录</a>
        <%}%>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        $('#menu').tree({
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    var tabs = $("#tabs");
                    var tab = tabs.tabs("getTab",node.text);
                    if(tab){
                        tabs.tabs("select",node.text);
                    }else{
                        tabs.tabs('add',{
                            title:node.text,
                            href: node.attributes.url,
                            closable:true,
                            bodyCls:"content"
                        });
                    }
                }
            }
        });
        $("#login").on('click',function(){
            window.location.href = "/login.jsp";
        });
        $("#cancel").on('click',function(){
            window.location.href = "/index";
        });
    });

</script>
</body>
</html>