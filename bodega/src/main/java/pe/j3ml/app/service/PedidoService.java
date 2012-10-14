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
    public PedidoCollection getPedido(@FormParam("pPedCodigo") int pPedCodigo);

    @GET
    @Path("/getId")
    @Produces({"application/xml", "application/json"})
    public int getNumeroPedido();

    @POST
    @Path("/new")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)   
	public void nuevoCPedido(			
			@FormParam("pPedCodigo")   int pPedCodigo,
			@FormParam("pUsuNombre")   String pUsuNombre,
			@FormParam("pCliRUC")      String pCliRUC,
			@FormParam("pPedFecReg")   String pPedFecReg,
			@FormParam("pPedTotal")    double pPedTotal,
			@FormParam("urlReturn")    String urlReturn,	
			@Context HttpServletResponse servletResponse
	) throws IOException;

    @POST
    @Path("/newDet")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)    
	public void nuevoDPedido(
			@FormParam("pPedCodigo")   int pPedCodigo,		
			@FormParam("pProCodigo")   int pProCodigo,
			@FormParam("pPedCantidad") int pPedCantidad,
			@FormParam("pProPrecio")   double pProPrecio,			
			@FormParam("pPedParcial")  double pPedParcial,						
			@FormParam("urlReturn")    String urlReturn,	
			@Context HttpServletResponse servletResponse
	) throws IOException;
    
}


