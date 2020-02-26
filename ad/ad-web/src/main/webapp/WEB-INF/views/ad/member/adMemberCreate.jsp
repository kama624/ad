<!DOCTYPE HTML>
<html>
<head>
<META charset="UTF-8">
<title>[JUI Library] - Grid</title>
<link rel="shortcut icon" href="../res/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="../res/img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="../dist/jui-grid.classic.css" />
<link rel="stylesheet" href="../dist/jui.min.css" />
<link rel="stylesheet" href="../dist/ui.min.css" />
<link rel="stylesheet" href="../dist/ui-jennifer.min.css" />
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
 -->
<script>
jui.ready([ "ui.combo" ], function(combo) {
    combo_1 = combo("#combo_1", {
        index: 2,
        event: {
            change: function(data) {
                alert("text(" + data.text + "), value(" + data.value + ")");
            }
        }
    });
});
</script>
</head>
<body class="jui">
	<div id="combo_1" class="combo">
    <a class="btn small" style="width: 179px;">Select...</a>
    <a class="btn small toggle"><i class="icon-arrow2"></i></a>
    <ul>
        <li value="1">New</li>
        <li value="2">Open</li>
        <li value="3">Save</li>
        <li value="4">Close</li>
        <li value="5">Restart</li>
        <li class="divider"></li>
        <li value="6">Print</a></li>
        <li class="divider"></li>
        <li value="7">Exit</li>
    </ul>
</div>

<button class="btn small" onclick="alert(combo_1.getText())">
    <i class="icon-play"></i> Run
</button>
</body>
</html>