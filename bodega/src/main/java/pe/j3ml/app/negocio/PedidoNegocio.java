package pe.j3ml.app.negocio;

import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.dao.pedidoDAO;
import pe.j3ml.app.model.*;

public class PedidoNegocio {
	public void insertarPedido(String pCliRUC, String pPedFecReg, double pPedTotal, DPedido pDetalle) throws DAOExcepcion {

		if (pCliRUC == null ) {
			System.out.println("PARAMETROS INVALIDOS");
			throw new DAOExcepcion("PARAMETROS INVALIDOS");
		} else {
			CPedido pedido = new CPedido(pCliRUC,pPedFecReg, pPedTotal, pDetalle);						
			pedidoDAO dao = new pedidoDAO();
			try {
				dao.insertar(pedido);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR INSERTAR CLIENTE");
			}
		}
	}
}