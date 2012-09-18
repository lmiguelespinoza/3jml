package negocio;

import dao.clienteDAO;
import modelo.Cliente;
import excepcion.DAOExcepcion;
public class ClientesNegocio {
	public void insertarCliente(String ruc,String razonSocial,String direccion,
            String distrito,String telefono,String correo,String contacto) throws DAOExcepcion {
if (ruc == null || razonSocial == null || direccion == null ||
distrito == null || telefono == null || correo == null || contacto == null) {
System.out.println("INVALIDOS PARAMETROS");
throw new DAOExcepcion("INVALIDOS PARAMETROS");
} else {
Cliente cliente = new Cliente(ruc,razonSocial,direccion,distrito,telefono,correo,contacto);

clienteDAO dao = new clienteDAO();
try {
dao.insertar(cliente);
} catch (DAOExcepcion e) {
throw new DAOExcepcion("ERROR INSERTAR CLIENTE");
}
}
}

public Cliente buscarCliente(String ruc) throws DAOExcepcion {
Cliente cliente = null;
clienteDAO dao = new clienteDAO();
try {
cliente = dao.buscar(ruc);
} catch (DAOExcepcion e) {
throw new DAOExcepcion("ERROR OBTENIENDO CLIENTE");
}
return cliente;
}
}
