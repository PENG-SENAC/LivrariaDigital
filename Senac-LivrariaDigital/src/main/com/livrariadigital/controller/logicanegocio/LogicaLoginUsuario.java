package com.livrariadigital.controller.logicanegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.livrariadigital.model.Usuario;
import com.livrariadigital.util.Utilidades;

public class LogicaLoginUsuario implements LogicaDeNegocio{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		Usuario usuario = new Usuario();
		usuario.setLogin( request.getParameter("login") );
		usuario.setSenha( request.getParameter("senha") );

		if( usuario.getLogin().equals("xpto") && usuario.getSenha().equals("xpto") ){
			usuario.setId(1L);
			
			session.setAttribute( "usuarioID", usuario.getId() );
			response.sendRedirect( request.getContextPath() + "/listalivros.xhtml" );
		} else {
			session.setAttribute( "mensagem", "Usuário ou senha incorretos");
			response.sendRedirect(request.getRequestURI()+Utilidades.getParametersInURL(request));
		}
		
	}

}
