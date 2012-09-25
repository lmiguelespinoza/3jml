package pe.j3ml.app.service.impl;

import java.io.IOException;

//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.FormParam;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;


import java.io.IOException;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pe.j3ml.app.service.*;
import pe.j3ml.app.negocio.*;
import pe.j3ml.app.excepcion.*;
import pe.j3ml.app.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Override
	public void nuevoProducto (String pNombre, double pPrecio, String pOferta,
			String urlReturn, HttpServletResponse servletResponse) throws IOException {
			
		// TODO Auto-generated method stub
		ProductoNegocio neg = new ProductoNegocio();
		
		try {
			neg.insertarProducto(pNombre, pPrecio, pOferta);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(pNombre.toString()).build();

		Response.created(uri).build();
		
		servletResponse.sendRedirect(urlReturn);		

	}

}
