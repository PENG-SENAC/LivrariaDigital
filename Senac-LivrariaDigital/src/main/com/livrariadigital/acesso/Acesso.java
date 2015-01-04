package com.livrariadigital.acesso;

public enum Acesso {
	RESTRITO("RESTRITO"),PUBLICO("PUBLICO");
	
	private String value;
	
	Acesso(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
