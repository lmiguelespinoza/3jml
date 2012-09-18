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
	
	public String buscarCliente(@WebParam(name = "nRuc") String nRuc
			);
	
	public void insertarCliente(@WebParam(name = "nRuc") String ruc,
			@WebParam(name = "razonSocial") String razonSocial,
			@WebParam(name = "direccion") String direccion,
			@WebParam(name = "distrito") String distrito,
			@WebParam(name = "telefono") String telefono,
			@WebParam(name = "correo") String correo,
			@WebParam(name = "contacto") String contacto);
	
}