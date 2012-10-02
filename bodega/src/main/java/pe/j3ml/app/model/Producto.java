package pe.j3ml.app.model;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "producto")
public class Producto {
	private int proCodigo;
	private String proNombre;
	private String proUnivta;
	private double proPrecio;
	private double proStock;
	
	public Producto() {
		super();
	}
	
	public Producto(String proNombre, String proUnivta,
			double proPrecio, double proStock) {
		super();
		this.proNombre = proNombre;
		this.proUnivta = proUnivta;
		this.proPrecio = proPrecio;
		this.proStock = proStock;
	}

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
	public String getProUnivta() {
		return proUnivta;
	}
	public void setProUnivta(String proUnivta) {
		this.proUnivta = proUnivta;
	}
	public double getProPrecio() {
		return proPrecio;
	}
	public void setProPrecio(double proPrecio) {
		this.proPrecio = proPrecio;
	}
	public double getProStock() {
		return proStock;
	}
	public void setProStock(double proStock) {
		this.proStock = proStock;
	}
			
}
