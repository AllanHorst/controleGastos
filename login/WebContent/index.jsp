<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style.css">
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h3>Login</h3>
		<div class="content">
			<form action="efetuarLogin" method="post">
				<input class="input-text" type="text" name="usuario" placeholder="Usuário ou e-mail">
				<br>
				<input class="input-text" type="password" name="senha" placeholder="Senha">	
				<br>
				<input class="btn-submit" type="submit" value="Login">
			</form>
		</div>
	</body>
</html>