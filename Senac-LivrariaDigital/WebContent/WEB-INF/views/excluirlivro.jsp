<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.livrariadigital.controller.logicanegocio.LogicaListarLivro"  %>
<%@ page import="com.livrariadigital.model.Livro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="logicaLivros" class="com.livrariadigital.controller.logicanegocio.LogicaListarLivro"></jsp:useBean>
<jsp:useBean id="logicaExcluirLivro" class="com.livrariadigital.controller.logicanegocio.LogicaExcluirLivro"></jsp:useBean>
<jsp:include page="include/header.jsp">
	<jsp:param value="Lista de Livros" name="title"/>
</jsp:include>
<jsp:include page="include/navmenu.jsp"></jsp:include>
<h3>Excluir Livro</h3>
<c:catch var="catchException">
	<c:if test="${empty param.excluirLivro}">
		<jsp:include page="include/alert.jsp">
			<jsp:param value="alert-warning" name="alert"/>
			<jsp:param value="glyphicon glyphicon-warning-sign" name="icon"/>
			<jsp:param value="Tu esqueceste de preencher o livro que devemos excluir! ora bolas ;/" name="mensagem"/>
		</jsp:include>
	</c:if>
	<c:if test="${not empty param.excluirLivro }">
		<c:if test="${param.excluirLivro.matches('[0-9]+')}">
			<c:set var="livro" value="${logicaLivros.buscarLivroByID( param.excluirLivro )}" />
			<c:if test="${empty livro.titulo }">
				<jsp:include page="include/alert.jsp">
					<jsp:param value="alert-warning" name="alert"/>
					<jsp:param value="glyphicon glyphicon-warning-sign" name="icon"/>
					<jsp:param value="Oh Tristeza! Nenhum Livro com ID ${param.excluirLivro} foi encontrado! :(" name="mensagem"/>
				</jsp:include>
			</c:if>
			<c:if test="${not empty livro.titulo }">
				<c:set var="nothing" value="${logicaExcluirLivro.excluirLivroByID( livro.id )}" />
				<jsp:include page="include/alert.jsp">
					<jsp:param value="alert alert-success" name="alert"/>
					<jsp:param value="glyphicon glyphicon-fire" name="icon"/>
					<jsp:param value="<strong> Muito Bem!</strong> O Livro foi ${livro.titulo} queimado  com sucesso!" name="mensagem"/>
				</jsp:include>
			</c:if>
		</c:if>
		<c:if test="${ not param.excluirLivro.matches('[0-9]+')}">
			<jsp:include page="include/alert.jsp">
				<jsp:param value="alert-warning" name="alert"/>
				<jsp:param value="glyphicon glyphicon-thumbs-down" name="icon"/>
				<jsp:param value="<strong>Digite um número o cabra burro da muléstia!</strong>" name="mensagem"/>
			</jsp:include>
		</c:if>
	</c:if>
</c:catch>
<c:if test="${catchException != null}">
	<jsp:include page="include/alert.jsp">
			<jsp:param value="alert-danger" name="alert"/>
			<jsp:param value="glyphicon glyphicon-danger-sign" name="icon"/>
			<jsp:param value="<strong>Huston estamos com problemas!!!</strong>" name="mensagem"/>
	</jsp:include>
</c:if>
<jsp:include page="include/footer.jsp"></jsp:include>