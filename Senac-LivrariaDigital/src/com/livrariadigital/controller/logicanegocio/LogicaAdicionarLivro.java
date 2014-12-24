package com.livrariadigital.controller.logicanegocio;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;
import com.livrariadigital.util.Utilidades;

public class LogicaAdicionarLivro implements LogicaDeNegocio {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Livro livro = new Livro();
		LivroDAO dao = new LivroDAO( FabricaDeConexao.getConexao() );
		
		livro.setTitulo( request.getParameter("titulo") );
		livro.setAutor( request.getParameter("autor") );
		livro.setEditora( request.getParameter("editora") );
		livro.setDataLancamento( Utilidades.stringToDate(request.getParameter("data")));
		livro.setEmail( request.getParameter("email") );
		
		dao.adicionarLivro(livro);

		RequestDispatcher rd = request.getRequestDispatcher("/listalivros.jsp");
		rd.forward(request, response);
	}
}
