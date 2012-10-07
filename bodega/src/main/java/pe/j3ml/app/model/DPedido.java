package pe.j3ml.app.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dpedido")
public class DPedido {
	private int pedCodigo;
	private int proCodigo;
	private String proNombre;
	private String proUnivta;
	private int pedCantidad;	
	private double proPrecio;
	private double pedParcial;
	
	public DPedido() {
		super();
	}
		
	public DPedido(int pedCodigo, int proCodigo, String proNombre,
			String proUnivta, int pedCantidad, double proPrecio,
			double pedParcial) {
		super();
		this.pedCodigo = pedCodigo;
		this.proCodigo = proCodigo;
		this.proNombre = proNombre;
		this.proUnivta = proUnivta;
		this.pedCantidad = pedCantidad;
		this.proPrecio = proPrecio;
		this.pedParcial = pedParcial;
	}

	public int getPedCodigo() {
		return pedCodigo;
	}
	public void setPedCodigo(int pedCodigo) {
		this.pedCodigo = pedCodigo;
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
	public int getPedCantidad() {
		return pedCantidad;
	}
	public void setPedCantidad(int pedCantidad) {
		this.pedCantidad = pedCantidad;
	}
	public double getProPrecio() {
		return proPrecio;
	}
	public void setProPrecio(double proPrecio) {
		this.proPrecio = proPrecio;
	}
	public double getPedParcial() {
		return pedParcial;
	}
	public void setPedParcial(double pedParcial) {
		this.pedParcial = pedParcial;
	}
			
}
