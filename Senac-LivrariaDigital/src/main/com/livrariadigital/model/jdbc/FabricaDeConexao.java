package com.livrariadigital.model.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FabricaDeConexao {
	private static DataSource datasource;
	
	static{
		try{
            Context initCtx = new InitialContext();  
            Context envCtx = (Context) initCtx.lookup("java:comp/env");  
            datasource = (DataSource)envCtx.lookup("jdbc/livraria");
            
        } catch(NamingException e){  
            System.out.println("NamingException: " + e.getMessage());  
		}
	}
	
	public static Connection getConexao() throws SQLException {
		return datasource.getConnection();
	}
}