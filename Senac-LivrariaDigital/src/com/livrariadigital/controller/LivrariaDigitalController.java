package com.livrariadigital.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.constantes.Constantes;
import com.livrariadigital.controller.logicanegocio.LogicaDeNegocio;
import com.livrariadigital.util.Utilidades;

/**
 * Servlet implementation class LivrariaDigitalController
 */
public class LivrariaDigitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LivrariaDigitalController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeClasseLogicaDeNegocio = null;
		
		if( Utilidades.nullOrEmpty(request.getParameter("rn")) ){
			nomeClasseLogicaDeNegocio = Constantes.PACOTE_LOGICA+"."+"LogicaDispatcherToJSP";
		}else{
			nomeClasseLogicaDeNegocio = Constantes.PACOTE_LOGICA+"."+request.getParameter("rn");
		}
				
		try {
			Class<?> classeLogicaDeNegocio = Class.forName(nomeClasseLogicaDeNegocio);
			
			if( !LogicaDeNegocio.class.isAssignableFrom(classeLogicaDeNegocio) ){
				throw new ServletException("Classe não implementa Interface"+nomeClasseLogicaDeNegocio);
			}
			
			LogicaDeNegocio logicaDeNegocio = (LogicaDeNegocio) classeLogicaDeNegocio.newInstance();
			logicaDeNegocio.execute(request, response);
			
		} catch (Exception e) {
			throw new ServletException("Lógica de negocio causou uma exceção", e);
		}
		
	}

}
