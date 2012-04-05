<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="stylesheets/index/index.css"/>
  </head>
  
  <body>
  	<div id="title">
  		<img src="img/index/logo.png">
  	</div>
  	<div id="main">
  	
  		<img src="img/index/construction.jpg" id="construction_pic"/>
  			<font id="construction_text" class="text">This page is under construction.</font><br>
  			
    	<img src="img/index/miui.jpg" id="miui_pic"/>
    		<a href="MIUI/miui.html"><font id="miui_text" class="text">Have a look at my MIUI in pure CSS.</font></a><br>
    		
  	</div>
  </body>
</html>
