package com.livrariadigital.controller.logicanegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.livrariadigital.acesso.Acesso;
import com.livrariadigital.acesso.PaginaRestrita;
import com.livrariadigital.constantes.Constantes;

public class LogicaDispatcherToJSP implements LogicaDeNegocio {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pagina = request.getServletPath();
		pagina = pagina.replaceFirst(".xhtml", ".jsp");
		String uriRedirect = Constantes.VIEWS_PAGES+pagina;
		
		if( Acesso.RESTRITO == PaginaRestrita.getTipoAcesso( pagina ) ){
			HttpSession session = request.getSession();
			
			if( null == session.getAttribute("usuarioID") ){
				response.sendRedirect(request.getContextPath()+Constantes.PAGINA_ACESSO_BLOQUEADO);
				return;
			}
			
		}
		
		request.getRequestDispatcher( uriRedirect ).forward(request, response);
	}
	
}
