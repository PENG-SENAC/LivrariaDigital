<jsp:include page="include/header.jsp">
	<jsp:param value="Cadastro de Livro" name="title"/>
</jsp:include>
<jsp:include page="include/navmenu.jsp"></jsp:include>
<h3>Cadastro de Livro</h3>
<form id="formCadastrarLivro" action="LivrariaDigitalController" method="POST">
	<div class="form-group">
		<label for="titulo">Titulo: </label>
		<input type="text" id="titulo" class="form-control" name="titulo" />
	</div>
	<div class="form-group">	
			<label for="autor">Autor: </label>
			<input type="text" id="autor" class="form-control" name="autor" />
	</div>	
	<div class="form-group">	
			<label for="editora">Editora: </label>
			<input type="text" id="editora" class="form-control" name="editora" />
	</div>
	<div class="form-group">
			<label for="email">Data: </label>
			<input type="text" id="data" class="form-control" name="data" />
	</div>
	<div class="form-group">
			<label for="email">Email: </label>
			<input type="text" id="email" class="form-control" name="email" />
	</div>
	<input type="hidden" name="rn" value="LogicaAdicionarLivro" />
	<input class="btn btn-default " type="submit" value ="cadastrar" name="cadastrar" />
</form>
<jsp:include page="include/footer.jsp"></jsp:include>