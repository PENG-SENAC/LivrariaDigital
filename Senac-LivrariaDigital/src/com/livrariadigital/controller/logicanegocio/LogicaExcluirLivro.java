package com.livrariadigital.controller.logicanegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;

public class LogicaExcluirLivro implements LogicaDeNegocio{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Logica Excluir Livro");
		String idString = request.getParameter("id");
		Long id = new Long( idString );
		LivroDAO dao = new LivroDAO( FabricaDeConexao.getConexao() );
		dao.excluirLivro(id);
	}

}
