<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page autoFlush="true" buffer="1094kb"%>   
<jsp:useBean id="util" class="com.livrariadigital.util.Utilidades"></jsp:useBean>
<jsp:useBean id="map" class="com.livrariadigital.util.MapToController" scope="request"></jsp:useBean>
<c:set target="${map}" property="livro" value="${livro}"></c:set>
<jsp:include page="include/requestcontroller.jsp" flush="true"></jsp:include>
<jsp:include page="include/header.jsp">
	<jsp:param value="Cadastro de Livro" name="title"/>
</jsp:include>
<jsp:include page="include/navmenu.jsp" />
<h3>Cadastro de Livro</h3>
<jsp:include page="include/showFalhaMapaErros.jsp" flush="true"></jsp:include>
<jsp:include page="include/formulariolivro.jsp">
	<jsp:param value="LogicaAdicionarLivro" name="actionMethod"/>
	<jsp:param value="cadastrar" name="actionButton" />
</jsp:include>
<jsp:include page="include/footer.jsp" />