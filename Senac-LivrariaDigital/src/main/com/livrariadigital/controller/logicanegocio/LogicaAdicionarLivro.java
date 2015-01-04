package com.livrariadigital.controller.logicanegocio;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;
import com.livrariadigital.util.MapToController;
import com.livrariadigital.util.Utilidades;

public class LogicaAdicionarLivro implements LogicaDeNegocio {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection con = FabricaDeConexao.getConexao();
		LivroDAO dao = new LivroDAO(con);
		Livro livro = new Livro();
		MapToController mapaErros = new MapToController();
		HttpSession session = request.getSession();

		String redirectWithQueryString = Utilidades.getParametersInURL(request);
		Utilidades.formularioCheckFields(request, response, livro, mapaErros);

		if (mapaErros.isEmpty()) {

			try {
				dao.createLivro(livro);
				con.close();
			} catch (SQLException e) {
				mapaErros.put("falha.insert", "Não foi possivel adicionar o livro");
			}

		}
		session.setAttribute("action", "cadastrarLivro");
		session.setAttribute("livro", livro);
		session.setAttribute("mapaErros", mapaErros);

		if (mapaErros.isEmpty()) {
			response.sendRedirect(request.getContextPath()+"/listalivros.xhtml");
		} else {
			response.sendRedirect(request.getRequestURI()+redirectWithQueryString);
		}

	}
}