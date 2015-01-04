package com.livrariadigital.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.livrariadigital.model.Livro;
import com.livrariadigital.util.Utilidades;

public class LivroDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public LivroDAO(Connection con) throws SQLException {
		this.con = con;
	}

	public void createLivro(Livro livro) throws SQLException {
		String sql = "INSERT INTO livros (titulo,autor,editora,email,dataLancamento) values (? ,? ,? ,? ,?)";

		this.stmt = this.con.prepareStatement(sql);

		this.stmt.setString(1, livro.getTitulo());
		this.stmt.setString(2, livro.getAutor());
		this.stmt.setString(3, livro.getEditora());
		this.stmt.setString(4, livro.getEmail());
		this.stmt.setDate(5, new java.sql.Date(livro.getDataLancamento().getTime()));
		this.stmt.executeUpdate();

		this.close();
	}

	public void updateLivro(Livro livro) throws SQLException {
		String sql = "UPDATE livros SET titulo=?, autor=?, editora=?, email=?, dataLancamento=? WHERE id=?";

		this.stmt = this.con.prepareStatement(sql);

		this.stmt.setString(1, livro.getTitulo());
		this.stmt.setString(2, livro.getAutor());
		this.stmt.setString(3, livro.getEditora());
		this.stmt.setString(4, livro.getEmail());
		this.stmt.setDate(5, new java.sql.Date(livro.getDataLancamento().getTime()) );
		this.stmt.setLong(6, livro.getId() );
		this.stmt.executeUpdate();
		System.out.println("LivroDAO - EDITAR :" + livro.toString());

		this.close();
	}

	public Livro findLivroById(Long id) throws SQLException {
		String sql = "SELECT * FROM livros WHERE id = ?";
		this.stmt = this.con.prepareStatement(sql);
		Livro livro = new Livro();
		this.stmt.setLong(1, id);
		this.stmt.setMaxRows(1);
		this.rs = this.stmt.executeQuery();
		if (rs.first()) {
			livro.setId(rs.getLong("id"));
			livro.setTitulo(rs.getString("titulo"));
			livro.setAutor(rs.getString("autor"));
			livro.setEditora(rs.getString("editora"));
			livro.setEmail(rs.getString("email"));

			try {
				livro.setDataLancamento(Utilidades.sqlDateToUtilDate(rs
						.getDate("dataLancamento")));
			} catch (Exception e) {
				livro.setDataLancamento(new java.util.Date());
			}
		}

		this.close();
		return livro;
	}

	public List<Livro> findLivroByTitulo(String nomeLivro) throws SQLException {
		String sql = "SELECT * FROM livros WHERE titulo like ?";
		List<Livro> livros = null;
		this.stmt = this.con.prepareStatement(sql);
		this.stmt.setString(1, "%" + nomeLivro + "%");
		this.rs = this.stmt.executeQuery();
		livros = preencheListaLivro(rs);

		this.close();
		return livros;
	}

	public List<Livro> readLivros() throws SQLException {
		String sql = "SELECT * FROM livros";
		List<Livro> livros = null;

		this.stmt = this.con.prepareStatement(sql);
		this.rs = this.stmt.executeQuery();
		livros = preencheListaLivro(rs);

		this.close();
		return livros;
	}

	public void deleteLivro(Long id) throws SQLException {
		String sql = "DELETE FROM livros WHERE id=?";
		this.stmt = this.con.prepareStatement(sql);
		this.stmt.setLong(1, id);
		this.stmt.execute();
		this.close();
	}

	private List<Livro> preencheListaLivro(ResultSet rs) throws SQLException {
		List<Livro> livros = new ArrayList<Livro>();
		while (rs.next()) {
			Livro livro = new Livro();
			livro.setId(rs.getLong("id"));
			livro.setTitulo(rs.getString("titulo"));
			livro.setAutor(rs.getString("autor"));
			livro.setEditora(rs.getString("editora"));
			livro.setEmail(rs.getString("email"));
			try {
				livro.setDataLancamento(Utilidades.sqlDateToUtilDate(rs
						.getDate("dataLancamento")));
			} catch (Exception e) {
				livro.setDataLancamento(new java.util.Date());
			}
			livros.add(livro);
		}
		return livros;
	}

	public void close() throws SQLException {
		if (null != this.rs) {
			this.rs.close();
		}

		if (null != this.stmt) {
			this.stmt.close();
		}
	}

}
