package com.livrariadigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.livrariadigital.jdbc.FabricaDeConexao;
import com.livrariadigital.modelo.Livro;

public class LivroDAO {
	private Connection con;
	private PreparedStatement stmt;
	
	public LivroDAO() throws SQLException {
		abreConexao();
	}
	
	private void abreConexao() throws SQLException{
		this.con = FabricaDeConexao.getConexao();
	}
	
	//método que adiciona livro ao banco de dados
	public void adiciona(Livro livro) throws SQLException {
		String sql = "INSERT INTO livros (titulo,autor,editora,email,dataLancamento) values (? ,? ,? ,? ,?)";
		
		this.stmt = con.prepareStatement(sql);
		
		this.stmt.setString(1, livro.getTitulo());
		this.stmt.setString(2, livro.getAutor());
		this.stmt.setString(3, livro.getEditora());
		this.stmt.setString(4, livro.getEmail());
		
		//stmt.setDate(5, new Date(livro.getDataLancamento().getTimeInMillis()));
		this.stmt.setDate(5, null);
		
		System.out.println("LivroDAO - ADICIONA :"+livro.toString());
		this.fechaConexao();
		
		
	}
	
	public List<Livro> getLista() throws SQLException
	{
		String sql = "SELECT * FROM livros";
		List<Livro> livros = new ArrayList<Livro>();
				
		PreparedStatement stmt;
		stmt = this.con.prepareStatement(sql);
		
		ResultSet rs =  stmt.executeQuery();
	
		while( rs.next() ) {
			Livro livro = new Livro();
			
			livro.setId(rs.getLong("id"));
			livro.setTitulo(rs.getString("titulo"));
			livro.setAutor(rs.getString("autor"));
			livro.setEditora(rs.getString("editora"));
			livro.setEmail(rs.getString("email"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataLancamento"));
			livro.setDataLancamento(data);
			
			livros.add(livro);		
		}
		
		return livros;
	}
	
	public void fechaConexao() throws SQLException{
		this.stmt.close();
		this.con.close();
	}
}
