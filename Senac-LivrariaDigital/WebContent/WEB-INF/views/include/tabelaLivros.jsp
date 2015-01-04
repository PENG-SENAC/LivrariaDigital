<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Controller --%>
<jsp:useBean id="map" class="com.livrariadigital.util.MapToController" scope="request"></jsp:useBean>
<c:set target="${map}" property="rn" value="LogicaListarLivro"></c:set>
<c:set target="${map}" property="nomeLivro" value="${param.buscar}"></c:set>
<jsp:include page="requestcontroller.jsp" flush="true"></jsp:include>
<jsp:useBean id="util" class="com.livrariadigital.util.Utilidades"></jsp:useBean>
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
	<c:forEach var="livro" items="${livros}" >
	<tr>
		<td>${livro.id}</td>
		<td>${livro.titulo}</td>
		<td>${livro.autor}</td>
		<td>${livro.editora}</td>
		<td><c:out value="${util.dateToString(livro.dataLancamento)}" /></td>
		<td>${livro.email}</td>
		<td>
			<a class="btn btn-default glyphicon glyphicon-pencil" href="editarlivro.xhtml?editarLivro=${livro.id}" ></a>		
			<a class="btn btn-default glyphicon glyphicon-remove-circle" aria-hidden="false" href="listalivro.xhtml?rn=LogicaExcluirLivro&excluirLivro=${livro.id}"></a>	
		</td>
	</tr>
	</c:forEach>
</table>