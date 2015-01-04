<%@page import="com.livrariadigital.util.Utilidades"%>
<%@page import="com.livrariadigital.model.jdbc.FabricaDeConexao"%>
<%@page
	import="com.livrariadigital.model.Livro, com.livrariadigital.model.dao.LivroDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Lista Livros</title>
</head>
<body>
	<ul>
		<table border="1">
			<th>ID</th>
			<th>Título</th>
			<th>Autor</th>
			<th>Editora</th>
			<th>Data Lançamento</th>
			<th>Email</th>
			<%
				LivroDAO dao = new LivroDAO(FabricaDeConexao.getConexao());
					List livros = dao.readLivros();
					Livro livro;

					for (int i = 0; i < livros.size(); i++) {
						livro = (Livro) livros.get(i);
			%>
			<tr class="alt">
				<td><%=livro.getId()%></td>
				<td><%=livro.getTitulo()%></td>
				<td><%=livro.getAutor()%></td>
				<td><%=livro.getEditora()%></td>
				<td><%=Utilidades.dateToString(livro.getDataLancamento())%></td>
				<td><%=livro.getEmail()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</ul>
</body>
</html>