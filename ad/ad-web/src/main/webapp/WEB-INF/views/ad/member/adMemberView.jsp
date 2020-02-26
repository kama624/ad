<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="shortcut icon" href="../res/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="../res/img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="../dist/jui-grid.classic.css" />
<link rel="stylesheet" href="../dist/jui.min.css" />
<!-- <link rel="stylesheet" href="../dist/ui.min.css" /> -->
<link rel="stylesheet" href="../lib/jui/css/ui.min.css" />
<link rel="stylesheet" href="../lib/jui/css/ui-jennifer.min.css" />
<!-- <link rel="stylesheet" href="../dist/ui-jennifer.min.css" /> -->
<link rel="stylesheet" href="../dist/grid.min.css" />
<link rel="stylesheet" href="../dist/grid-jennifer.min.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script	src="https://cdn.jsdelivr.net/npm/juijs@2.2.1-es6/dist/jui-core.js"></script>
<script src="../dist/jui-grid.js"></script>
<script src="../js/core.min.js"></script>
<script src="../js/ui.min.js"></script>
<script src="../js/grid.min.js"></script>
<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>게시판</title>
<script type="text/javascript">
jui.ready([ "grid.table" ], function(table) {
    table_3 = table("#table_3", {
    	fields : [ "advrtsEntrpsNm", "rprsntvNm","advrtsEntrpsBizrno", "entrpsTlphonNo", "entrpsMbtlnum", "entrpsDetailAdres" ],
        event: {
            expand: function(row, e) {
                $(row.list[0]).html("<i class='icon-right'></i>");
            },
            expandend: function(row, e) {
                $(row.list[0]).html("<i class='icon-left'></i>");
            }
        },
        expand: true,
        animate: true
    });

	table_Add = function() {
     	var rows = [];
	    rows.push({ advrtsEntrpsNm: "" , rprsntvNm: "", advrtsEntrpsBizrno: "", entrpsTlphonNo: "", entrpsMbtlnum: "" , entrpsDetailAdres: "" });
	    table_3.insert(0, rows);
	}
	
	table_save = function() {
		var userData = {
					id : $('#id').val()
			       ,pw : $('#pw').val()
			       ,name : $('#name').val() 		
			       ,mbtlnum : $('#mbtlnum').val() 		
			       ,tlphonNo : $('#tlphonNo').val() 		
			       ,atpt : $('#atpt').val() 		
			       ,guGun : $('#guGun').val() 		
			       ,detailAdres : $('#detailAdres').val() 		
			       ,grad : "A" 		
			       ,useYn : "Y" 	 	
				};
		var gridData = table_3.listData();
		var data = {
					userData : userData
				   ,gridData : gridData    	
				};
		//console.log(data);

		$.ajax({
			url : '/member/adMemberCreate',
			type : 'post',
			dataType:"json",
			contentType: "application/json",
			data : JSON.stringify(data),
			success : function(responseData) {
				if(responseData!=null){
					if(responseData.success>0){
						alert(responseData.msg);
					}
				}
			}
		});
	}
	
    table_3_submit = function(index) {
        var advrtsEntrpsNm = $(table_3.root).find(".advrtsEntrpsNm").val();
        var rprsntvNm = $(table_3.root).find(".rprsntvNm").val();
        var entrpsTlphonNo = $(table_3.root).find(".entrpsTlphonNo").val();
        var entrpsMbtlnum = $(table_3.root).find(".entrpsMbtlnum").val();
        var entrpsDetailAdres = $(table_3.root).find(".entrpsDetailAdres").val();
        var advrtsEntrpsBizrno = $(table_3.root).find(".advrtsEntrpsBizrno").val();
		var data ={ 
					advrtsEntrpsNm: advrtsEntrpsNm
				  , rprsntvNm: rprsntvNm
				  , entrpsTlphonNo: entrpsTlphonNo
				  , entrpsMbtlnum: entrpsMbtlnum
				  , entrpsDetailAdres: entrpsDetailAdres
				  , advrtsEntrpsBizrno: advrtsEntrpsBizrno  
				  };
		console.log(data);
		
        table_3.update(index, data);
        table_3.hideExpand();
    }

    
});
</script>
</head>
<body class="jui jennifer">
<section>
<div id="container">
	<form id="userForm" class="form">
		<div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="id" class="col-sm-2 col-form-label">id</label>
		      <input type="text" class="form-control" id="id" name="id" placeholder="ID"/>
		    </div>
		    <div class="form-group col-md-6">
		      <label for="name" class="col-sm-3 col-form-label">이름</label>
		      <input type="text" class="form-control" id="name" name="name" placeholder="이름">
		    </div>
		</div>
		<div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="pw" class="col-sm-3 col-form-label">Password</label>
		      <input type="password" class="form-control" id="pw" name="pw" placeholder="Password">
		    </div>
<!-- 		    <div class="form-group col-md-6">
		      <label for="pw1" class="col-sm-3 col-form-label">Password 확인</label>
		      <input type="password" class="form-control" id="pw1" name="pw1" placeholder="Password">
		    </div> -->
		</div>
		<div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="email" class="col-sm-3 col-form-label">E-Mail</label>
		      <input type="email" class="form-control" id="email" name="email" placeholder="E-Mail">
		    </div>
		</div>
		<div class="form-row">
			<div class="form-group">
			    <div class="form-group col-md-6">
			      <label for="tlphonNo">전화번호</label>
			      <input type="text" class="form-control" id="tlphonNo" name="tlphonNo" placeholder="전화번호"/>
			    </div>
			    <div class="form-group col-md-6">
			      <label for="mbtlnum">휴대전화</label>
			      <input type="text" class="form-control" id="mbtlnum" name="mbtlnum" placeholder="휴대전화">
			    </div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group">
			    <div class="form-group col-md-2">
			    	<label for="atpt">시도</label>
			    	<select id="atpt"  name="atpt" class="form-control">
			        <option selected value="01">서울</option>
			        <option  value="02">경기</option>
			      </select>
			    </div>
			    <div class="form-group col-md-2">
			    	<label for="guGun">구군</label>
			    	<select id="guGun"  name="guGun" class="form-control">
			        <option selected value="11110">중구</option>
			        <option selected value="11101">남구</option>
			      </select>
			    </div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-10">
			    <label for="detailAdres">상세주소</label>
			    <input type="text" class="form-control" id="detailAdres" placeholder="상세주소">
			</div>
		</div>
	</form>
	<div class="form-group">
		<button class="btn small" onclick="table_Add();">
		    <i class="icon-play"></i> Add
		</button>
		<button class="btn small" onclick="table_save();">
		    <i class="icon-play"></i> Save
		</button>
		<table id="table_3" class="table expand" style="width: 100%;">
		    <thead>
		    <tr>
		        <th style="width: 30px"></th>
		        <th>광고업체명</th>
		        <th>대표자명</th>
		        <th>전화번호</th>
		        <th>휴대전화번호</th>
		        <th>주소</th>
		        <th>사업자번호</th>
		    </tr>
		    </thead>
		    <tbody></tbody>
		</table>
	</div>
</div>
</section>

<script data-jui="#table_3" data-tpl="row" type="text/template">
    <tr>
        <td><i class='icon-left'></i></td>
        <td><!= advrtsEntrpsNm !></td>
        <td><!= rprsntvNm !></td>
        <td><!= entrpsTlphonNo !></td>
        <td><!= entrpsMbtlnum !></td>
        <td><!= entrpsDetailAdres !></td>
        <td><!= advrtsEntrpsBizrno !></td>
    </tr>
</script>

<script data-jui="#table_3" data-tpl="expand" type="text/template">
    <div class="row">
        <div class="group">
            <label class="label small">광고업체명</label>
            <input type="text" class="input small advrtsEntrpsNm" value="<!= advrtsEntrpsNm !>" style="width: 80px" />
        </div>
        <div class="group">
            <label class="label small">대표자명</label>
            <input type="text" class="input small rprsntvNm" value="<!= rprsntvNm !>" style="width: 80px" />
        </div>
        <div class="group">
            <label class="label small">전화번호</label>
            <input type="text" class="input small entrpsTlphonNo" value="<!= entrpsTlphonNo !>" style="width: 80px" />
        </div>
        <div class="group">
            <label class="label small">휴대전화번호</label>
            <input type="text" class="input small entrpsMbtlnum" value="<!= entrpsMbtlnum !>" style="width: 80px" />
        </div>
        <div class="group">
            <label class="label small">주소</label>
            <input type="text" class="input small entrpsDetailAdres" value="<!= entrpsDetailAdres !>" style="width: 80px" />
        </div>
        <div class="group">
            <label class="label small">사업자번호</label>
            <input type="text" class="input small advrtsEntrpsBizrno" value="<!= advrtsEntrpsBizrno !>" style="width: 80px" />
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="group">
            <button onclick="table_3_submit(<!= row.index !>)" class="btn small">Submit</button>
            <button onclick="table_3.remove(<!= row.index !>); table_3.hideExpand();" class="btn small">Delete</button>
            <button onclick="table_3.hideExpand();" class="btn small">Cancel</button>
        </div>
    </div>
</script>
</body>
</html>