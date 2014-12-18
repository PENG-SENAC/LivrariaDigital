package com.livrariadigital.run;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.livrariadigital.model.jdbc.FabricaDeConexao;

public class Main {

	public static void main(String[] args) {
		createTable();
	}
	
	public static void createTable(){
		String query = "create table livros ("
					+ " id BigInt not null auto_increment"
					+ ",titulo varchar(255)"
					+ ",autor varchar(255)"
					+ ",editora varchar(255)"
					+ ",email varchar(255)"
					+ ",dataLancamento date"
					+ ",primary key (id)"
				+ ")";
		try {
			Connection con = FabricaDeConexao.getConexao();
			PreparedStatement prepared = con.prepareStatement(query);
			prepared.execute();
			System.out.println("Tabela Livros Criada");
			prepared.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Falha ao receber Conexao");
		}
	}

}
