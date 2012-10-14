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

import pe.j3ml.app.model.Producto;
import pe.j3ml.app.service.ProductoService;
import pe.j3ml.app.negocio.ProductoNegocio;
import pe.j3ml.app.excepcion.*;
import pe.j3ml.app.vo.ProductoCollection;

public class ProductoServiceImpl implements ProductoService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	public ProductoServiceImpl() {}
	
    private static Map<String, Producto> productos = new HashMap<String, Producto>();

	@Override
	public ProductoCollection getProductos(){
		ProductoNegocio neg = new ProductoNegocio();
		productos.clear();		
		try {
			Collection<Producto> lista = neg.listar();
			String cPro="";
			for (Producto pro:lista){
				cPro=Integer.toString(pro.getProCodigo());
				productos.put(cPro, pro);
				}
			}  catch (DAOExcepcion e) {
			e.printStackTrace();
		}    	    			
		return new ProductoCollection(productos.values()); 
	}

    @Override
    public Producto getProducto(String pProCodigo){
    	int fPro= 0;
		ProductoNegocio neg = new ProductoNegocio();	
		Producto pro = new Producto();
		try {
			fPro=Integer.parseInt(pProCodigo);
			pro=neg.obtenerProducto(fPro);
			productos.clear();
			productos.put(pProCodigo, pro);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}    	    	
        return productos.get(pProCodigo);
    }		
	
	@Override
	public void nuevoProducto (String pNombre, String pUnivta, double pPrecio, double pStock,
			String urlReturn, HttpServletResponse servletResponse) throws IOException {		
		ProductoNegocio neg = new ProductoNegocio();	
		try {
			neg.insertarProducto(0, pNombre, pUnivta, pPrecio, pStock);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}		
		URI uri = uriInfo.getAbsolutePathBuilder().path(pNombre.toString()).build();
		Response.created(uri).build();		
		//servletResponse.sendRedirect(urlReturn);
		servletResponse.sendRedirect("../../producto.jsp");		
	}

}
