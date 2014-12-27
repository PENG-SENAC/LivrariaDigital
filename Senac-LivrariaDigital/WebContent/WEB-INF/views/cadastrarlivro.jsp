<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page autoFlush="true" buffer="1094kb"%>   
<jsp:useBean id="util" class="com.livrariadigital.util.Utilidades"></jsp:useBean>
<jsp:useBean id="map" class="com.livrariadigital.controller.MapToController" scope="request"></jsp:useBean>
<%-- <c:set target="${map}" property="rn" value="LogicaAdicionarLivro"></c:set> --%>
<c:set target="${map}" property="livro" value="${livro}"></c:set>
<jsp:include page="include/requestcontroller.jsp" flush="true"></jsp:include>
<jsp:include page="include/header.jsp">
	<jsp:param value="Cadastro de Livro" name="title"/>
</jsp:include>
<jsp:include page="include/navmenu.jsp"></jsp:include>
<h3>Cadastro de Livro</h3>
<form id="formCadastrarLivro" action="" method="POST">
	<div class="form-group">
		<label for="titulo">Titulo*</label>
		<input type="text" id="titulo" class="form-control" name="livro.titulo" value="${livro.titulo}"/>
		<jsp:include page="include/showFormErros.jsp" flush="true">
			<jsp:param value="livro.titulo" name="inputcheck" />
		</jsp:include>
	</div>
	<div class="form-group">	
		<label for="autor">Autor*</label>
		<input type="text" id="autor" class="form-control" name="livro.autor" value="${livro.autor}" />
		<jsp:include page="include/showFormErros.jsp" flush="true">
			<jsp:param value="livro.autor" name="inputcheck" />
		</jsp:include>
	</div>	
	<div class="form-group">	
		<label for="editora">Editora*</label>
		<input type="text" id="editora" class="form-control" name="livro.editora" value="${livro.editora}" />
		<jsp:include page="include/showFormErros.jsp" flush="true">
			<jsp:param value="livro.editora" name="inputcheck" />
		</jsp:include>
	</div>
	<div class="form-group">
		<label for="email">Data*</label>
		<input type="text" id="data" class="form-control" name="livro.dataLancamento" value="${ livro.dataLancamento == null ? '' : util.dateToString(livro.dataLancamento) }" />
		<jsp:include page="include/showFormErros.jsp" flush="true">
			<jsp:param value="livro.dataLancamento" name="inputcheck" />
		</jsp:include>
	</div>
	<div class="form-group">
		<label for="email">Email*</label>
		<input type="text" id="email" class="form-control" name="livro.email" value="${livro.email}" />
		<jsp:include page="include/showFormErros.jsp" flush="true">
			<jsp:param value="livro.email" name="inputcheck" />
		</jsp:include>
	</div>
	<div class="form-group pull-right clearfix">
		<input type="hidden" value="LogicaAdicionarLivro" name="rn" />
		<input class="btn btn-default " type="submit" value ="cadastrar" name="action" />
	</div>
</form>
<jsp:include page="include/footer.jsp" />