package pe.j3ml.app.model;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "producto")
public class Producto {
	private int proCodigo;
	private String proNombre;
	private String proUnivta;
	private double proPrecio;
	private double proStock;
	private double prmCantid;
	private double prmPrecio;
		
	public Producto() {
		super();
	}
		
	public Producto(int proCodigo, String proNombre, String proUnivta,
			double proPrecio, double proStock, double prmCantid,
			double prmPrecio) {
		super();
		this.proCodigo = proCodigo;
		this.proNombre = proNombre;
		this.proUnivta = proUnivta;
		this.proPrecio = proPrecio;
		this.proStock = proStock;
		this.prmCantid = prmCantid;
		this.prmPrecio = prmPrecio;
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
	public double getPrmCantid() {
		return prmCantid;
	}
	public void setPrmCantid(double prmCantid) {
		this.prmCantid = prmCantid;
	}
	public double getPrmPrecio() {
		return prmPrecio;
	}
	public void setPrmPrecio(double prmPrecio) {
		this.prmPrecio = prmPrecio;
	}
			
}
