package com.sunat.consultaestado.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;

import com.sunat.consultaestado.model.PersonaJuridica;

@SuppressWarnings("restriction")
@WebService
public interface EstadoService {
	
	@WebResult(name = "estado")
	public String consultaRuc(@WebParam(name = "nRuc") String nRuc);

	@WebResult(name="persona")
    PersonaJuridica consultarRuc(@WebParam(name="nRuc") String nRuc);
	
}
