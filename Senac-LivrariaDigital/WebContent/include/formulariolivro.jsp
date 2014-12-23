<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.livrariadigital.model.dao.LivroDAO"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>${param.pagina}</h3>
<form id="formCadastrarLivro" action="LivrariaDigitalController" method="POST">
	<div class="form-group">
		<label for="titulo">Titulo: </label>
		<input type="text" id="titulo" class="form-control" name="livro.titulo" value="${livro.titulo}" />
	</div>
	<div class="form-group">	
		<label for="autor">Autor: </label>
		<input type="text" id="autor" class="form-control" name="livro.autor" value="${livro.autor}" />
	</div>	
	<div class="form-group">	
		<label for="editora">Editora: </label>
		<input type="text" id="editora" class="form-control" name="livro.editora" value="${livro.editora}" />
	</div>
	<div class="form-group">
		<label for="email">Data: </label>
		<input type="text" id="data" class="form-control" name="livro.data" value="${livro.data}" />
	</div>
	<div class="form-group">
		<label for="email">Email: </label>
		<input type="text" id="email" class="form-control" name="livro.email" value="${livro.email}" />
	</div>
	<input type="hidden" name="livro.id" value="livro.id" />
	<input type="hidden" name="rn" value="LogicaEditarLivro" />
	<input class="btn btn-default " type="submit" value ="${param.botao}" name="cadastrar" />
</form>