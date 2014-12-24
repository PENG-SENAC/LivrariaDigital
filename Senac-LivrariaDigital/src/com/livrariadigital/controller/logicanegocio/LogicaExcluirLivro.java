package com.livrariadigital.controller.logicanegocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;

public class LogicaExcluirLivro implements LogicaDeNegocio{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	}
	
	public void excluirLivroByID( Long livroID ) throws SQLException{
		LivroDAO dao = new LivroDAO( FabricaDeConexao.getConexao() );
		dao.excluirLivro(livroID);
		String nada = "";
	}

}
