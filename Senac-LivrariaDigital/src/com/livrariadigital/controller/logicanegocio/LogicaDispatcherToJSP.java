package com.livrariadigital.controller.logicanegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.constantes.Constantes;

public class LogicaDispatcherToJSP implements LogicaDeNegocio {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uriRedirect = Constantes.VIEWS_PAGES+request.getServletPath();
		uriRedirect = (uriRedirect.replaceFirst(".xhtml", ".jsp"));
		System.out.println("REDIRECT "+uriRedirect);
		request.getRequestDispatcher( uriRedirect ).forward(request, response);
	}

}
