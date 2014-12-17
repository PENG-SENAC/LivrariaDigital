package com.livrariadigital.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String endereco = "jdbc:mysql://localhost/";
			String schemaDB = "testPeng";
			String usuario = "root";
			String senha = "";
			
			return DriverManager.getConnection(endereco+schemaDB, usuario, senha);

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
	}
	
}
