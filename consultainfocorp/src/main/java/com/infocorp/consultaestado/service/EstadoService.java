package com.infocorp.consultaestado.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;

@SuppressWarnings("restriction")
@WebService

public interface EstadoService {
	
	@WebResult(name = "estado")
	public String consultaRuc(@WebParam(name = "nRuc") String nRuc
			);
	
	public String consultaDNI(@WebParam(name = "nDni") String nDni
			);

	public String consultaRazonSocial(@WebParam(name = "rSoc") String rSoc
			);

	public String consultaNombrePersona(@WebParam(name = "nPer") String nPer
			);
	
}