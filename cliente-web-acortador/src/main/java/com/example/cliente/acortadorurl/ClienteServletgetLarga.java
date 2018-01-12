package com.example.cliente.acortadorurl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@WebServlet(urlPatterns="/getLarga")
public class ClienteServletgetLarga extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
	    String urlLargaForm=req.getParameter("url_larga")!=null?req.getParameter("url_larga"):"";
	    String urlCortaForm=req.getParameter("url_corta")!=null?req.getParameter("url_corta"):"";
	    String urlCortaSalida=req.getParameter("param_urlCortaSal")!=null?req.getParameter("param_urlCortaSal"):"";
	    String urlLargaSalida=req.getParameter("param_urlLargaSal")!=null?req.getParameter("param_urlLargaSal"):"";
	    
	    Client client = ClientBuilder.newClient();
	    Response result=client
	            .target("http://localhost:8080/urlLarga")
	            .queryParam("id", urlCortaForm.split("http://localhost:8080/")[1])
	            .request(MediaType.TEXT_HTML)
	            .post(Entity.entity(null, MediaType.TEXT_HTML));
	    if (result.getStatus()==200) urlLargaSalida=result.readEntity(String.class);
	    else urlLargaSalida="Not found";
	    
	    String resultado=FormularioSalida.printFormulario(urlCortaForm, urlLargaForm, urlCortaSalida, urlLargaSalida);
	    out.println(resultado);
	    

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     doGet(req,resp);
	}
}
