package pe.j3ml.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class Producto {
	private int proCodigo;
	private String proNombre;
	private double proPrecio;
	private String proOferta;
	
		
	public Producto(String proNombre, double proPrecio,String proOferta) {
		super();
		this.proNombre = proNombre;
		this.proPrecio = proPrecio;
		this.proOferta = proOferta;
	}

	public Producto() {}
	
	public int getProCodigo() {
		return proCodigo;
	}
	public void setProCodigo(int proCodigo) {
		this.proCodigo = proCodigo;
	}
	public String getProNombre() {
		return proNombre;
	}
	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}
	public double getProPrecio() {
		return proPrecio;
	}
	public void setProPrecio(double proPrecio) {
		this.proPrecio = proPrecio;
	}
	public String getProOferta() {
		return proOferta;
	}
	public void setProOferta(String proOferta) {
		this.proOferta = proOferta;
	}
		
}
