package com.livrariadigital.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.livrariadigital.constantes.Constantes;
import com.livrariadigital.model.Livro;

public class LivroDAO {
	private Connection con;
	private PreparedStatement stmt;

	public LivroDAO(Connection con) throws SQLException {
		this.con = con;
	}

	// método que adiciona livro ao banco de dados
	public void adicionarLivro(Livro livro) throws SQLException {
		String sql = "INSERT INTO livros (titulo,autor,editora,email,dataLancamento) values (? ,? ,? ,? ,?)";

		this.stmt = this.con.prepareStatement(sql);

		this.stmt.setString(1, livro.getTitulo());
		this.stmt.setString(2, livro.getAutor());
		this.stmt.setString(3, livro.getEditora());
		this.stmt.setString(4, livro.getEmail());
		this.stmt.setDate(5, new java.sql.Date(livro.getDataLancamento().getTime()) );

		this.stmt.executeUpdate();

		System.out.println("LivroDAO - ADICIONA :" + livro.toString());
		this.closeStatement();

	}
	
	public void editarLivro(Livro livro) throws SQLException{
		String sql = "UPDATE livros"
				+ "SET titulo=?"
				+ ",autor=?"
				+ ",editora=?"
				+ ",email=?"
				+ ",dataLancamento=?"
				+ "WHERE id=?";
		
		this.stmt = this.con.prepareStatement(sql);
		
		this.stmt.setString(1, livro.getTitulo());
		this.stmt.setString(2, livro.getAutor());
		this.stmt.setString(3, livro.getEditora());
		this.stmt.setString(4, livro.getEmail());
		this.stmt.setDate(5, new java.sql.Date(livro.getDataLancamento().getTime()) );
		
		this.stmt.executeUpdate();
		
		System.out.println("LivroDAO - EDITAR :" + livro.toString());
		this.closeStatement();
	}

	public List<Livro> getLista() throws SQLException {
		String sql = "SELECT * FROM livros";
		List<Livro> livros = new ArrayList<Livro>();
		
		this.stmt = this.con.prepareStatement(sql);
		ResultSet rs = this.stmt.executeQuery();

		while (rs.next()) {
			Livro livro = new Livro();

			livro.setId(rs.getLong("id"));
			livro.setTitulo(rs.getString("titulo"));
			livro.setAutor(rs.getString("autor"));
			livro.setEditora(rs.getString("editora"));
			livro.setEmail(rs.getString("email"));
			livro.setDataLancamento( rs.getDate("dataLancamento") );

			livros.add(livro);
		}
		this.closeStatement();
		return livros;
	}
	
	public void excluirLivro( Long id ) throws SQLException{
		String sql = "DELETE FROM livros WHERE id=?";
		this.stmt = this.con.prepareStatement(sql);
		this.stmt.setLong(1, id);
		stmt.execute();
	}

	public void closeStatement() throws SQLException {
		this.stmt.close();
	}
}
