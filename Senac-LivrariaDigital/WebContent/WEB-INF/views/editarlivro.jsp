<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="logicaListarLivro" class="com.livrariadigital.controller.logicanegocio.LogicaListarLivro"></jsp:useBean>
<jsp:include page="include/header.jsp">
	<jsp:param value="Editar Livro" name="title"/>
</jsp:include>
	<jsp:include page="include/navmenu.jsp"></jsp:include>
	<h3>Editar Livro</h3>
	<c:choose >
		<c:when test="${not empty param.editarLivro and param.editarLivro.matches('[0-9]+') }">
			<c:set var="livro" value="${logicaListarLivro.buscarLivroByID( param.editarLivro )}" scope="request"></c:set>
			<c:choose>
				<c:when test="${not empty livro.id}">
					<jsp:include page="include/formulariolivro.jsp" flush="true">
						<jsp:param value="Editar" name="botao"/>
					</jsp:include>
				</c:when>
				<c:when test="${empty livro.id}">
					<jsp:include page="include/alert.jsp">
						<jsp:param value="alert-warning" name="alert"/>
						<jsp:param value="glyphicon glyphicon-warning-sign" name="icon"/>
						<jsp:param value="Livro com <strong>ID ${param.editarLivro}</strong> não foi encontrado :(" name="mensagem"/>
					</jsp:include>		
				</c:when>
			</c:choose>
		</c:when>
		<c:otherwise>
			<jsp:include page="include/alert.jsp">
				<jsp:param value="alert-warning" name="alert"/>
				<jsp:param value="glyphicon glyphicon-warning-sign" name="icon"/>
				<jsp:param value="<strong>Não há livros a editar!</strong>" name="mensagem"/>
			</jsp:include>
		</c:otherwise>
	</c:choose>
<jsp:include page="include/footer.jsp" />