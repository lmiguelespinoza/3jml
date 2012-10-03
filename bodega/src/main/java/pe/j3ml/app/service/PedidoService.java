package pe.j3ml.app.service;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/pedido-service/")
@Produces("application/xml")

public interface PedidoService {

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


