<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="net.harrysburrow.DAO.*" %>
<%@ page language="java" import="net.harrysburrow.Security.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Burrow of Harry Lv</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache"> 
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="stylesheets/index/index.css"/>
	<script type="text/javascript" src="scripts/jquery.js"></script>
	<script type="text/javascript" src="scripts/index/index.js"></script>
	
  </head>
  
  <body>
  
  	<%
  		//deal with the request check if it is valid and store it into database logs
		//first log this request
		BurrowDAO burrowDAO = new BurrowDAO();
		burrowDAO.log(request);
		//second check if it's valid or contains illegal arguments
		if(!AntiBadRequest.isLegalRequest(request)){
			//do something to prevent the invader from going on.
			%>
			<script type="text/javascript">
				window.location = 'http://harrysburrow.net';
			</script>
			<%
		}
		else
			burrowDAO.addView();
  	 %>
  	
  	<div id="title">
  		<br><img src="img/index/logo.png">
  	</div>

  	<div id="main">
  	
  		<img src="img/index/construction.jpg" id="construction_pic"/>
  			<font id="construction_text" class="text">This page is under construction.</font><br>
  			
    	<img src="img/index/miui.jpg" id="miui_pic"/>
    		<a href="MIUI/miui.html"><font id="miui_text" class="text">Have a look at my MIUI in pure CSS.</font></a><br>
    		
  	</div>
  	
  	<div id="footer" style="margin-top:150px">
  		<font style="font-family:'Arial';font-size:0.5em">©2012 <b>HarryLv</b> | Contact me at <b>1992donkey@gmail.com</b></font>
  	</div>
  	
  	<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
		document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F53fd752a54d5fc835778b3f5262689a7' type='text/javascript'%3E%3C/script%3E"));
	</script>
  </body>
</html>
