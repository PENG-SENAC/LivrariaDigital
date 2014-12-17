package com.livrariadigital.logicaNegocio;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;

public class LogicaAdicionaLivro implements LogicaDeNegocio {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Executando a logica e redirecionando...");

		Livro livro = new Livro();
		LivroDAO dao = new LivroDAO();
		
		livro.setTitulo( request.getParameter("titulo") );
		livro.setAutor( request.getParameter("autor") );
		livro.setEditora( request.getParameter("editora") );
		livro.setEmail( request.getParameter("email") );

		try {
			dao.adiciona(livro);
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/listascriptlet.jsp");
		rd.forward(request, response);
	}
}
