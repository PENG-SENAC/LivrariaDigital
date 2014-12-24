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
		<div class="alert alert-warning" role="alert">
		  <span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
		  <span class="sr-only">PENG!</span>
		  Tu esqueceste de preencher o livro que devemos excluir! ora bolas ;/
		</div>
	</c:if>
	<c:if test="${not empty param.excluirLivro }">
		<c:if test="${param.excluirLivro.matches('[0-9]+')}">
			<c:set var="livro" value="${logicaLivros.buscarLivroByID( param.excluirLivro )}" />
			<c:if test="${empty livro.titulo }">
				<div class="alert alert-warning" role="alert">
				  <span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
				  <span class="sr-only">Putz Grila!</span>
				  Oh Tristeza! Nenhum Livro com ID ${param.excluirLivro} foi encontrado! :( 
				</div>
			</c:if>
			<c:if test="${not empty livro.titulo }">
				<c:set var="nothing" value="${logicaExcluirLivro.excluirLivroByID( livro.id )}" />
				<div class="alert alert-success" role="alert">
				  <span class="glyphicon glyphicon-fire" aria-hidden="true"></span>
				  <strong>Muito Bem!</strong> O Livro foi ${livro.titulo} queimado  com sucesso!
				</div>
			</c:if>
		</c:if>
		<c:if test="${ not param.excluirLivro.matches('[0-9]+')}">
			<div class="alert alert-warning" role="alert">
		  		<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
		  		<strong>  Digite um número o cabra burro da muléstia!</strong>
			</div>
		</c:if>
	</c:if>
</c:catch>
<c:if test="${catchException != null}">
	<div class="alert alert-danger" role="alert">
	  <span class="glyphicon glyphicon-danger-sign" aria-hidden="true"></span>
	  <strong>Huston estamos com problemas!!!</strong>
	</div>
</c:if>
<jsp:include page="include/footer.jsp"></jsp:include>