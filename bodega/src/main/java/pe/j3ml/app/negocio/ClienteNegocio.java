package pe.j3ml.app.negocio;

import pe.j3ml.app.dao.clienteDAO;
import pe.j3ml.app.dao.productoDAO;
import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.model.Cliente;
import pe.j3ml.app.model.Producto;

public class ClienteNegocio {
	
	public void insertarCliente(String ruc, String razonSocial, String direccion,
                                String distrito, String telefono, String correo, String contacto) throws DAOExcepcion {
		
		if (ruc == null || razonSocial == null || direccion == null ||
		    distrito == null || telefono == null || correo == null || contacto == null) {
			
			System.out.println("PARAMETROS INVALIDOS");
			throw new DAOExcepcion("PARAMETROS INVALIDOS");
		} else {
			Cliente cliente = new Cliente(ruc, razonSocial, direccion, distrito, telefono, correo, contacto);
			clienteDAO dao = new clienteDAO();
			try {
				dao.insertar(cliente);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR INSERTAR CLIENTE");
			}
		}
	}
	
	public Cliente obtenerCliente(String pRuc) throws DAOExcepcion {
		clienteDAO dao = new clienteDAO();
		return dao.obtenerCliente(pRuc);
	}

}
