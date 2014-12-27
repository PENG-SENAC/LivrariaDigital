package com.livrariadigital.controller.logicanegocio;

import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.livrariadigital.constantes.Constantes;
import com.livrariadigital.controller.MapToController;
import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;
import com.livrariadigital.util.Utilidades;

public class LogicaAdicionarLivro implements LogicaDeNegocio {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		MapToController errorMap = new MapToController();
		LivroDAO dao = new LivroDAO( FabricaDeConexao.getConexao() );
		Livro livro = new Livro();
				
		if( Utilidades.nullOrEmpty( request.getParameter("livro.titulo") ) ){
			errorMap.put("livro.titulo", "Titulo é Obrigatorio");
		} else {
			livro.setTitulo( request.getParameter("livro.titulo") );
		}
		
		if( Utilidades.nullOrEmpty( request.getParameter("livro.autor") ) ){
			errorMap.put("livro.autor", "Autor é Obrigatorio");
		} else {
			livro.setAutor( request.getParameter("livro.autor") );
		}
		
		if( Utilidades.nullOrEmpty( request.getParameter("livro.editora") ) ){
			errorMap.put("livro.editora", "Editora é Obrigatorio");
		} else {
			livro.setEditora( request.getParameter("livro.editora") );
		}
		
		if( Utilidades.nullOrEmpty( request.getParameter("livro.dataLancamento") ) ){
			errorMap.put("livro.dataLancamento", "Data é Obrigatoria");
		} else {
			
			try{
				livro.setDataLancamento( Utilidades.stringToDate( request.getParameter("livro.dataLancamento") ) );
			} catch(ParseException e){
				errorMap.put("livro.dataLancamento", "Formato da data é inválido, preencha "+Constantes.DATA_FORMATO );
			}
		
		}
		
		if( Utilidades.nullOrEmpty( request.getParameter("livro.email") ) ){
			errorMap.put("livro.email", "Email é Obrigatorio");
		} else {
			livro.setEmail( request.getParameter("livro.email") );
		}
		
		request.setAttribute("redirect", "listalivros.jsp");
		
		request.setAttribute("errorMap", errorMap);
		request.setAttribute("livro", livro);
		
		if( errorMap.isEmpty() ){
			HttpSession session = request.getSession();
			System.out.println("inserir");
			System.out.println(request.getContextPath() + "/listalivros.xhtml");
			dao.adicionarLivro(livro);
			session.setAttribute("livro", livro);
			session.setAttribute("action", "cadastrarLivro");
			response.sendRedirect(request.getContextPath()+"/listalivros.xhtml");//request.getRequestDispatcher( Constantes.VIEWS_PAGES+"/listalivros.jsp");
			
		}else{
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher( Constantes.VIEWS_PAGES+"/cadastrarlivro.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/listalivros.jsp");
		}
		
		
		
		return;
	}
}
