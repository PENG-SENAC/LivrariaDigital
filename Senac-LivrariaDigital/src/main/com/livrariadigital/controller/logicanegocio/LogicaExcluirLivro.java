package com.livrariadigital.controller.logicanegocio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;
import com.livrariadigital.util.MapToController;

public class LogicaExcluirLivro implements LogicaDeNegocio{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Connection con = FabricaDeConexao.getConexao();
		LivroDAO dao = new LivroDAO( con );
		
		HttpSession session = request.getSession();
		MapToController mapaErros = new MapToController();
		
		Long id = null;
		Livro livro = null;
		
		try{
			id = Long.parseLong(request.getParameter("excluirLivro"));
		}catch(NumberFormatException e){
			mapaErros.put("id_invalido", "ID do Livro Inválido");
		}
		
		if( mapaErros.isEmpty() ){
			try {
				livro = dao.findLivroById(id);
				
				if( livro.getId() == null){
					mapaErros.put("livro_inexistente", "Livro Inexistente");
				}
				
			} catch (SQLException e) {
				mapaErros.put("falha.buscarLivro", "Falha ao Buscar Livro ID: "+id);
			}
		
		}
		
		if( mapaErros.isEmpty() ){
			try {
				dao.deleteLivro(id);
				con.close();
			} catch (SQLException e) {
				mapaErros.put("falha.excluirLivro", "Falha ao Excluir Livro ID: "+id);
			}
		}
		
		session.setAttribute("action", "excluirLivro");
		session.setAttribute("mapaErros", mapaErros);
		session.setAttribute("livro", livro);
		
		System.out.println(mapaErros.toString());
		response.sendRedirect(request.getContextPath() + "/listalivros.xhtml");
	}
	
}
