<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${mapaErros == null}">
	<c:import url="/LivriariaDigitalController.xhtml" >
		<c:param name="rn" value="LogicaListarLivro" />
		<c:param name="livro.id" value="editarLivro" />
	</c:import>
</c:if>
<jsp:include page="include/header.jsp">
	<jsp:param value="Editar Livro" name="title"/>
</jsp:include>
	<jsp:include page="include/navmenu.jsp" />
	<h3>Editar Livro</h3>
	<jsp:include page="include/showFalhaMapaErros.jsp" flush="true"></jsp:include>
	<c:choose>
		<c:when test="${ empty param.editarLivro }">
			<jsp:include page="include/alert.jsp" flush="true">
				<jsp:param value="alert-danger" name="alert" />
				<jsp:param value="glyphicon glyphicon-exclamation-sign" name="icon" />
				<jsp:param value="ID do Livro não encontrado" name="mensagem" />
			</jsp:include>
		</c:when>
		<c:when test="${ not empty param.editarLivro }" >
			<jsp:include page="include/formulariolivro.jsp" flush="true">
				<jsp:param value="LogicaEditarLivro" name="actionMethod"/>
				<jsp:param value="editar" name="actionButton" />
			</jsp:include>
		</c:when>
	</c:choose>
<jsp:include page="include/footer.jsp" />