package pe.j3ml.app.service.impl;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import pe.j3ml.app.service.PedidoService;
import pe.j3ml.app.vo.PedidoCollection;
import pe.j3ml.app.model.*;
import pe.j3ml.app.negocio.*;
import pe.j3ml.app.excepcion.*;


public class PedidoServiceImpl implements PedidoService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	public PedidoServiceImpl() {}
	
    private static Map<String, CPedido> pedidos = new HashMap<String, CPedido>();

	@Override
	public PedidoCollection getPedidos(){
		// TODO Auto-generated method stub
		PedidoNegocio neg = new PedidoNegocio();
		pedidos.clear();		
	    			
		return new PedidoCollection(pedidos.values()); 
	}

    @Override
    public CPedido getPedido(String pPedCodigo){
  	    	
        return pedidos.get(pPedCodigo);
    }		
    
	   
	@Override
	public void nuevoPedido(String pCliRUC, String pPedFecReg, double pPedTotal, int pProCodigo,
			int pPedCantidad, double pProPrecio, double pPedParcial, 
			String urlReturn, HttpServletResponse servletResponse) throws IOException {
		// TODO Auto-generated method stub
		PedidoNegocio neg = new PedidoNegocio();
		DPedido det = new DPedido();
		det.setProCodigo(pProCodigo);
		det.setPedCantidad(pPedCantidad);
		det.setProPrecio(pProPrecio);
		det.setPedParcial(pPedParcial);
		try {
			neg.insertarPedido(pCliRUC, pPedFecReg,  pPedTotal, det);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		URI uri = uriInfo.getAbsolutePathBuilder().path(pCliRUC.toString()).build();	
		Response.created(uri).build();		
		//servletResponse.sendRedirect(urlReturn);		
		servletResponse.sendRedirect("../../pedido.jsp");		
	}
	
}
