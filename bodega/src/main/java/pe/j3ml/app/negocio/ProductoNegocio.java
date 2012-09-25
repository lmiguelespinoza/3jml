package pe.j3ml.app.negocio;

import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.dao.productoDAO;
import pe.j3ml.app.model.Producto;

public class ProductoNegocio {
	public void insertarProducto(String pNombre, double pPrecio, String pOferta) throws DAOExcepcion {

		if (pNombre == null || pPrecio == 0 || pOferta == null ) {
			System.out.println("PARAMETROS INVALIDOS");
			throw new DAOExcepcion("PARAMETROS INVALIDOS");
		} else {
			Producto producto = new Producto(pNombre,pPrecio,pOferta);
			productoDAO dao = new productoDAO();
			try {
				dao.insertar(producto);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR INSERTAR CLIENTE");
			}
		}
	}
}
