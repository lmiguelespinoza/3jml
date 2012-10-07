package pe.j3ml.app.service;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import pe.j3ml.app.model.CPedido;
import pe.j3ml.app.vo.PedidoCollection;

@Path("/pedido-service/")
@Produces("application/xml")

public interface PedidoService {
    @GET
    @Path("/pedidos")
    @Produces({"application/xml", "application/json"})
    public PedidoCollection getPedidos();

    @GET
    @Path("/pedido")
    @Produces({"application/xml", "application/json"})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CPedido getPedido(@FormParam("pPedCodigo") String pPedCodigo);
    
    @POST
    @Path("/new")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    
	public void nuevoPedido(
			@FormParam("pCliRUC") String pCliRUC,
			@FormParam("pPedFecReg") String pPedFecReg,
			@FormParam("pPedTotal") double pPedTotal,
			@FormParam("pProCodigo") int pProCodigo,
			@FormParam("pPedCantidad") int pPedCantidad,
			@FormParam("pProPrecio") double pProPrecio,			
			@FormParam("pPedParcial") double pPedParcial,						
			@FormParam("urlReturn") String urlReturn,	
			@Context HttpServletResponse servletResponse
	) throws IOException;
    
}


