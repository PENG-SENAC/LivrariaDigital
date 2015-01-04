<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<jsp:include page="include/navmenu.jsp"></jsp:include>
<c:remove var="usuarioID" scope="session" />
<h3>Logout efetuado com Sucesso</h3>
<jsp:include page="include/footer.jsp"></jsp:include>