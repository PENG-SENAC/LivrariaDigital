package com.livrariadigital.teste;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;

import org.apache.commons.lang3.RandomStringUtils;

public class TesteLivrariaDigital {

	@Test
	public void TesteConexaoBancoDados(){
		Connection con;
		try {
			con = FabricaDeConexao.getConexao();
			System.out.println("Conexão com o banco de dados realizada com sucesso!");
			con.close();
			Assert.assertNotNull(con);
			
		} catch (SQLException e) {
			Assert.fail("Falha durante abertura ou fechamento da Conexao");
		}
		
	}
	
	public void listarLivros(){
		LivroDAO dao;
		List<Livro> livros = null;
		
		try {
			dao = new LivroDAO();
			livros = dao.getLista();
			System.out.println( livros );
		
		} catch (SQLException e) {
			Assert.fail("Falha ao instanciar ou tentar Buscar Lista de Livros");
			return;
		}
		
		Assert.assertNotNull(livros);
	}
	
	public void adicionaLivro(){
		Livro livro = new Livro();
		LivroDAO dao;
		String nomeAutor = RandomStringUtils.randomAlphabetic(10);
		String editora = RandomStringUtils.randomAlphabetic(5);
		livro.setTitulo(RandomStringUtils.randomAlphabetic(15));
		livro.setAutor(nomeAutor);
		livro.setEditora(editora);
		livro.setEmail(nomeAutor+"@senac.com.br");
		livro.setDataLancamento( Calendar.getInstance() );
				
		try {
			dao = new LivroDAO();
			dao.adiciona(livro);
			assertTrue("Sucesso Livro Adicionado com sucesso "+livro.toString(), true);
		} catch (SQLException e) {
			Assert.fail("Falha ao adicionar "+livro.toString() );
		}
		
	}

}
