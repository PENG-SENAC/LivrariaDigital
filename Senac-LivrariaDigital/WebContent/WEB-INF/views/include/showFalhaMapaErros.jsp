<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${ !mapaErros.isEmpty() }">
	<c:forEach var="erro" items="${mapaErros}" >
		<c:if test="${ erro.key.startsWith('falha') }">
			<jsp:include page="alert.jsp">
				<jsp:param value="alert-warning" name="alert"/>
				<jsp:param value="glyphicon glyphicon-warning-sign" name="icon"/>
				<jsp:param value="${erro.value}" name="mensagem"/>
			</jsp:include>
		</c:if>
	</c:forEach>
</c:if>