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
import org.junit.Ignore;
import org.junit.Test;

import com.livrariadigital.constantes.Constantes;
import com.livrariadigital.model.Livro;
import com.livrariadigital.model.dao.LivroDAO;
import com.livrariadigital.model.jdbc.FabricaDeConexao;
import com.livrariadigital.util.Utilidades;

import org.apache.commons.lang3.RandomStringUtils;

public class TesteLivrariaDigital {

	@Ignore
	@Test
	public void testeConexaoBancoDados(){
		Connection con;
		try {
			con = FabricaDeConexao.getConexao();
			con.close();
			Assert.assertNotNull(con);
			
		} catch (SQLException e) {
			Assert.fail("Falha durante abertura ou fechamento da Conexao");
		}
		assertTrue("Conexao efetuada com Sucesso", true);
	}
	@Test
	public void testeListarLivros(){
		List<Livro> livros = null;
		
		try {
			livros = (new LivroDAO( FabricaDeConexao.getConexao() )).getLista();
			System.out.println( "LISTA DE LIVROS: "+livros.toString() );
		
		} catch (SQLException e) {
			Assert.fail("Falha ao instanciar ou tentar Buscar Lista de Livros");
		}
		
		Assert.assertNotNull(livros);
		
	}
	
	@Test
	public void testeAdicionarLivro(){
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
			dao.adicionarLivro(livro);
			
		} catch (SQLException e) {
			Assert.fail("Falha ao adicionar "+livro.toString() );
			System.out.println(e.getMessage());
		}
		
		assertTrue("Sucesso Livro Adicionado com sucesso "+livro.toString(), true);
	}
	
	
	@Test
	public void testeBuscaLivroTitulo(){
		List<Livro> livros = null;
		LivroDAO dao;
		String tituloLivro;
		
		try {
			dao = new LivroDAO( FabricaDeConexao.getConexao() );
			livros = dao.getLista();
			tituloLivro = livros.get( livros.size()-1 ).getTitulo();
			
			livros = dao.buscaLivroTitulo( tituloLivro );
			
			System.out.println("testeBuscaLivroTitulo "+livros.toString());
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			Assert.fail("testeBuscaLivroTitulo - Teste ao receber Lista ");
		}
		
	}
	
	@Test
	public void testeExcluirLivro(){
		this.testeAdicionarLivro();
		List<Livro> livros = null;
		LivroDAO dao;
		try {
			livros = (new LivroDAO( FabricaDeConexao.getConexao() )).getLista();

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			Assert.fail("ExcluirLivro - Teste ao receber Lista ");
		}
		
		Livro livro = livros.get( livros.size()-1 );
		
		try {
			dao = new LivroDAO(FabricaDeConexao.getConexao());
			dao.excluirLivro( livro.getId() );
			
		} catch (SQLException e) {
			Assert.fail("Falha ao Excluir "+livro.toString() );
			System.out.println(e.getMessage());
		}
		
		assertTrue("ExcluirLivro - Livro Excluido com Sucesso "+livro.toString(), true);
	}
	
	@Test
	public void testeGetLivroByID(){
		List<Livro> livros = null;
		LivroDAO dao;
		Long idLivro;
		
		Livro livro;
		try {
			dao = new LivroDAO( FabricaDeConexao.getConexao() );
			livros = dao.getLista();
			idLivro = livros.get( livros.size()-1 ).getId();
			
			livro = dao.getLivroById(idLivro);
			
			System.out.println("getLivroByID "+livro.toString());
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			Assert.fail("ExcluirLivro - Teste ao receber Lista ");
		}
		
	}

}
