package com.livrariadigital.controller.logicanegocio;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;

public class LogicaListarLivro implements LogicaDeNegocio {
	List<Livro> lista = null;	
	
	public LogicaListarLivro() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.getLista();
	}
	
	public List<Livro> getLista() throws SQLException {
		LivroDAO livroDao = new LivroDAO(FabricaDeConexao.getConexao());
		this.lista = livroDao.getLista();
		
		return lista;
	}

}
