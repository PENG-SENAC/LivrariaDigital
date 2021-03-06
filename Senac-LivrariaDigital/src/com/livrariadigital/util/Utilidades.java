package com.livrariadigital.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.livrariadigital.constantes.Constantes;

public class Utilidades {
	
	public static Date stringToDate(String dataString) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.dataFormato);
		return sdf.parse(dataString);
	}
	
	public static String dateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.dataFormato);
		return sdf.format(date);
	}
	
	public static Date sqlDateToUtilDate(java.sql.Date sqlDate){
		return new Date(sqlDate.getTime());
	}

}
