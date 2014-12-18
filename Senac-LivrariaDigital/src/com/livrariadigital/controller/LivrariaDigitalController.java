package com.livrariadigital.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.controller.logicanegocio.LogicaDeNegocio;

/**
 * Servlet implementation class LivrariaDigitalController
 */
@WebServlet("/LivrariaDigitalController")
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
		String packageLogicaDeNegocio = "com.livrariadigital.controller";
		String nomeClasseLogicaDeNegocio = packageLogicaDeNegocio+"."+request.getParameter("rn");
		
		try {
			Class<?> classeLogicaDeNegocio = Class.forName(nomeClasseLogicaDeNegocio);
			
			//Verifica se Classe implementa interface Logica de Negocio
			if( !LogicaDeNegocio.class.isAssignableFrom(classeLogicaDeNegocio) ){
				throw new ServletException("Classe não implementa Interface"+nomeClasseLogicaDeNegocio);
			}
			
			LogicaDeNegocio logicaDeNegocio = (LogicaDeNegocio) classeLogicaDeNegocio.newInstance();
			logicaDeNegocio.execute(request, response);
			
		} catch (Exception e) {
			throw new ServletException("Lógica de negócio causou uma exceção", e);
		}
		
	}

}
