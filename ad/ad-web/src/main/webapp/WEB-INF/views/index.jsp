<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>index</title>

<link rel="stylesheet" href="../css/layout.css" />
</head>
<body>
<div id="wrap">
        <div id="top">
            <jsp:include page="layout/top.jsp" />
        </div>
        <div id="main">
            <jsp:include page="${contentPage}" />
        </div>
        <div id="footer"> <jsp:include page="layout/bottom.jsp" /> </div>
    </div>    
</body>
</html>