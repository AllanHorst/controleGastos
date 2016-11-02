<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Novo Pokemon</title>
</head>
<body>
	
	<h4>Novo Pokemon</h4>
	
	<form action="salvarPokemon" method="post">
		
		Nome: <br />
		<input type="text" name="nome" size="30"/> <br />
		
		Tipo: <br /> 
		<select name="tipo">
			<c:forEach items="${listaTipos}" var="tipo">
				<option value="${tipo.id}">${tipo.descricao}</option>
			</c:forEach>
		</select>
		<br />
		
		Data de Descoberta: <br />
		<input type="date" name="dataDescoberta"/> <br/>
	
		Raridade: <br />
		<input type="radio" name="raridade" id="raridade0" value="0" checked="checked"/>
		<label for="raridade0">Comum</label>
		<br />
	
		<input type="radio" name="raridade" id="raridade1" value="1"/>
		<label for="raridade1">Normal</label>
		<br />

		<input type="radio" name="raridade" id="raridade2" value="2"/>
		<label for="raridade2">Raro</label>
		<br />

		<input type="submit" value="Salvar" />
	</form>
	
</body>

</html>