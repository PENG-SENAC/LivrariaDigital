<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.livrariadigital.controller.logicanegocio.LogicaListarLivro"  %>
<%@ page import="com.livrariadigital.model.Livro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp">
	<jsp:param value="Lista de Livros" name="title"/>
</jsp:include>
	<jsp:include page="include/navmenu.jsp"></jsp:include>
	<h3>Pesquisar Livro</h3>
	<form action="" method="get" >
		<div class="form-group">
			<label for="titulo">Titulo: </label>
			<input type="text" id="titulo" class="form-control" name="buscar" />
		</div>
		<div class="form-group pull-right clearfix">
			<input class="btn btn-default " type="submit" />
		</div>
	</form>
	
	<h3>Lista de Livros</h3>
	<jsp:include page="include/tabelaLivros.jsp"></jsp:include>
<jsp:include page="include/footer.jsp"></jsp:include>