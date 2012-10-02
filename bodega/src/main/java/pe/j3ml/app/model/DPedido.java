package pe.j3ml.app.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dpedido")
public class DPedido {
	private int pedCodigo;
	private int proCodigo;
	private int pedCantidad;
	private double proPrecio;
	private double pedParcial;
			
	public DPedido() {
		super();
	}
	
	public DPedido(int pedCodigo, int proCodigo, int pedCantidad,
			double proPrecio, double pedParcial) {
		super();
		this.pedCodigo = pedCodigo;
		this.proCodigo = proCodigo;
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
