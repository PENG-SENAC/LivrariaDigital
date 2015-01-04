<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="navbar">
	<ul class="list-inline">
	  <li><a class="btn btn-default" href="index.xhtml" role="button">Home</a></li>
	  <li><a class="btn btn-default" href="cadastrarlivro.xhtml" role="button">Cadastrar Livro</a></li>
	  <li><a class="btn btn-default" href="listalivros.xhtml" role="button">Lista de Livro</a></li>
	  <li>
	  	<c:choose>
	  		<c:when test="${ empty usuarioID }">
				<a class="btn btn-default" href="login.xhtml" role="button">Login</a>		  
	  		</c:when>
	  		<c:otherwise>
	  			<a class="btn btn-default" href="logout.xhtml" role="button">Logout</a>
	  		</c:otherwise>
	  	</c:choose>
	  </li>
	</ul>
</div>