package pe.j3ml.app.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")

public class Promocion {

	private String nombre;
    private String fecIni;    
    private String fecFin;    
    private int codprod;    
    private double cantidad;    
    private double precio;
    
	public Promocion(String nombre, String fecIni, String fecFin, int codprod,
			double cantidad, double precio) {
		super();
		this.nombre = nombre;
		this.fecIni = fecIni;
		this.fecFin = fecFin;
		this.codprod = codprod;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecIni() {
		return fecIni;
	}

	public void setFecIni(String fecIni) {
		this.fecIni = fecIni;
	}

	public String getFecFin() {
		return fecFin;
	}

	public void setFecFin(String fecFin) {
		this.fecFin = fecFin;
	}

	public int getCodprod() {
		return codprod;
	}

	public void setCodprod(int codprod) {
		this.codprod = codprod;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}    
    
    
    
}
