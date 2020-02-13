<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>User Delete</div>
<input type="button" value="select">

<table border="1">
    <tr>
        <th>ID</th>
        <th>PW</th>
        <th>등급</th>
    </tr> 
    <c:forEach var="item" items="${adUserList}" varStatus="status">
 	   <tr>
	        <td><span><c:out value="${item.id}"/></span></td>
	        <td><span><c:out value="${item.pw}"/></span></td>
	        <td><span><c:out value="${item.grad}"/></span></td>
    	</tr>
	</c:forEach>
</table>
<input type="button" value="Delete">
<table border="1">
    <tr>
        <th>ID</th>
        <th>PW</th>
        <th>등급</th>
    </tr> 
 	   <tr>
	        <td><input type="text" name="id" id="id" value=""></td>
	        <td><input type="password" name="pw" id="pw" value=""></td>
	        <td><input type="text" name="grad" id="grad" value=""></td>
    	</tr>
</table>
</body>
</html>