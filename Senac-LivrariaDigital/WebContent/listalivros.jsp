<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.livrariadigital.controller.logicanegocio.LogicaListarLivro"  %>
<%@ page import="com.livrariadigital.model.Livro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp">
	<jsp:param value="Lista de Livros" name="title"/>
</jsp:include>
	<jsp:include page="include/tabelaLivros.jsp">
		<jsp:param value="Lista de Livros" name="title"/>
	</jsp:include>	
<jsp:include page="include/footer.jsp"></jsp:include>