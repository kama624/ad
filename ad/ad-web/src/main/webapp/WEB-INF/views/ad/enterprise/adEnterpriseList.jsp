<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="shortcut icon" href="../res/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="../res/img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="../lib/codemirror-4.5/lib/codemirror.css">
<link rel="stylesheet" href="../lib/codemirror-4.5/theme/neo.css">
<script src="../lib/codemirror-4.5/lib/codemirror.js"></script>
<script src="../lib/codemirror-4.5/mode/javascript/javascript.js"></script>
<script src="../lib/codemirror-4.5/mode/xml/xml.js"></script>
<link rel="stylesheet" href="../lib/jui/css/jui.min.css" />
<link rel="stylesheet" href="../lib/jui/css/ui.min.css" />
<link rel="stylesheet" href="../lib/jui/css/ui-jennifer.min.css" />
<link rel="stylesheet" href="../lib/jui/css/grid.min.css" />
<link rel="stylesheet" href="../lib/jui/css/grid-jennifer.min.css" />
<link rel="stylesheet" href="../lib/jui/css/jui-grid.classic.css" />
<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/jui/js/core.min.js" ></script>
<script type="text/javascript" src="../lib/jui/js/ui.min.js" ></script>
<script type="text/javascript" src="../lib/jui/js/grid.min.js" ></script>
<script type="text/javascript" src="../lib/jui/js/chart.min.js" ></script>
<script type="text/javascript" src="../res/event.js" ></script>
<title>게시판</title>
<style type="text/css">
li {
	list-style: none;
	float: left;
	padding: 6px;
}
</style>
<script>
	jui.ready([ "util.base", "grid.xtable" ], function(_, xtableUI) {
		var body_width = 1000, page = 1;

		var xtable = xtableUI("#xtable", {
			fields : [ "advrtsEntrpsId", "advrtsEntrpsNm", "rprsntvNm", "useYn" ],
			csvNumber : [ 0, 1, 2, 3, 4, 5, "avgTime" ],
			resize : true,
			sort : true,
			buffer : "page",
			bufferCount : 10,
			event : {
				click : function(row, e) {
					$('#iu').val('U');
					console.log(" 값 확인 bno " + row.data.advrtsEntrpsId);
					$('#detail input').val('');
					$('#detail input').not('#advrtsEntrpsId').val('').attr('readonly', false);
					$('#advrtsEntrpsId').val(row.data.advrtsEntrpsId);
					$('#advrtsEntrpsNm').val(row.data.advrtsEntrpsNm);
					$('#rprsntvNm').val(row.data.rprsntvNm);
					$('#entrpsTlphonNo').val(row.data.entrpsTlphonNo);
					$('#entrpsMbtlnum').val(row.data.entrpsMbtlnum);
					$('#entrpsAtpt').val(row.data.entrpsAtpt);
					$('#entrpsGuGun').val(row.data.entrpsGuGun);
					$('#entrpsDetailAdres').val(row.data.entrpsDetailAdres);
					$('#qrFileId').val(row.data.qrFileId);
					$('#useYn').val(row.data.useYn);
				}
			}
		});

		var result = '${enterpriseList}';//[];
		console.log(result);
		xtable.update(JSON.parse(result));

		$(".insert_btn").on("click", function() {
			$('#iu').val('I');
			$('#detail input').val('').attr('readonly', false);
		});

		$(".update_btn").on("click", function() {
			$.ajax({
				url : '/enterprise/updateAdEnterprise',
				type : 'post',
				data : { 
					iu : $('#iu').val(),
					advrtsEntrpsId : 'advrtsEntrpsId' ,
					qrFileId : $('#qrFileId').val(),
					advrtsEntrpsNm : $('#advrtsEntrpsNm').val(),
					entrpsTlphonNo : $('#entrpsTlphonNo').val(), 
					rprsntvNm : $('#rprsntvNm').val(),
					advrtsEntrpsBizrno : $('#advrtsEntrpsBizrno').val(), 
					entrpsTlphonNo : $('#entrpsTlphonNo').val(),
					entrpsMbtlnum : $('#entrpsMbtlnum').val(),
					entrpsAtpt : $('#entrpsAtpt').val(), 
					entrpsGuGun : $('#entrpsGuGun').val() ,
					entrpsDetailAdres : $('#entrpsDetailAdres').val(), 
					useYn :  $('#useYn').val()
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
<body class="jui" style="margin: 0;height: 100%;">
	<div id="container">
		<header>
			<h1>광고업체정보</h1>
		</header>
		<div class="col-xs-3">
			<div id="xtable" class="xtable scroll">
				<table class="table classic small" style="height: 400px">
					<thead>
						<tr>
							<th>광고업체ID</th>
							<th>광고업체명</th>
							<th>대표자명</th>
							<th>사용여부</th>
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
	<div class="col-xs-8" style="height: 400px">
		<%@include file="adEnterpriseDetail.jsp" %>
	</div>
	<!-- 	<div class="row" align="right" style="text-align: right; margin-top: 3px;">
	    <div class="group">
	        <button onclick="xtable_page(-1);" class="btn mini">Prev</button>
	        <button onclick="xtable_page(1);" class="btn mini">Next</button>
	    </div>
	</div> -->
	<script data-jui="#xtable" data-tpl="row" type="text/template">
    <tr>
        <td><!= advrtsEntrpsId !></td>
        <td><!= advrtsEntrpsNm !></td>
        <td><!= rprsntvNm !></td>
        <td><!= useYn !></td>
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