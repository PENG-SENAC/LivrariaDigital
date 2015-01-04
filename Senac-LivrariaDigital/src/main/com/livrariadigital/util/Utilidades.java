package com.livrariadigital.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livrariadigital.constantes.Constantes;
import com.livrariadigital.model.Livro;

public class Utilidades {

	public static Date stringToDate(String dataString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.DATA_FORMATO);
		return sdf.parse(dataString);
	}

	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.DATA_FORMATO);
		return sdf.format(date);
	}

	public static Date sqlDateToUtilDate(java.sql.Date sqlDate) {
		return new Date(sqlDate.getTime());
	}

	public static boolean nullOrEmpty(String text) {
		if (null == text || text.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static void formularioCheckFields(HttpServletRequest request,
			HttpServletResponse response, Livro livro, MapToController mapaErros) {
		if (Utilidades.nullOrEmpty(request.getParameter("livro.titulo"))) {
			mapaErros.put("livro.titulo", "Titulo é Obrigatorio");
		} else {
			livro.setTitulo(request.getParameter("livro.titulo"));
		}

		if (Utilidades.nullOrEmpty(request.getParameter("livro.autor"))) {
			mapaErros.put("livro.autor", "Autor é Obrigatorio");
		} else {
			livro.setAutor(request.getParameter("livro.autor"));
		}

		if (Utilidades.nullOrEmpty(request.getParameter("livro.editora"))) {
			mapaErros.put("livro.editora", "Editora é Obrigatorio");
		} else {
			livro.setEditora(request.getParameter("livro.editora"));
		}

		if (Utilidades
				.nullOrEmpty(request.getParameter("livro.dataLancamento"))) {
			mapaErros.put("livro.dataLancamento", "Data é Obrigatoria");
		} else {

			try {
				livro.setDataLancamento(Utilidades.stringToDate(request
						.getParameter("livro.dataLancamento")));
			} catch (ParseException e) {
				mapaErros.put("livro.dataLancamento",
						"Formato da data é inválido, preencha "
								+ Constantes.DATA_FORMATO);
			}

		}

		if (Utilidades.nullOrEmpty(request.getParameter("livro.email"))) {
			mapaErros.put("livro.email", "Email é Obrigatorio");
		} else {
			livro.setEmail(request.getParameter("livro.email"));
		}
	}
	
	public static String getParametersInURL(HttpServletRequest request){
		if( null != request.getQueryString() ){
			return request.getQueryString().length() > 0 ? "?"+request.getQueryString() : "";
		}
		return "";
	}
}
