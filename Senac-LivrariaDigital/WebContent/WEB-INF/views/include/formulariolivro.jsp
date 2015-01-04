<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="util" class="com.livrariadigital.util.Utilidades"></jsp:useBean>
<form id="formCadastrarLivro" action="" method="POST">
	<div class="form-group">
		<label for="titulo">Titulo*</label>
		<input type="text" id="titulo" class="form-control" name="livro.titulo" value="${livro.titulo}"/>
		<jsp:include page="showFormErros.jsp" flush="true">
			<jsp:param value="livro.titulo" name="inputcheck" />
		</jsp:include>
	</div>
	<div class="form-group">	
		<label for="autor">Autor*</label>
		<input type="text" id="autor" class="form-control" name="livro.autor" value="${livro.autor}" />
		<jsp:include page="showFormErros.jsp" flush="true">
			<jsp:param value="livro.autor" name="inputcheck" />
		</jsp:include>
	</div>	
	<div class="form-group">	
		<label for="editora">Editora*</label>
		<input type="text" id="editora" class="form-control" name="livro.editora" value="${livro.editora}" />
		<jsp:include page="showFormErros.jsp" flush="true">
			<jsp:param value="livro.editora" name="inputcheck" />
		</jsp:include>
	</div>
	<div class="form-group">
		<label for="email">Data*</label>
		<input type="text" id="data" class="form-control" name="livro.dataLancamento" value="${ livro.dataLancamento == null ? '' : util.dateToString(livro.dataLancamento) }" />
		<jsp:include page="showFormErros.jsp" flush="true">
			<jsp:param value="livro.dataLancamento" name="inputcheck" />
		</jsp:include>
	</div>
	<div class="form-group">
		<label for="email">Email*</label>
		<input type="text" id="email" class="form-control" name="livro.email" value="${livro.email}" />
		<jsp:include page="showFormErros.jsp" flush="true">
			<jsp:param value="livro.email" name="inputcheck" />
		</jsp:include>
	</div>
	<div class="form-group pull-right clearfix">
		<input type="hidden" value="${param.actionMethod}" name="rn" />
		<input class="btn btn-default " type="submit" value ="${param.actionButton}" name="actionButton" />
	</div>
</form>