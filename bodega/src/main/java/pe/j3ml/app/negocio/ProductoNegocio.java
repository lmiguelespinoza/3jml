package pe.j3ml.app.negocio;

import java.util.Collection;
import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.dao.productoDAO;
import pe.j3ml.app.model.Producto;

public class ProductoNegocio {
	public void insertarProducto(String pNombre, String pUnivta, double pPrecio, double pStock) throws DAOExcepcion {

		if (pNombre == null ) {
			System.out.println("PARAMETROS INVALIDOS");
			throw new DAOExcepcion("PARAMETROS INVALIDOS");
		} else {
			Producto producto = new Producto(pNombre, pUnivta, pPrecio, pStock);
			productoDAO dao = new productoDAO();
			try {
				dao.insertar(producto);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR INSERTAR CLIENTE");
			}
		}
	}
	
	public Collection<Producto> listar() throws DAOExcepcion {
		productoDAO dao = new productoDAO();
		return dao.listar();
	}	
}
