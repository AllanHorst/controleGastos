<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			h3 {
				text-align: center;
			}
			.input {
				padding: 10px;
				font-size: 18px;
				display: block;
				width: 350px;
			}
			.content {
				width: 350px;
				margin: 0 auto;
			}
		</style>

		<meta charset="UTF-8">
		<title>Cálculo de IMC</title>
	</head>
	<body>
		<h3>Cálculo de IMC</h3>

		<div class="content">
			<form action="calcular" method="post">
				<input type="radio" name="sexo" value="M" checked="checked"> Masculino
				<input type="radio" name="sexo" value="F"> Feminino
				<br>
				<br>
				<input class="input" type="text" name="peso" placeholder="Peso(KG)">
				<br>
				<input class="input" type="text" name="altura" placeholder="Altura(m)">
				<br>
				<input class="input" type="submit" value="Calcular" >
			</form>
		</div>

	</body>
</html>