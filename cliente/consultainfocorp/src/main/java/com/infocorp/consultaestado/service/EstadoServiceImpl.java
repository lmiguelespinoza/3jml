package com.infocorp.consultaestado.service;

import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.WebMethod;


import excepcion.DAOExcepcion;

import modelo.*;
import negocio.ClientesNegocio;

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
/*
	@WebMethod public @WebResult(name="cliente") Cliente buscarCliente(String nRuc)
	{
		ClientesNegocio neg = new ClientesNegocio();
		Cliente cliente = null;
		try {
			cliente = neg.buscarCliente(nRuc);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
		return cliente;
	}
*/
	public void insertarCliente(String ruc,String razonSocial,String direccion,
            String distrito,String telefono,String correo,String contacto)
	{
		ClientesNegocio neg = new ClientesNegocio();

		try {
			neg.insertarCliente(ruc, razonSocial, direccion, distrito, telefono, correo, contacto);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
