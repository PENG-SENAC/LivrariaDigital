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
import com.livrariadigital.util.Utilidades;

public class LogicaEditarLivro implements LogicaDeNegocio {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Connection con = FabricaDeConexao.getConexao();
		LivroDAO dao = new LivroDAO(con);
		Livro livro = new Livro();
		MapToController mapaErros = new MapToController();
		HttpSession session = request.getSession();
		
		String redirectWithQueryString = Utilidades.getParametersInURL(request); 
		Utilidades.formularioCheckFields(request, response, livro, mapaErros);

		if (mapaErros.isEmpty()) {

			try {
				livro.setId(Long.parseLong(request.getParameter("editarLivro")));
				dao.updateLivro(livro);		
				con.close();
			} catch (NumberFormatException e) {
				mapaErros.put("falha.edit", "ID Livro não reconhecido");
			} catch (SQLException e) {
				mapaErros.put("falha.edit", "Não foi possivel editar o livro");
			}
			
		}
		session.setAttribute("action", "editarLivro");
		session.setAttribute("livro", livro);
		session.setAttribute("mapaErros", mapaErros);
		
		
		if( mapaErros.isEmpty() ){
			response.sendRedirect(request.getContextPath() + "/listalivros.xhtml");
		} else {
			response.sendRedirect( request.getRequestURI()+redirectWithQueryString );
		}
		
	}

}
