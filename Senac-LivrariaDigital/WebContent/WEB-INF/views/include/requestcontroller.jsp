<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${ 'LogicaListarLivro' == map.rn }">
	<c:url var="urlController" value="/LivriariaDigitalController.xhtml" >
	    <c:forEach var="item" items="${map}">
			<c:param name="${item.key}" value="${item.value}"></c:param>
		</c:forEach>
	</c:url>
	<c:import url="${urlController}" />
</c:if>