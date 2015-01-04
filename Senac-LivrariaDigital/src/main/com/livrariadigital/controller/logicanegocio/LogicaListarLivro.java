package com.livrariadigital.controller.logicanegocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;
import com.livrariadigital.util.MapToController;
import com.livrariadigital.util.Utilidades;

public class LogicaListarLivro implements LogicaDeNegocio {
		
	
	public LogicaListarLivro() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		Connection con = FabricaDeConexao.getConexao();
		LivroDAO livroDao = new LivroDAO(con);
		MapToController mapaErros = new MapToController();		
		System.out.println("LogicaListarLivro");
		
		//Busca por ID: retorna apenas um Livro
		if( !Utilidades.nullOrEmpty(request.getParameter("editarLivro")) ){
			Livro livro = null;
			String textID = request.getParameter("editarLivro");
			try{
				livro = livroDao.findLivroById( Long.parseLong(textID) );
			} catch(NumberFormatException e){
				mapaErros.put("falha.buscarLivroID", "ID "+textID+" Inválido");
			} catch (SQLException e) {
				mapaErros.put("falha.buscarLivroTitulo", "Falha ao Buscar Livro ID "+textID);
			}
			request.setAttribute("livro", livro);
		
		//Busca por Titulo: retorna lista de livros
		} else if( !Utilidades.nullOrEmpty(request.getParameter("nomeLivro")) ){
			List<Livro> livros = null;
			String textTitulo = request.getParameter("nomeLivro");
			try{
				livros = livroDao.findLivroByTitulo(textTitulo);
				request.setAttribute("livros", livros);
			} catch (SQLException e){
				mapaErros.put("falha.buscarLivroTitulo", "Falha ao Buscar Livro Titulo "+textTitulo);
			}
			
		//Retorna todos os livros
		} else {
			List<Livro> livros = null;
			try {
				livros = livroDao.readLivros();
			} catch (SQLException e) {
				mapaErros.put("falha.buscarLivros", "Falha ao Buscar Livros ");
			}
			request.setAttribute("livros", livros);
		}
		request.setAttribute("mapaErros", mapaErros);
		 	
		con.close();
	}
	
}
