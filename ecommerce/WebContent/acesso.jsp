<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c :import url="cabecalho.jsp"/>
		
		<h4>Acesso</h4>
		
		<p>Entrar</p>
		
		<form method="post" action="efetuarLogin">
			<input type="text" name="login" placeholder="Login"/> <br>
			<input type="password" name="senha" placeholder="Senha"/> <br>
			<input type="submit" value="Entrar"/> <br>
			<p style="color: red">${erro_login}</p>
		</form>
		
		<p>Cadastre-se</p>
		
		<form method="post" action="efetuarCadastro">
			<input type="text" name="nome" placeholder="Nome" /> <br>
			<input type="text" name="email" placeholder="E-mail" /> <br>
			<input type="textarea" rows="5" name="endereco" placeholder="Endereço" /> <br>
			<input type="password" name="senha"/ placeholder="senha"> <br>
			<input type="submit" value="Cadastrar"/> <br>
			
			<p style="color: red">${erro_cadastro}</p>
			
		</form>
		
		
	</body>
</html>