package com.sunat.consultaestado.service;


import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService(endpointInterface="com.sunat.consultaestado.service.EstadoService")

public class EstadoServiceImpl implements EstadoService {

	public String consultaRuc(String nRuc) {
		// TODO Auto-generated method stub
		String cEst="Activo";
		if (nRuc.equals("12345678901"))
			cEst="Inactivo";
		return cEst;
	}

	public String consultaRazonSocial(String rSoc) {
		// TODO Auto-generated method stub
		String cEst="Inactivo";
		if (rSoc.equals( "UPC" ))  
			cEst="Activo";
		return cEst;
	};

}
