<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="executarLogin" method="post">
			<h3>Central de caronas</h3>

			<input type="text" name="login" placeholder="Login"> <br>
			<input type="password" name="senha" placeholder="Senha"> <br>
			<input type="submit" value="Entrar">
			<p style="color: red">${erro_login}</p>
		</form>
	</body>
</html>