package pe.j3ml.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cpedido")

public class CPedido {
	private int pedCodigo;
	private int cliCodigo;
	private String cliRUC;
	private String cliRazonSocial;
	private String cliDireccion;
	private String cliDistrito;
	private String pedFecReg;
	private String pedFecAte;
	private double pedTotal;
	private String pedEstado;
	private DPedido dpedido;
	
	
	
	public CPedido() {
		super();
	}
		
	public CPedido(int pedCodigo, int cliCodigo, String cliRUC,
			String cliRazonSocial, String cliDireccion, String cliDistrito,
			String pedFecReg, String pedFecAte, double pedTotal,
			String pedEstado, DPedido dpedido) {
		super();
		this.pedCodigo = pedCodigo;
		this.cliCodigo = cliCodigo;
		this.cliRUC = cliRUC;
		this.cliRazonSocial = cliRazonSocial;
		this.cliDireccion = cliDireccion;
		this.cliDistrito = cliDistrito;
		this.pedFecReg = pedFecReg;
		this.pedFecAte = pedFecAte;
		this.pedTotal = pedTotal;
		this.pedEstado = pedEstado;
		this.dpedido = dpedido;
	}

	public int getPedCodigo() {
		return pedCodigo;
	}
	public void setPedCodigo(int pedCodigo) {
		this.pedCodigo = pedCodigo;
	}
	public int getCliCodigo() {
		return cliCodigo;
	}
	public void setCliCodigo(int cliCodigo) {
		this.cliCodigo = cliCodigo;
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
	public DPedido getDpedido() {
		return dpedido;
	}
	public void setDpedido(DPedido dpedido) {
		this.dpedido = dpedido;
	}
	
	
}
