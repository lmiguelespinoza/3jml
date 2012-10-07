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

import pe.j3ml.app.model.Producto;
import pe.j3ml.app.vo.ProductoCollection;

@Path("/producto-service/")
@Produces("application/xml")

public interface ProductoService {

    @GET
    @Path("/productos")
    @Produces({"application/xml", "application/json"})
    public ProductoCollection getProductos();

    @GET
    @Path("/codigo")
    @Produces({"application/xml", "application/json"})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Producto getProducto(@FormParam("pProCodigo") String pProCodigo);

    @POST
    @Path("/new")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void nuevoProducto (
			@FormParam("pNombre") String pNombre,
			@FormParam("pUnivta") String pUnivta,
			@FormParam("pPrecio") double pPrecio,
			@FormParam("pStock") double pStock,
			@FormParam("urlReturn") String urlReturn,	
			@Context HttpServletResponse servletResponse
	) throws IOException;
}
