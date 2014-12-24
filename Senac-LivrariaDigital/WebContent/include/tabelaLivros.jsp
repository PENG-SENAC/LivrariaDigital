<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.livrariadigital.controller.logicanegocio.LogicaListarLivro"  %>
<%@ page import="com.livrariadigital.model.Livro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="logicaLivros" class="com.livrariadigital.controller.logicanegocio.LogicaListarLivro"></jsp:useBean>
<c:if test="${empty param.buscar}">
	<c:set var="listaSelecionada" value="${logicaLivros.lista}" />
</c:if>
<c:if test="${not empty param.buscar}">
	<c:set var="listaSelecionada" value="${logicaLivros.buscarListaTitulo( param.buscar )}" />
</c:if>
<table class="table table-striped">
	<tr>
		<th>ID</th>
		<th>Título</th>
		<th>Autor</th>
		<th>Editora</th>
		<th>Data Lançamento</th>
		<th>Email</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach var="livro" items="${listaSelecionada}" >
	<tr>
		<td>${livro.id}</td>
		<td>${livro.titulo}</td>
		<td>${livro.autor}</td>
		<td>${livro.editora}</td>
		<td>${livro.dataLancamento}</td>
		<td>${livro.email}</td>
		<td><button type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
			</button>
			<button type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove-circle" aria-hidden="false"></span>
			</button>
		</td>
	</tr>
	</c:forEach>
</table>