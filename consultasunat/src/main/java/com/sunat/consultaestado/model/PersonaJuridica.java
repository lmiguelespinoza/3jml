package com.sunat.consultaestado.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cliente")
public class PersonaJuridica {

    private String ruc;
    private String razonSocial;
    private String direccion;  
    	 
    
    
    public PersonaJuridica() {}



	public PersonaJuridica(String ruc, String razonSocial, String direccion) {
		super();
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
	}



	public String getRuc() {
		return ruc;
	}



	public void setRuc(String ruc) {
		this.ruc = ruc;
	}



	public String getRazonSocial() {
		return razonSocial;
	}



	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
    
    
}
