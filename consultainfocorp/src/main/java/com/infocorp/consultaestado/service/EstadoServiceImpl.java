package com.infocorp.consultaestado.service;

import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService(endpointInterface="com.infocorp.consultaestado.service.EstadoService")



public class EstadoServiceImpl implements EstadoService {

	public String consultaRuc(String nRuc) {
		// TODO Auto-generated method stub
		String cEst="Inactivo";
		if (nRuc.equals("12345678901"))
			cEst="Activo";
		return cEst;
	}

	public String consultaDNI(String nDni) {
		// TODO Auto-generated method stub
		String cEst="Inactivo";
		if (nDni.equals("12345678"))
			cEst="Activo";
		return cEst;
	}

	public String consultaRazonSocial(String rSoc) {
		// TODO Auto-generated method stub
		String cEst="Inactivo";
		if (rSoc.equals( "UPC" ))  
			cEst="Activo";
		return cEst;
	}

	public String consultaNombrePersona(String nPer) {
		// TODO Auto-generated method stub
		String cEst="Inactivo";
		if (nPer.equals( "UPC" ))  
			cEst="Activo";
		return cEst;
	}

}
