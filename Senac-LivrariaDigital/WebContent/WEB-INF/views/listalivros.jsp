<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp">
	<jsp:param value="Lista de Livros" name="title"/>
</jsp:include>
<jsp:include page="include/navmenu.jsp"></jsp:include>
<jsp:include page="include/showFalhaMapaErros.jsp"></jsp:include>
<c:choose>
	<c:when test="${ 'cadastrarLivro' == sessionScope.action }">
		<jsp:include page="include/alert.jsp">
			<jsp:param value="alert alert-success" name="alert"/>
			<jsp:param value="glyphicon glyphicon-thumbs-up" name="icon"/>
			<jsp:param value="<strong> Muito Bem!</strong> O Livro foi ${livro.titulo} adicionado com sucesso!" name="mensagem"/>
		</jsp:include>
	</c:when>
	<c:when test="${ 'editarLivro' == sessionScope.action }">
		<jsp:include page="include/alert.jsp">
			<jsp:param value="alert alert-success" name="alert"/>
			<jsp:param value="glyphicon glyphicon-thumbs-up" name="icon"/>
			<jsp:param value="<strong> Muito Bem!</strong> O Livro foi ${livro.titulo} adicionado com sucesso!" name="mensagem"/>
		</jsp:include>
	</c:when>
	<c:when test="${ 'excluirLivro' == sessionScope.action }">
		<jsp:include page="include/alert.jsp">
			<jsp:param value="alert alert-success" name="alert"/>
			<jsp:param value="glyphicon glyphicon-fire" name="icon"/>
			<jsp:param value="<strong> Muito Bem!</strong> O Livro foi ${livro.titulo} queimado  com sucesso!" name="mensagem"/>
		</jsp:include>
	</c:when>
</c:choose>
	<h3>Pesquisar Livro</h3>
	<form action="" method="get" >
		<div class="form-group">
			<label for="titulo">Titulo: </label>
			<input type="text" id="titulo" class="form-control" name="buscar" />
		</div>
		<div class="form-group pull-right clearfix">
			<input class="btn btn-default " type="submit" value="Buscar" />
		</div>
	</form>
	<h3>Lista de Livros</h3>
	<jsp:include page="include/tabelaLivros.jsp"></jsp:include>
<jsp:include page="include/footer.jsp"></jsp:include>