package com.livrariadigital.teste;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.livrariadigital.constantes.Constantes;
import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;
import com.livrariadigital.util.Utilidades;

import org.apache.commons.lang3.RandomStringUtils;

public class TesteLivrariaDigital {

	@Test
	public void testeConexaoBancoDados(){
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
	@Test
	public void listarLivros(){
		LivroDAO dao;
		List<Livro> livros = null;
		
		try {
			dao = new LivroDAO( FabricaDeConexao.getConexao() );
			livros = dao.getLista();
			System.out.println( "LISTA DE LIVROS: "+livros.toString() );
		
		} catch (SQLException e) {
			Assert.fail("Falha ao instanciar ou tentar Buscar Lista de Livros");
			return;
		}
		
		Assert.assertNotNull(livros);
	}
	@Test
	public void adicionaLivro(){
		Livro livro = new Livro();
		Random random = new Random();
		LivroDAO dao;
		String nomeAutor = RandomStringUtils.randomAlphabetic(10);
		String editora = RandomStringUtils.randomAlphabetic(5);
		livro.setTitulo(RandomStringUtils.randomAlphabetic(15));
		livro.setAutor(nomeAutor);
		livro.setEditora(editora);
		livro.setEmail(nomeAutor+"@senac.com.br");
		
		try {
			livro.setDataLancamento( Utilidades.stringToDate((random.nextInt(27)+1)+"/"+(random.nextInt(11)+1)+"/2014") );
		} catch (ParseException e1) {
			Assert.fail("Falha ao fazer Parse de Data "+livro.toString() );
		}
		
		try {
			dao = new LivroDAO(FabricaDeConexao.getConexao());
			dao.adiciona(livro);
			assertTrue("Sucesso Livro Adicionado com sucesso "+livro.toString(), true);
		} catch (SQLException e) {
			Assert.fail("Falha ao adicionar "+livro.toString() );
		}
		
	}

}
