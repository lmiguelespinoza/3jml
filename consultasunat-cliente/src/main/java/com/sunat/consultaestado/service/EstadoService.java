package com.sunat.consultaestado.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService

public interface EstadoService {
	
	public String consultaRuc(@WebParam (name = "nRuc") String nRuc
			);

	public String consultaRazonSocial(@WebParam (name = "rSoc") String rSoc
			);

}
