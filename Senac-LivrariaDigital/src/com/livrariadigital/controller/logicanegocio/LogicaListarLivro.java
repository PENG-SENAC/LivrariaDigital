package com.livrariadigital.controller.logicanegocio;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;
import com.livrariadigital.util.Utilidades;

public class LogicaListarLivro implements LogicaDeNegocio {
		
	
	public LogicaListarLivro() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LivroDAO livroDao = new LivroDAO(FabricaDeConexao.getConexao());
		String nomeLivro = request.getParameter("nomeLivro");
		List<Livro> livros = null;
		System.out.println("logicalistarlivro");
		if( Utilidades.nullOrEmpty(nomeLivro) ){
			livros = livroDao.getLista();
		} else {
			livros = livroDao.buscarLivroByTitulo(nomeLivro);
		}
		 
		request.setAttribute("livros", livros);
	}
	
	public List<Livro> getLista() throws SQLException {
		LivroDAO livroDao = new LivroDAO(FabricaDeConexao.getConexao());
		List<Livro> livros = livroDao.getLista();
		
		return livros;
	}
	
	public List<Livro> buscarListaTitulo(String nomeTitulo) throws SQLException {
		LivroDAO livroDao = new LivroDAO(FabricaDeConexao.getConexao());
		List<Livro> livros =  livroDao.buscarLivroByTitulo(nomeTitulo);
		
		return livros;
	}
	
	public Livro buscarLivroByID(Long idLivro) throws SQLException {
		LivroDAO livroDao = new LivroDAO(FabricaDeConexao.getConexao());
		Livro livro = livroDao.buscarLivroById(idLivro);
		
		return livro;
	}
}
