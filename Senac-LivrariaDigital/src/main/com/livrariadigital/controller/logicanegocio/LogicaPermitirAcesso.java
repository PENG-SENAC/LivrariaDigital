package com.livrariadigital.controller.logicanegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogicaPermitirAcesso implements LogicaDeNegocio{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		
		if( null == session.getAttribute("usuarioID") ){
			System.out.println("NAO ESTA ESTA LOGADO");
			request.removeAttribute("rn");
			
		}else {
			System.out.println("JA ESTA LOGADO");
		}
		
	}
	
	
}
