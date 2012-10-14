package pe.j3ml.app.service;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

//import pe.j3ml.app.model.*;

@Path("/promocion-service/")
@Produces("application/xml")

public interface PromocionService {

	 @POST
	    @Path("/new")
		@Produces(MediaType.TEXT_HTML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void nuevoPromocion (
				@FormParam("pNombre") String nombre,
				@FormParam("pFecIni") String fecIni,
				@FormParam("pFecFin") String fecFin,
				@FormParam("pProducto") int codPro,
				@FormParam("pCantidad") double cantidad,
				@FormParam("pPrecio") double precio,
				@FormParam("urlReturn") String urlReturn,	
				@Context HttpServletResponse servletResponse
		) throws IOException;
	    	
	
}
