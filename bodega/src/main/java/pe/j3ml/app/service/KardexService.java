package pe.j3ml.app.service;


import java.sql.Date;
import pe.j3ml.app.model.Kardex;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/kardex-service/")
@Produces("application/xml")

public interface KardexService {
    /*@POST
    @Path("/upd")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updKardex (
			@FormParam("proCodigo") int proCodigo,
			@FormParam("KrdCantidadReal") double KrdCantidadReal,
			@FormParam("KrdTotalPedidos") double KrdTotalPedidos,
			@FormParam("KrdFechaHoraUltimoPedido") Date KrdFechaHoraUltimoPedido,
			@FormParam("urlReturn") String urlReturn,	
			@Context HttpServletResponse servletResponse
	) throws IOException;
    */
    @POST
    @Path("/updKrd")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updKrd (
			@FormParam("proCodigo") int proCodigo,
			@FormParam("KrdTotalPedidos") double KrdTotalPedidos,
			@FormParam("urlReturn") String urlReturn,	
			@Context HttpServletResponse servletResponse
	) throws IOException;
    
    @POST
    @Path("/getinfo")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void getInfo (
			@FormParam("proCodigo") int proCodigo,
			@FormParam("urlReturn") String urlReturn,	
			@Context HttpServletResponse servletResponse
	) throws IOException;
}
