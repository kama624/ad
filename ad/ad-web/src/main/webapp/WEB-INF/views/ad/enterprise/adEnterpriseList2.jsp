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
<!-- 
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
<script type="text/javascript" src="../lib/jui/js/core.min.js" ></script>
<script type="text/javascript" src="../lib/jui/js/ui.min.js" ></script>
<script type="text/javascript" src="../lib/jui/js/grid.min.js" ></script>
<script type="text/javascript" src="../lib/jui/js/chart.min.js" ></script>
<script type="text/javascript" src="../res/event.js" ></script>
 -->
<title>게시판</title>
<script type="text/javascript">
jui.ready([ "grid.table" ], function(table) {
	
    table_3 = table("#table_3", {
    	fields : [ "advrtsEntrpsNm", "rprsntvNm","advrtsEntrpsBizrno", "entrpsTlphonNo", "entrpsMbtlnum", "entrpsDetailAdres", "useYn", "status" ],
    	colshow: [0,1,2,3,4,5,6 ],
        event: {
            expand: function(row, e) {
                $(row.list[0]).html("<i class='icon-right'></i>");
            },
            expandend: function(row, e) {
                $(row.list[0]).html("<i class='icon-left'></i>");
            }
            ,click:function(row,e){

             }
        },
        expand: true,
        animate: true
    });
	var result = '${enterpriseList}';//[];
	//console.log(result);
	table_3.update(JSON.parse(result));
	
	table_Add = function() {
     	var rows = [];
	    rows.push({ advrtsEntrpsNm: "" , rprsntvNm: "", advrtsEntrpsBizrno: "", entrpsTlphonNo: "", entrpsMbtlnum: "" , entrpsDetailAdres: "", useYn:"Y", status:"I" });
	   table_3.insert(0, rows);
	}
	
	table_save = function() {
		var gridData = table_3.listData();
		//var checkeGGridData = table_3.listChecked();
		var data = {gridData : gridData };
		//console.log(checkeGGridData);
		console.log(data);

		$.ajax({
			url : '/enterprise/updateAdEnterprise2',
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
        var useYn = $(table_3.root).find(".useYn").val();
        var status = $(table_3.root).find(".status").val();
 		if(status != "I"){
			status = "U";
		} 
        
		var data ={ 
					advrtsEntrpsNm: advrtsEntrpsNm
				  , rprsntvNm: rprsntvNm
				  , entrpsTlphonNo: entrpsTlphonNo
				  , entrpsMbtlnum: entrpsMbtlnum
				  , entrpsDetailAdres: entrpsDetailAdres
				  , advrtsEntrpsBizrno: advrtsEntrpsBizrno  
				  , useYn: useYn  
				  , status: status
				  };
		console.log(data);
		
        table_3.update(index, data);
        table_3.hideExpand();
    }

});

jui.ready([ "ui.combo" ], function(combo) {
    combo_1 = combo("#combo_1", {
        index: 0,
        event: {
            change: function(data) {
                alert("text(" + data.text + "), value(" + data.value + ")");
            }
        }
    });
});
</script>
</head>
<body class="jui jennifer">
<section>
<div id="container">
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
		        <th>사업자번호</th>
		        <th>전화번호</th>
		        <th>휴대전화번호</th>
		        <th>주소</th>
		        <th>사용여부</th>
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
        <td><!= advrtsEntrpsBizrno !></td>
        <td><!= entrpsTlphonNo !></td>
        <td><!= entrpsMbtlnum !></td>
        <td><!= entrpsDetailAdres !></td>
        <td><!= useYn !></td>
    </tr>
</script>

<script data-jui="#table_3" data-tpl="expand" type="text/template">
<div class="form-row">
	<div class="col-sm-12">
        <div class="group">
            <label class="label small">광고업체명</label>
            <input type="text" class="input small advrtsEntrpsNm" value="<!= advrtsEntrpsNm !>" style="width: 80px" />
            <input type="hidden" class="input small status" value="<!= status !>" />
        </div>
        <div class="group">
            <label class="label small">대표자명</label>
            <input type="text" class="input small rprsntvNm" value="<!= rprsntvNm !>" style="width: 80px" />
        </div>
        <div class="group">
            <label class="label small">사업자번호</label>
            <input type="text" class="input small advrtsEntrpsBizrno" value="<!= advrtsEntrpsBizrno !>" style="width: 80px" />
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
            <label class="label small">사용여부</label>
			<input type="text" class="input small useYn" value="<!= useYn !>" style="width: 80px" />
		</div>
    </div>
    <br/>
    <div class="form-row">
        <div class="group">
            <button onclick="table_3_submit(<!= row.index !>)" class="btn small">Submit</button>
            <button onclick="table_3.remove(<!= row.index !>); table_3.hideExpand();" class="btn small">Delete</button>
            <button onclick="table_3.hideExpand();" class="btn small">Cancel</button>
        </div>
    </div>
</div>
</script>
</body>
</html>