<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Conteúdo restrito</h3>
		<p>Cê é foda <br>
			${session}
			
		</p>
		
		<a href='index.jsp'>Voltar</a><br>
		<a href='logout'>Moer sessao</a>
	</body>
</html>