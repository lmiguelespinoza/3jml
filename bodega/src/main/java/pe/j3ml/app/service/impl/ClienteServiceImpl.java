package pe.j3ml.app.service.impl;

import java.io.IOException;
import java.net.URI;
//import java.util.HashMap;
//import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import pe.j3ml.app.service.*;
import pe.j3ml.app.negocio.*;
import pe.j3ml.app.excepcion.*;

public class ClienteServiceImpl implements ClienteService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Override
	public void nuevoCliente (String ruc, String razonSocial, String direccion, String distrito,
							  String telefono, String correo, String contacto, String urlReturn,
						      HttpServletResponse servletResponse) throws IOException {
				
		ClienteNegocio neg = new ClienteNegocio();
		
		try {
			neg.insertarCliente(ruc, razonSocial, direccion, distrito, telefono, correo, contacto);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(ruc.toString()).build();

		Response.created(uri).build();
		
		servletResponse.sendRedirect(urlReturn);
		
	}


    

}
