<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			input, textarea {
				padding: 10px;
				font-size: 18px;
				display: block;
				width: 350px
			}

			.content {width: 350px; margin: 0 auto; text-align: center;}
			h1 {text-align: center;}

		</style>

		<meta charset="UTF-8">
		<title>Exemplo parametros - Blog</title>

	</head>
	<body>
		<div class="content">
			<form method="post" action="enviarPost">
				<h1>Blog</h1> <br>	

				<input type="text" name="titulo" placeholder="Título">
				<br>
				<textarea placeholder="Escreva uma mensagem.." name="conteudo" rows="7"></textarea>
				<br>
				<input type="submit" value="Enviar" ">
			</form>
		</div>
	</body>
</html>