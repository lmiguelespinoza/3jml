package pe.j3ml.app.negocio;

import java.util.Collection;

import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.dao.pedidoDAO;
import pe.j3ml.app.model.*;

public class PedidoNegocio {
	
	public int numeroPedido() throws DAOExcepcion {
		pedidoDAO dao = new pedidoDAO();
		return dao.numeroPedido();
	}
	
	public void insertarCPedido(int pPedCodigo, String pUsuNombre, String pCliRUC, String pPedFecReg, double pPedTotal) throws DAOExcepcion {

		if (pCliRUC == null ) {
			System.out.println("PARAMETROS INVALIDOS");
			throw new DAOExcepcion("PARAMETROS INVALIDOS");
		} else {
			CPedido pedido = new CPedido(pPedCodigo, pUsuNombre, pCliRUC,"","","", pPedFecReg,"", pPedTotal,"N");					
			pedidoDAO dao = new pedidoDAO();
			try {
				dao.insertarCPedido(pedido);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR INSERTAR CLIENTE");
			}
		}
	}

	public void insertarDPedido(int pPedCodigo, int pProCodigo, int pPedCantidad, double pProPrecio, double pPedParcial) throws DAOExcepcion {
		if (pPedCodigo == 0 ) {
			System.out.println("PARAMETROS INVALIDOS");
			throw new DAOExcepcion("PARAMETROS INVALIDOS");
		} else {
			DPedido pedido = new DPedido(pPedCodigo, pProCodigo, "","", pPedCantidad, pProPrecio, pPedParcial);					
			pedidoDAO dao = new pedidoDAO();
			try {
				dao.insertarDPedido(pedido);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR INSERTAR CLIENTE");
			}
		}
	}

	public Collection<TPedido> obtenerPedido(int pPedCodigo) throws DAOExcepcion {
		pedidoDAO dao = new pedidoDAO();
		return dao.obtener(pPedCodigo);
	}
	
	public Collection<TPedido> listar() throws DAOExcepcion {
		pedidoDAO dao = new pedidoDAO();
		return dao.listar();
	}		
	
}