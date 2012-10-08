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

@Path("/cliente-service/")
@Produces("application/xml")

public interface PromocionService {

	 @POST
	    @Path("/new")
		@Produces(MediaType.TEXT_HTML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void nuevoPromocion (
				@FormParam("Promocion") String nombre,
				@FormParam("FecInicio") String fecIni,
				@FormParam("FecFin") String fecFin,
				@FormParam("CodProducto") int codpro,
				@FormParam("Cantidad") double cantidad,
				@FormParam("precio") double precio,
				@FormParam("urlReturn") String urlReturn,	
				@Context HttpServletResponse servletResponse
		) throws IOException;
	    	
	
}
