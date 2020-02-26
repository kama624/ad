<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../dist/jui-grid.classic.css" />
<script type="text/javascript">
     $(function(){
    	 boardList = function() {
    		 self.location = "/board/boardList2";
 		}
    	 writeView = function() {
    		 self.location = "/board/writeView";
 		}
   	  });
   </script>
<ul>
	<li>
		<button class="btn small" onclick="boardList()">
			<i class="icon-play"></i> 목록
		</button>
	</li>
	<li><button class="btn small" onclick="writeView()">
			<i class="icon-play"></i> 글 작성
		</button>
	</li>
</ul>