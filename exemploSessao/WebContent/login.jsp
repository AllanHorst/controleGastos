<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="style.css">
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="content">
			<form action="executarLogin" method="post">
				<input class="input-text" type="text" name="login" placeholder="Login"></input><br>
				<input class="input-text" type="password" name="senha" placeholder="Senha"></input><br>

				<input class="btn-submit" type="submit" value="Entrar">
				<div style="color: red">${msgErroLogin}</div>
			</form>
		</div>
	</body>
</html>