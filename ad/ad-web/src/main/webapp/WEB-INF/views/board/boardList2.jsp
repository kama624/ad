<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="../dist/jui-grid.classic.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/juijs@2.2.1-es6/dist/jui-core.js"></script>
<script src="../dist/jui-grid.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시판</title>
<style type="text/css">
li {
	list-style: none;
	float: left;
	padding: 6px;
}
</style>
<script>
	var iu = $('#iu');
	jui.ready([ "util.base", "grid.xtable" ], function(_, xtableUI) {
		var body_width = 1000, page = 1;

		var xtable = xtableUI("#xtable", {
			fields : [ "bno", "title", "writer", "regdate" ],
			csvNumber : [ 0, 1, 2, 3, 4, 5, "avgTime" ],
			resize : true,
			sort : true,
			buffer : "page",
			bufferCount : 10,
			event : {
				click : function(row, e) {
					$('#detail input').val('');
					console.log(" 값 확인 bno " + row.data.bno);
					$('#detail input').not('#bno').val('').attr('readonly', false);
					$('#bno').val(row.data.bno);
					$('#title').val(row.data.title);
					$('#writer').val(row.data.writer);
					$('#regdate').val(row.data.regdate);
				}
			}
		});

		var result = '${boardList}';//[];
		console.log(result);
		xtable.update(JSON.parse(result));
		/* 			    window.xtable_page = function(no) {
		 page += no;
		 page = (page < 1) ? 1 : page;

		 xtable.page(page);


		
		 } */
		$(".insert_btn").on("click", function() {
			iu.val('I');
			$('#detail input').val('').attr('readonly', false);
		});

		$(".update_btn").on("click", function() {
			iu.val('U');
			$.ajax({
				url : 'http://localhost/board/boardUpdate2',
				type : 'post',
				data : { iu:iu.val(),
						 bno : $('#bno').val(),
						 title: $('#title').val() ,
						 writer: $('#writer').val(),
						 regdate: $('#regdate').val()
						},
				success : function(data) {
					if(data!=null){
						alert(data.msg);
						 location.reload();
					}
				}

			});

			//	$('#detail input').val('').attr('readonly', false);
		});
	});
</script>
</head>
<body class="jui" style="background-color: #fff;">



	<div id="container">
		<header>
			<h1>게시판</h1>
		</header>
		<hr />
		<%-- <div>
			<%@include file="nav.jsp" %>
		</div> --%>

		<!-- <button class="btn small" onclick="xtable_1_submit()">
		<i class="icon-play"></i> 조회
		</button>	 -->

		<div class="col-xs-4">
			<div id="xtable" class="xtable scroll">
				<table class="table classic small" style="height: 400px">
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
			<div class="col-md-offset-3">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
						<li><a
							href="boardList2${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage}"
						end="${pageMaker.endPage}" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx ? 'class=info' : ''}" />>
							<a href="boardList2${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="boardList2${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-xs-8">
		<div>
			<button type="button" class="insert_btn btn btn-danger">신규</button>
			<button type="button" class="update_btn btn btn-warning">저장</button>
		</div>
		<form id="detail">
			<input type="hidden" id="iu" name="iu"></input>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">번호</label> <input
					type="text" id="bno" name="id" class="form-control" value=""
					readonly="readonly" />
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">제목</label> <input
					id="title" name="title" class="form-control" readonly="readonly"></input>
			</div>
			<div class="form-group">
				<label for="writer" class="col-sm-2 control-label">작성자</label> <input
					type="text" id="writer" name="writer" class="form-control" value=""
					readonly="readonly" />
			</div>
			<%-- 			<div class="form-group">
				<label for="regdate" class="col-sm-2 control-label">등록일</label> <input
					type="text" id="regdate" name="regdate" class="form-control"
					value="" readonly="readonly" />
				<fmt:formatDate value="${read.day}" pattern="yyyy-MM-dd" />	
			</div> --%>


		</form>
	</div>
	<!-- 	<div class="row" align="right" style="text-align: right; margin-top: 3px;">
	    <div class="group">
	        <button onclick="xtable_page(-1);" class="btn mini">Prev</button>
	        <button onclick="xtable_page(1);" class="btn mini">Next</button>
	    </div>
	</div> -->
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