package pe.j3ml.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class Cliente {

    private String ruc;
    private String razonSocial;    
    private String direccion;    
    private String distrito;    
    private String telefono;    
    private String correo;    
    private String contacto;
    private String estado;
    
    public Cliente(String ruc, String razonSocial, String direccion,
			String distrito, String telefono, String correo, String contacto) {
		super();
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.distrito = distrito;
		this.telefono = telefono;
		this.correo = correo;
		this.contacto = contacto;
	}

	public Cliente() {}

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

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
