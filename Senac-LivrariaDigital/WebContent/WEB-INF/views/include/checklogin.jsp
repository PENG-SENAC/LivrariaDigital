<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/LivriariaDigitalController.xhtml">
	<c:param name="rn" value="LogicaPermitirAcesso"></c:param>
</c:import>
<c:remove var="rn" scope="session" />