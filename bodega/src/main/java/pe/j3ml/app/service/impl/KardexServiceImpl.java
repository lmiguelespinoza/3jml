package pe.j3ml.app.service.impl;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pe.j3ml.app.service.*;
import pe.j3ml.app.negocio.*;
import pe.j3ml.app.model.*;
import pe.j3ml.app.excepcion.*;


public class KardexServiceImpl implements KardexService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
/*
	@Override
	public void updKardex (int proCodigo, double KrdCantidadReal, double KrdTotalPedidos, String KrdFechaHoraUltimoPedido,
			String urlReturn, HttpServletResponse servletResponse) throws IOException {
			
		// TODO Auto-generated method stub
		KardexNegocio neg = new KardexNegocio();
		
		try {
			neg.updKardex(proCodigo, KrdCantidadReal, KrdTotalPedidos, KrdFechaHoraUltimoPedido);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(pNombre.toString()).build();

		Response.created(uri).build();
		
		servletResponse.sendRedirect(urlReturn);		

	}
	*/
	@Override
	public void updKrd (int proCodigo, double KrdTotalPedidos,
			String urlReturn, HttpServletResponse servletResponse) throws IOException {
			
		// TODO Auto-generated method stub
		KardexNegocio neg = new KardexNegocio();
		
		try {
			try {
				neg.updKardex(proCodigo, KrdTotalPedidos);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URI uri = uriInfo.getAbsolutePathBuilder().path("HOLA").build();

		Response.created(uri).build();
		
		servletResponse.sendRedirect(urlReturn);		

	}
	
	@Override
	public void getInfo (int proCodigo,
			String urlReturn, HttpServletResponse servletResponse) throws IOException {
			
		// TODO Auto-generated method stub
		Kardex kardex = null;
		KardexNegocio neg = new KardexNegocio();
		
		try {
			kardex = neg.getInfo(proCodigo);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URI uri = uriInfo.getAbsolutePathBuilder().path("MUNDO").build();

		Response.created(uri).build();
		
		servletResponse.sendRedirect(urlReturn);		

	}
	
	

}
