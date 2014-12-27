<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.livrariadigital.controller.logicanegocio.LogicaListarLivro"  %>
<%@ page import="com.livrariadigital.model.Livro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp">
	<jsp:param value="Login" name="title"/>
</jsp:include>
	<jsp:include page="include/navmenu.jsp"></jsp:include>
	<h3>Entre com seu Login</h3>
	<div class="form-group">
		<label for="login">Login</label>
		<input class="form-control" id="login" name="login" type="text"/>
	</div>
	<div class="form-group">
		<label for="senha">Senha</label>
		<input class="form-control" id="senha" name="senha" type="password"/>
	</div>	
	<div class="form-group pull-right clearfix">
		<input id="rnLogin" name="rn" value="LogicaLogin" type="hidden"/>
		<input class="btn btn-default " id="submitLogin" name="submit" type="submit" value="Entrar" />
	</div>
<jsp:include page="include/footer.jsp"></jsp:include>	