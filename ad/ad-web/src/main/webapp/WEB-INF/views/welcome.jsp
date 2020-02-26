
<!DOCTYPE HTML>
<html>
<head>
<META charset="UTF-8">
<title>[JUI Library] - Grid</title>

<link rel="stylesheet" href="../dist/jui-grid.classic.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/juijs@2.2.1-es6/dist/jui-core.js"></script>
<script src="../dist/jui-grid.js"></script>

<script>
	jui.ready([ "grid.xtable" ], function(xtable) {
		xtable_1 = xtable("#xtable_1", {
			fields : [ "bno", "title", "writer", "regdate"  ],
			colshow : [ 0, 1, 2,3 ],
			sort : [ 0, 2 ],
			sortLoading : true,
			resize : true,
			buffer : "scroll",
			bufferCount : 20,
			scrollHeight : 300,
			event : {
				colmenu : function(column, e) {
					this.showColumnMenu(e.pageX - 25);
				}
			},
			tpl : {
				row : $("#tpl_row").html(),
				none : $("#tpl_none").html(),
				menu : $("#tpl_menu").html(),
				loading : $("#tpl_loading").html()
			}
		});

		xtable_1_submit = function() {
			var result = '${boardList}' ;//[];
			xtable_1.update(JSON.parse(result));
		}
	});
</script>
</head>
<body class="jui">
	<button class="btn small" onclick="xtable_1_submit()">
		<i class="icon-play"></i> Run
	</button>
	<div id="xtable_1" class="xtable" style="margin-top: 7px;">
		<table class="table simple headline">
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

	<script id="tpl_row" type="text/template">
    <tr>
        <td><!= bno !></td>
        <td><!= title !></td>
        <td><!= writer !></td>
        <td><!= regdate !></td>
    </tr>
</script>

	<script id="tpl_none" type="text/template">
    <tr>
        <td colspan="3" class="none" align="center">Data does not exist.</td>
    </tr>
</script>

	<script id="tpl_menu" type="text/template">
    <div class="dropdown">
        <div class="anchor"></div>

        <ul style="width: 150px">
            <! for(var i = 0; i < columns.length; i++) { !>
            <li>
                <input type="checkbox" />&nbsp; <!= columns[i] !>
            </li>
            <! } !>
        </ul>
    </div>
</script>

<script id="tpl_loading" type="text/template">
    <div class="loading"></div>
</script>


</body>
</html>