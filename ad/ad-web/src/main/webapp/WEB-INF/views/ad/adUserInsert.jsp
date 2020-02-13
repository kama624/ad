<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
	 	<title>게시판</title>
	</head>
	<body>
	
		<div id="root">
			<header>
				<h1>USER</h1>
			</header>
			<hr />
			 
			<div>
				<%@include file="nav.jsp" %>
			</div>
			<hr />
			
			<section id="container">
				<form role="form" method="post" action="/userInsert">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="id">아이디</label><input type="text" id="id" name="id" />
								</td>
							</tr>	
							<tr>
								<td>
									<label for="pw">비밀번호</label><input type="password" id="pw" name="pw" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="grad">등급</label><input type="text" id="grad" name="grad" />
								</td>
							<tr>
								<td>						
									<button type="submit">등록</button>
								</td>
							</tr>			
						</tbody>			
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>