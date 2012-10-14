package com.sunat.consultaestado.service;


import javax.jws.WebService;

import com.sunat.consultaestado.model.PersonaJuridica;


@SuppressWarnings("restriction")
@WebService(endpointInterface="com.sunat.consultaestado.service.EstadoService")

public class EstadoServiceImpl implements EstadoService {

	public String consultaRuc(String nRuc) {
		// TODO Auto-generated method stub
		String cEst="Inactivo";
		if (nRuc.equals("12345678901"))
			cEst="Activo";
		return cEst;
	}

	public PersonaJuridica consultarRuc(String nRuc) {
		// Estado: 1=ACTIVO, 2=INACTIVO, 3=NO EXISTE.
		PersonaJuridica persona = new PersonaJuridica();
		if(nRuc.equals("12345678901")){
			persona.setRuc(nRuc);
			persona.setRazonSocial("Bodega SAC");
			persona.setDireccion("Av. Argentina Nro. 4793 Z.i. Zona Industrial");
			persona.setDistrito("CALLAO");
			persona.setEstado(1);
			return persona;
		} else if(nRuc.equals("12345678902")){
			persona.setRuc(nRuc);
			persona.setRazonSocial("Tienda SAC");
			persona.setDireccion("Av. los Castillos Nro. C.3 Z.i. Santa Rosa");
			persona.setDistrito("ATE");
			persona.setEstado(1);
			return persona;
		} else if(nRuc.equals("12345678903")){
			persona.setRuc(nRuc);
			persona.setRazonSocial("Bodeguita SAC");
			persona.setDireccion("Av. Republica de Panama Nro. 2461");
			persona.setDistrito("LA VICTORIA");
			persona.setEstado(1);
			return persona;
		} else if(nRuc.equals("12345678904")){
			persona.setEstado(2);
			return persona;
		} else if(nRuc.equals("12345678905")){
			persona.setEstado(2);
			return persona;
		} else {
			persona.setEstado(3);
			return persona;
		}
	}


}
