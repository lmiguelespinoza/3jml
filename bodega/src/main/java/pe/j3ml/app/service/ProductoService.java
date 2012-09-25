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

@Path("/producto-service/")
@Produces("application/xml")

public interface ProductoService {
    @POST
    @Path("/new")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void nuevoCliente (
			@FormParam("nombre") String nombre,
			@FormParam("precio") String precio,
			@FormParam("oferta") String oferta,
			@FormParam("urlReturn") String urlReturn,	
			@Context HttpServletResponse servletResponse
	) throws IOException;
}
