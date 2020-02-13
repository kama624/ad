<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 부트스트랩 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	 	<style type="text/css">
			li {list-style: none; float: left; padding: 6px;}
		</style>
	</head>
	<script type="text/javascript">
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "batchList" + '${pageMaker.makeQuery(1)}');
        });
      });   
    </script>
	<body>
		<div id="root"  class="container">
			<header>
				<h1>BATCH 리스트</h1>
			</header>
			<hr />
			 
<%-- 			<div>
				<%@include file="nav.jsp" %>
			</div> --%>
			<hr />

			<section id="container">
				<form role="form" method="post" action="/batch/batchRun">
					<table class="table table-hover">
						<tr><th>jobInstanceId</th><th>version</th><th>jobName</th><th>jobKey</th></tr>
						
						<c:forEach items="${batchList}" var = "list">
							<tr>
								<td><c:out value="${list.jobInstanceId}" /></td>
								<td><c:out value="${list.version}" /></td>
								<td><c:out value="${list.jobName}" /></td>
								<td><c:out value="${list.jobKey}" /></td>
							</tr>
						</c:forEach>
						
					</table>
					<div class="search row">
						<div class="col-xs-10 col-sm-10">
							<div class="input-group">
								<span class="input-group-btn">
									<button id="searchBtn" type="button" class="btn btn-default">검색</button> 	
								</span>
							</div>
						</div>						
					</div>
 
					<div class="col-md-offset-3">
						<ul class="pagination">
					    <c:if test="${pageMaker.prev}">
					    	<li><a href="boardList${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
					    </c:if> 
						
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
							<li <c:out value="${pageMaker.cri.page == idx ? 'class=info' : ''}" />>
							<a href="boardList${pageMaker.makeSearch(idx)}">${idx}</a></li>
						</c:forEach>
					
					    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					    	<li><a href="boardList${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
					    </c:if> 
					  </ul>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>