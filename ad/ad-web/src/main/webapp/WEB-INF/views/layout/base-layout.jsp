<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <title>base-layout</title>
    <!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="../css/layout.css">
  </head>
   <body>
   <div id="container">
		<div class="row">
		    <div id="header" ><tiles:insertAttribute name="top" /></div>
		</div>
		<div class="row">
	    	<div id="left"  class="col-xs-4" ><tiles:insertAttribute name="left" /></div>
	    	<div id="main" class="col-xs-8"><tiles:insertAttribute name="body" /></div>    
		</div>
		<div class="row">
		    <div id="footer"><tiles:insertAttribute name="bottom" /></div>
	   </div>
   </div>
  </body>
</html>