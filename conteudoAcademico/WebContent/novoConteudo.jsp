<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Novo conteúdo</title>
	</head>
	<body>
		<div class="content">
			<h2>Novo conteúdo</h2>
			<form action="salvarConteudo" method="post">
				<div class="block">
					<input class="input-text" type="text" name="titulo" placeholder="Título"><br>
					<input class="input-text" type="text" name="descricao" placeholder="Descrição"><br>
					<input class="input-text" type="date" name="data" placeholder="Data do conteúdo"><br>
					Disciplina: <br /> 
					<select name="idDisciplina">
						<c:forEach items="${listaDisciplinas}" var="disciplina">
							<option value="${disciplina.id}">${disciplina.descricao}</option>
						</c:forEach>
					</select>
					<br />
					<input class="btn-submit" type="submit" value="Salvar">
					<a href="#" class="link-return">Cancelar</a>
				</div>
			</form>
		</div>
		
	</body>
</html>