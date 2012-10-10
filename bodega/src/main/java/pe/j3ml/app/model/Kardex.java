package pe.j3ml.app.model;

import java.sql.Date;
import java.sql.Time;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class Kardex {
	private int proCodigo;
	private double KrdCantidadReal;
	private double KrdTotalPedidos;
	private String KrdFechaHoraUltimoPedido;
	
	public Kardex() {
		super();
	}

	public Kardex(int proCodigo, double krdCantidadReal,
			double krdTotalPedidos, String krdFechaHoraUltimoPedido) {
		super();
		this.proCodigo = proCodigo;
		KrdCantidadReal = krdCantidadReal;
		KrdTotalPedidos = krdTotalPedidos;
		KrdFechaHoraUltimoPedido = krdFechaHoraUltimoPedido;
	}

	public int getProCodigo() {
		return proCodigo;
	}

	public void setProCodigo(int proCodigo) {
		this.proCodigo = proCodigo;
	}

	public double getKrdCantidadReal() {
		return KrdCantidadReal;
	}

	public void setKrdCantidadReal(double krdCantidadReal) {
		KrdCantidadReal = krdCantidadReal;
	}

	public double getKrdTotalPedidos() {
		return KrdTotalPedidos;
	}

	public void setKrdTotalPedidos(double krdTotalPedidos) {
		KrdTotalPedidos = krdTotalPedidos;
	}

	public String getKrdFechaHoraUltimoPedido() {
		return KrdFechaHoraUltimoPedido;
	}

	public void setKrdFechaHoraUltimoPedido(String krdFechaHoraUltimoPedido) {
		KrdFechaHoraUltimoPedido = krdFechaHoraUltimoPedido;
	}
	
	
}
