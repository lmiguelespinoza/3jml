package pe.j3ml.app.service.impl;


import java.io.IOException;
import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.negocio.PromocionNegocio;
import pe.j3ml.app.service.PromocionService;

public class PromocionServiceImpl implements PromocionService {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@Override
	public void nuevoPromocion(String nombre, String fecIni, String fecFin,
			int codPro, double cantidad, double precio, String urlReturn,
			HttpServletResponse servletResponse) throws IOException {
		// TODO Auto-generated method stub

		
		
PromocionNegocio neg = new PromocionNegocio();
		
		try {
			neg.insertarPromocion(nombre, fecIni, fecFin, codPro, cantidad, precio);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(fecIni.toString()).build();

		Response.created(uri).build();
		
		servletResponse.sendRedirect(urlReturn);
	}

}
