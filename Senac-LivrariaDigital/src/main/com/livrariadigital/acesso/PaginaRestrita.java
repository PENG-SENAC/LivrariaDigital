package com.livrariadigital.acesso;

import java.util.HashMap;
import java.util.Map;

public class PaginaRestrita {
	private static Map<String, Acesso> acessoPaginas = new HashMap<String, Acesso>();
	
	static{
		acessoPaginas.put("/listalivros.jsp", Acesso.RESTRITO);
		acessoPaginas.put("/cadastrarlivro.jsp", Acesso.RESTRITO);
		acessoPaginas.put("/editarlivro.jsp", Acesso.RESTRITO);
		acessoPaginas.put("/excluirlivro.jsp", Acesso.RESTRITO);
	}
	
	public static Acesso getTipoAcesso(String endereco){
		return acessoPaginas.get(endereco);
	}
	
}
