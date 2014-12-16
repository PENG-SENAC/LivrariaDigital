<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form id="1" action="executar" method="POST">

Titulo: <input type="text" name = "titulo"><br>
Autor: <input type="text" name = "autor"><br>
Editora: <input type="text" name = "editora"><br>
Email: <input type="text" name = "email"><br>

<input type="submit" value ="cadastrar" name="cadastrar">	
<input type="hidden" name="rn" value="LogicaAdicionaLivro">
</form>
</body>
</html>