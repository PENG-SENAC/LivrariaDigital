package com.livrariadigital.teste;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import org.junit.Test;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.util.Utilidades;

import org.apache.commons.lang3.RandomStringUtils;

public class TesteLivrariaDigital {
	public static Connection con;

	@BeforeClass
	public static void getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String endereco = "jdbc:mysql://localhost/";
			String schemaDB = "livraria";
			String usuario = "livraria";
			String senha = "livraria";

			TesteLivrariaDigital.con = DriverManager.getConnection(endereco
					+ schemaDB, usuario, senha);

		} catch (Exception e) {
			// throw new SQLException(e.getMessage());
		}
	}

	@AfterClass
	public static void closeDBConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testeListarLivros() {
		List<Livro> livros = null;

		try {
			livros = (new LivroDAO(con)).readLivros();
			System.out.println("LISTA DE LIVROS: " + livros.toString());

		} catch (SQLException e) {
			Assert.fail("Falha ao instanciar ou tentar Buscar Lista de Livros");
		}

		Assert.assertNotNull(livros);

	}

	@Test
	public void testeAdicionarLivro() {
		Livro livro = new Livro();
		Random random = new Random();
		LivroDAO dao;
		String nomeAutor = RandomStringUtils.randomAlphabetic(10);
		String editora = RandomStringUtils.randomAlphabetic(5);
		livro.setTitulo(RandomStringUtils.randomAlphabetic(15));
		livro.setAutor(nomeAutor);
		livro.setEditora(editora);
		livro.setEmail(nomeAutor + "@senac.com.br");

		try {
			livro.setDataLancamento(Utilidades.stringToDate((random.nextInt(27) + 1)
					+ "/" + (random.nextInt(11) + 1) + "/2014"));
		} catch (ParseException e1) {
			Assert.fail("Falha ao fazer Parse de Data " + livro.toString());
		}

		try {
			dao = new LivroDAO(con);
			dao.createLivro(livro);

		} catch (SQLException e) {
			Assert.fail("Falha ao adicionar " + livro.toString());
			System.out.println(e.getMessage());
		}

		assertTrue("Sucesso Livro Adicionado com sucesso " + livro.toString(),
				true);
	}

	@Test
	public void testeBuscaLivroTitulo() {
		List<Livro> livros = null;
		LivroDAO dao;
		String tituloLivro;

		try {
			dao = new LivroDAO(con);
			livros = dao.readLivros();
			tituloLivro = livros.get(livros.size() - 1).getTitulo();

			livros = dao.findLivroByTitulo(tituloLivro);

			System.out.println("testeBuscaLivroTitulo " + livros.toString());
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			Assert.fail("testeBuscaLivroTitulo - Erro ao receber Lista ");
		}

	}

	@Test
	public void testeExcluirLivro() {
		this.testeAdicionarLivro();
		List<Livro> livros = null;
		LivroDAO dao;
		try {
			livros = (new LivroDAO(con)).readLivros();

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			Assert.fail("ExcluirLivro - Teste ao receber Lista ");
		}

		Livro livro = livros.get(livros.size() - 1);

		try {
			dao = new LivroDAO(con);
			dao.deleteLivro(livro.getId());

		} catch (SQLException e) {
			Assert.fail("Falha ao Excluir " + livro.toString());
			System.out.println(e.getMessage());
		}

		assertTrue(
				"ExcluirLivro - Livro Excluido com Sucesso " + livro.toString(),
				true);
	}
	
	@Test
	public void testeEditarLivro(){
		List<Livro> livros = null;
		LivroDAO dao;
		Livro livro;
		
		try {
			livros = (new LivroDAO(con)).readLivros();

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			Assert.fail("EditarLivro - Teste ao receber Lista ");
		}
		
		livro = livros.get(livros.size() - 1);
		livro.setTitulo("EDITADO"+livro.getTitulo());
		try {
			dao = new LivroDAO(con);
			dao.updateLivro(livro);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			Assert.fail("Falha ao Editar Livro " + livro.toString());
		}

		assertTrue("EditarLivro - Livro Editar com Sucesso " + livro.getTitulo(), true);
	}

	@Test
	public void testeGetLivroByID() {
		List<Livro> livros = null;
		LivroDAO dao;
		Long idLivro;

		Livro livro;
		try {
			dao = new LivroDAO(con);
			livros = dao.readLivros();
			idLivro = livros.get(livros.size() - 1).getId();
			livro = dao.findLivroById(idLivro);

			System.out.println("getLivroByID " + livro.toString());
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			Assert.fail("ExcluirLivro - Teste ao receber Lista ");
		}

	}

}
