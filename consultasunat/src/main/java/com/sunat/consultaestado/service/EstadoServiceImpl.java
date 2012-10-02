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
		// TODO Auto-generated method stub
		PersonaJuridica persona = new PersonaJuridica();
		if(nRuc.equals("12345678901")){
			persona.setRuc(nRuc);
			persona.setRazonSocial("Alicorp S.A.A.");
			persona.setDireccion("Av. Argentina Nro. 4793 Z.i. Zona Industrial");
			return persona;
		} else if(nRuc.equals("12345678902")){
			persona.setRuc(nRuc);
			persona.setRazonSocial("Nestle Peru S.A.");
			persona.setDireccion("Av. los Castillos Nro. C.3 Z.i. Santa Rosa");
			return persona;
		} else if(nRuc.equals("12345678903")){
			persona.setRuc(nRuc);
			persona.setRazonSocial("Gloria S.A.");
			persona.setDireccion("Av. Republica de Panama Nro. 2461");
			return persona;
		} else {
			return null;
		}
	}


}
