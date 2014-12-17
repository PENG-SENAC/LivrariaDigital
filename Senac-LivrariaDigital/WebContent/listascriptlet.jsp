<%@page import="com.livrariadigital.model.Livro, com.livrariadigital.model.dao.LivroDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Livros</title>
<style type="text/css">
 	  table
      {
        font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
        width:50%;
        border-collapse:collapse;
      }
      table td
      {
        border:1px solid #2424FF;
        padding:2px 6px 1px 6px;
      }
      table th
      {
        font-size:1.2em;
        text-align:left;
        padding-top:2px;
        padding-bottom:1px;
        background-color:#2E82FF;
        color:#fff;
      }      
      table tr.alt td
      {
        color:#000;
        background-color:#D6EDFF;
      }
</style>
</head>
<body>
<ul>
<table border="1">
			<th>Título</th>
			<th>Autor</th>
			<th>Editora</th>
			<th>Data Lançamento</th>
	<%
		LivroDAO dao = new LivroDAO();
			List livros = dao.getLista();
			Livro livro;
			
		for(int i=0; i<livros.size(); i++){
			 livro = (Livro) livros.get(i);
	%>
		<!-- <li> -->
		<tr class="alt">
		    <% SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy"); %>	
		    	    
			<td><%= livro.getTitulo()  %></td>
			<td><%= livro.getAutor() %></td>
			<td><%= livro.getEditora() %></td>
			
		<!-- </li> -->
		</tr>
		<%
			}
		%>
</table>		
</ul>
</body>
</html>