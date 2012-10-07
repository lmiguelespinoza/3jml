package pe.j3ml.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tpedido")

public class TPedido {
	private int    pedCodigo;
	private String usuNombre;
	private String cliRUC;
	private String cliRazonSocial;
	private String cliDireccion;
	private String cliDistrito;
	private String pedFecReg;
	private String pedFecAte;
	private double pedTotal;
	private String pedEstado;
	private int    proCodigo;
	private String proNombre;
	private String proUnivta;
	private int    pedCantidad;	
	private double proPrecio;
	private double pedParcial;
	
	public TPedido() {
		super();
	}
	
	public TPedido(int pedCodigo, String usuNombre, String cliRUC,
			String cliRazonSocial, String cliDireccion, String cliDistrito,
			String pedFecReg, String pedFecAte, double pedTotal,
			String pedEstado, int proCodigo, String proNombre,
			String proUnivta, int pedCantidad, double proPrecio,
			double pedParcial) {
		super();
		this.pedCodigo = pedCodigo;
		this.usuNombre = usuNombre;
		this.cliRUC = cliRUC;
		this.cliRazonSocial = cliRazonSocial;
		this.cliDireccion = cliDireccion;
		this.cliDistrito = cliDistrito;
		this.pedFecReg = pedFecReg;
		this.pedFecAte = pedFecAte;
		this.pedTotal = pedTotal;
		this.pedEstado = pedEstado;
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
	public String getUsuNombre() {
		return usuNombre;
	}
	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}
	public String getCliRUC() {
		return cliRUC;
	}
	public void setCliRUC(String cliRUC) {
		this.cliRUC = cliRUC;
	}
	public String getCliRazonSocial() {
		return cliRazonSocial;
	}
	public void setCliRazonSocial(String cliRazonSocial) {
		this.cliRazonSocial = cliRazonSocial;
	}
	public String getCliDireccion() {
		return cliDireccion;
	}
	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}
	public String getCliDistrito() {
		return cliDistrito;
	}
	public void setCliDistrito(String cliDistrito) {
		this.cliDistrito = cliDistrito;
	}
	public String getPedFecReg() {
		return pedFecReg;
	}
	public void setPedFecReg(String pedFecReg) {
		this.pedFecReg = pedFecReg;
	}
	public String getPedFecAte() {
		return pedFecAte;
	}
	public void setPedFecAte(String pedFecAte) {
		this.pedFecAte = pedFecAte;
	}
	public double getPedTotal() {
		return pedTotal;
	}
	public void setPedTotal(double pedTotal) {
		this.pedTotal = pedTotal;
	}
	public String getPedEstado() {
		return pedEstado;
	}
	public void setPedEstado(String pedEstado) {
		this.pedEstado = pedEstado;
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
