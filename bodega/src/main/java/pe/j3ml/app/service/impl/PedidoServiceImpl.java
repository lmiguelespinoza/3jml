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
	
    private static Map<String, TPedido> pedidos = new HashMap<String, TPedido>();

	@Override
	public PedidoCollection getPedidos(){
		PedidoNegocio neg = new PedidoNegocio();
		pedidos.clear();		
		try {
			Collection<TPedido> lista = neg.listar();
			String cPro="";
			for (TPedido pro:lista){
				cPro=Integer.toString(pro.getPedCodigo())+Integer.toString(pro.getProCodigo());
				pedidos.put(cPro, new TPedido(pro.getPedCodigo(),pro.getUsuNombre(),pro.getCliRUC(),pro.getCliRazonSocial(),pro.getCliDireccion(),pro.getCliDistrito(),pro.getPedFecReg(),pro.getPedFecAte(),pro.getPedTotal(),pro.getPedEstado(),pro.getProCodigo(),pro.getProNombre(),pro.getProUnivta(),pro.getPedCantidad(),pro.getProPrecio(),pro.getPedParcial()));								
				}
			}  catch (DAOExcepcion e) {
			e.printStackTrace();
		}    	    			
		return new PedidoCollection(pedidos.values()); 		
	}

	@Override
	public PedidoCollection getPedido(int pPedCodigo){
		PedidoNegocio neg = new PedidoNegocio();
		pedidos.clear();		
		try {
			Collection<TPedido> lista = neg.obtenerPedido(pPedCodigo);
			String cPro="";
			for (TPedido pro:lista){
				cPro=Integer.toString(pro.getPedCodigo())+Integer.toString(pro.getProCodigo());
				pedidos.put(cPro, new TPedido(pro.getPedCodigo(),pro.getUsuNombre(),pro.getCliRUC(),pro.getCliRazonSocial(),pro.getCliDireccion(),pro.getCliDistrito(),pro.getPedFecReg(),pro.getPedFecAte(),pro.getPedTotal(),pro.getPedEstado(),pro.getProCodigo(),pro.getProNombre(),pro.getProUnivta(),pro.getPedCantidad(),pro.getProPrecio(),pro.getPedParcial()));								
				}
			}  catch (DAOExcepcion e) {
			e.printStackTrace();
		}    	    			
		return new PedidoCollection(pedidos.values()); 		
	}

    @Override
    public int getNumeroPedido() {
    	PedidoNegocio neg = new PedidoNegocio();
    	int nPedido = 0;
    	try {
    		nPedido=neg.numeroPedido();
    		} catch (DAOExcepcion e) {
			e.printStackTrace();
    		}
        return nPedido;
    }		  
	   
	@Override
	public void nuevoCPedido(int pPedCodigo, String pUsuNombre, String pCliRUC, String pPedFecReg, double pPedTotal, 
			String urlReturn, HttpServletResponse servletResponse) throws IOException {
		// TODO Auto-generated method stub
		PedidoNegocio neg = new PedidoNegocio();
		try {
			neg.insertarCPedido(pPedCodigo, pUsuNombre, pCliRUC, pPedFecReg,  pPedTotal);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		URI uri = uriInfo.getAbsolutePathBuilder().path(pCliRUC.toString()).build();	
		Response.created(uri).build();		
		//servletResponse.sendRedirect(urlReturn);		
		servletResponse.sendRedirect("../../pedido.jsp");		
	}

	@Override
	public void nuevoDPedido(int pPedCodigo, int pProCodigo,int pPedCantidad, double pProPrecio, double pPedParcial, 
			String urlReturn, HttpServletResponse servletResponse) throws IOException {
		// TODO Auto-generated method stub
		PedidoNegocio neg = new PedidoNegocio();
		DPedido det = new DPedido();
		det.setProCodigo(pProCodigo);
		det.setPedCantidad(pPedCantidad);
		det.setProPrecio(pProPrecio);
		det.setPedParcial(pPedParcial);
		try {
			neg.insertarDPedido(pPedCodigo, pProCodigo, pPedCantidad, pProPrecio, pPedParcial);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//servletResponse.sendRedirect(urlReturn);		
		servletResponse.sendRedirect("../../pedido.jsp");		
	}
	
}
