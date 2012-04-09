<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="net.harrysburrow.DAO.*" %>
<%@ page language="java" import="net.harrysburrow.Security.*" %>
<%@ page language="java" import="net.harrysburrow.Bean.*" %>
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
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
    <script type="text/javascript" src="scripts/utils.js"></script>
	<script type="text/javascript" src="scripts/index/index.js"></script>
	
  </head>
  
  <body> 
   
  	<%  
  		//deal with the request check if it is valid and store it into database logs  
		//first log this request  
		//BurrowDAO burrowDAO = new BurrowDAO();  
		//burrowDAO.log(request);  
		//second check if it's valid or contains illegal arguments  
		if(!AntiBadRequest.isLegalRequest(request)){  
			//do something to prevent the invader from going on.  
			%>
			<script type="text/javascript">
				window.location = 'http://harrysburrow.net';
			</script>
			<%
		}
		else{
			//burrowDAO.addView();
			//ArrayList<Blog> blogs = burrowDAO.getBlogs();
		}
  	 %>
  	 <div id="header">
  	 	<iframe scrolling="no" frameborder="0" allowtransparency="true" src="http://www.connect.renren.com/like?url=http%3A%2F%2Fharrysburrow.net&showfaces=false" style="width: 120px;height: 40px;"></iframe>
  	 </div>
  	 
  	 <div class="ui-widget" id="alert_bar">

			<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;"> 

				<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span> 

				<strong>Alert:</strong> Your browser does not support all features of this page, please use chrome safari or firefox.</p>

			</div>

	</div>
  	 
  	
  	<div id="title">
  		<br><img src="img/index/logo.png">
  	</div>

  	<div id="main">
  	
  		<div id="intro">
  			<div id="what" class="window">
  				<div class="window_cover">
  					<img src="img/index/burrow.jpg" width="250" height="300" />
  				</div>
  				
  				<div class="window_title">
  					<font>What's This ?</font>
  				</div>
  			</div>
  		
  			<div id="who" class="window">
  				<div class="window_cover">
  				</div>
  				
  				<div class="window_title">
  					<font>Who Created This?</font>
  				</div>
  			</div>
  		</div>
  		
  		<div id="content">
  			<%
  			
  			 %>
  		</div>
  	</div>
  	
  	<div id="mask">
  		
  	</div>
  	<div id="dialog">
  	
  	</div>
  	<div id="temp"></div>
  	
  	<div id="footer" style="margin-top:150px">
  		<font style="font-family:'Arial';font-size:0.5em">©2012 <b>HarryLv</b> | Contact me at <b>1992donkey@gmail.com</b></font>
  	</div>
  	
  	<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
		document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F53fd752a54d5fc835778b3f5262689a7' type='text/javascript'%3E%3C/script%3E"));
	</script>
	
  </body>
</html>
