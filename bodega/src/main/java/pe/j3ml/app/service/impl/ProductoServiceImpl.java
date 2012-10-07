package pe.j3ml.app.service.impl;

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


public class ProductoServiceImpl implements ProductoService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Override
	public void nuevoProducto (String pNombre, String pUnivta, double pPrecio, double pStock,
			String urlReturn, HttpServletResponse servletResponse) throws IOException {
			
		// TODO Auto-generated method stub
		ProductoNegocio neg = new ProductoNegocio();
		
		try {
			neg.insertarProducto(pNombre, pUnivta, pPrecio, pStock);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(pNombre.toString()).build();

		Response.created(uri).build();
		
		servletResponse.sendRedirect(urlReturn);		

	}

}
