<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<link rel="stylesheet" href="../dist/jui-grid.classic.css" />
		<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/juijs@2.2.1-es6/dist/jui-core.js"></script>
		<script src="../dist/jui-grid.js"></script>
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	 	<style type="text/css">
			li {list-style: none; float: left; padding: 6px;}
		</style>
		<script>
		jui.ready([ "util.base", "grid.xtable" ], function(_, xtableUI) {
				 var body_width = 1000,
			        page = 1;
			        
				 var xtable = xtableUI("#xtable", {
					fields : [ "bno", "title", "writer", "regdate"  ],
			        csvNumber: [ 0, 1, 2, 3, 4, 5, "avgTime" ],
			        resize: true,
			        sort: true,
			        buffer: "s-page",
			        bufferCount: 10
				});
	
				var result = '${boardList}' ;//[];
				console.log(result);
				xtable.update(JSON.parse(result));
			    window.xtable_page = function(no) {
			        page += no;
			        page = (page < 1) ? 1 : page;

			        xtable.page(page);


			        
			    }
			});
		</script>
	</head>
<body class="jui" style="background-color: #fff;">


    
	<div>
		<header>
			<h1> 게시판</h1>
		</header>
		<hr />
		<%-- <div>
			<%@include file="nav.jsp" %>
		</div> --%>

		<!-- <button class="btn small" onclick="xtable_1_submit()">
		<i class="icon-play"></i> 조회
		</button>	 -->
		<div id="xtable" class="xtable scroll">
			<table class="table classic small">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
	<div class="row" align="right" style="text-align: right; margin-top: 3px;">
	    <div class="group">
	        <button onclick="xtable_page(-1);" class="btn mini">Prev</button>
	        <button onclick="xtable_page(1);" class="btn mini">Next</button>
	    </div>
	</div>
<script data-jui="#xtable" data-tpl="row" type="text/template">
    <tr>
        <td><!= bno !></td>
        <td><!= title !></td>
        <td><!= writer !></td>
        <td><!= regdate !></td>
    </tr>
</script>
<script data-jui="#xtable" data-tpl="loading" type="text/template">
    <div class="loading"></div>
</script>

<script data-jui="#xtable" data-tpl="none" type="text/template">
    <tr>
        <td colspan="8" class="none" align="center">Data does not exist.</td>
    </tr>
</script>
		
	</body>
</html>