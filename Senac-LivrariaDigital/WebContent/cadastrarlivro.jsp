<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form id="formCadastrarLivro" action="executar" method="POST">
	<table>
		<tr>
			<td colspan="2" align="center"><h3>Cadastrar Livro</h3></td>
		</tr>
		<tr>
			<td><label for="titulo">Titulo: </label></td>
			<td><input type="text" id="titulo" name="titulo" /></td>
		</tr>
		<tr>
			<td><label for="autor">Autor: </label></td>
			<td><input type="text" id="autor" name = "autor" /></td>
		</tr>
		<tr>
			<td><label for="editora">Editora: </label></td>
			<td><input type="text" id="editora" name = "editora" /></td>
		</tr>
		<tr>
			<td><label for="email">Email: </label></td>
			<td><input type="text" id="email" name = "email" /></td>
		</tr>
		<tr><td>&nbsp;</td></tr> <!-- Apenas espaço em branco -->
		<tr>
			<td>&nbsp;</td>
			<td align="right">
				<input type="hidden" name="rn" value="LogicaAdicionaLivro" />
				<input type="submit" value ="cadastrar" name="cadastrar" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>