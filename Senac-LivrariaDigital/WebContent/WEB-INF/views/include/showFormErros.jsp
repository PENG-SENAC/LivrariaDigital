<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty errorMap[param.inputcheck] }">
	<jsp:include page="alert.jsp" flush="true">
		<jsp:param value="alert-danger" name="alert" />
		<jsp:param value="glyphicon glyphicon-exclamation-sign" name="icon" />
		<jsp:param value="${errorMap[param.inputcheck]}" name="mensagem" />
	</jsp:include>
</c:if>