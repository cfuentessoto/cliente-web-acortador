package com.example.cliente.acortadorurl;

public class FormularioSalida {
	
	public static String printFormulario(String urlCortaForm,String urlLargaForm,String urlCortaSal,String urlLargaSal){
		
		return 
		"<!DOCTYPE html>\n"+
		"<html lang=\"es\">\n"+
		"<head>\n"+
		"<title>Cliente Web Java Acortador</title>\n"+
		"</head>\n"+
		"<body>\n"+
		"<form action=\"getCorta\" method=\"post\" name=\"acortarClientePost\">\n"+
				"Url Larga: <input type=\"text\" name=\"url_larga\" value=\""+urlLargaForm+"\" size=140/>\n"+
				"<input type=\"hidden\" name=\"param_urlCortaSal\" value=\""+urlCortaSal+"\"/>\n"+
				"<input type=\"hidden\" name=\"url_corta\" value=\""+urlCortaForm+"\"/>\n"+
				"<input type=\"hidden\" name=\"param_urlLargaSal\" value=\""+urlLargaSal+"\"/>\n"+
				"<input type=\"submit\" value=\"Send\"/>\n"+ 
				"<p>URL Corta: "+urlCortaSal+"</p>\n"+
				"</form>\n"+
				"<br>\n"+
		"<form action=\"getLarga\" method=\"post\" name=\"alargarClientePost\">\n"+
				"Url Corta: <input type=\"text\" name=\"url_corta\" value=\""+urlCortaForm+"\" size=70/>\n"+
				"<input type=\"hidden\"  name=\"param_urlLargaSal\" value=\""+urlLargaSal+"\"/>\n"+
				"<input type=\"hidden\" name=\"url_larga\" value=\""+urlLargaForm+"\"/>\n"+
				"<input type=\"hidden\" name=\"param_urlCortaSal\" value=\""+urlCortaSal+"\"/>\n"+
				"<input type=\"submit\" value=\"Send\"/>\n"+ 
				"<p>URL Larga: "+urlLargaSal+"</p>\n"+
				"</form>\n"+
				"<br>\n"+
		"</body>\n"+
		"</html>\n";


		
	}

}
