package com.infocorp.consultaestado.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService

public interface EstadoService {
	
	public String consultaRuc(@WebParam(name = "nRuc") String nRuc
			);
	
	public String consultaDNI(@WebParam(name = "nDni") String nDni
			);

	public String consultaRazonSocial(@WebParam(name = "rSoc") String rSoc
			);

	public String consultaNombrePersona(@WebParam(name = "nPer") String nPer
			);
	
}