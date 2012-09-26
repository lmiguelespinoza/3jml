package pe.j3ml.app.negocio;

import pe.j3ml.app.dao.promocionDAO;
import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.model.Promocion;

public class PromocionNegocio {

	public void insertarPromocion(String nombre, String fecIni, String fecFin,
			int codpro, double cantidad, double precio) throws DAOExcepcion {

		if (nombre == null || fecIni == null || fecFin == null || codpro == 0
				|| cantidad == 0 || precio == 0) {

			System.out.println("PARAMETROS INVALIDOS");
			throw new DAOExcepcion("PARAMETROS INVALIDOS");
		} else {
			Promocion promocion = new Promocion(nombre, fecIni, fecFin, codpro,
					cantidad, precio);
			promocionDAO dao = new promocionDAO();
			try {
				dao.insertar(promocion);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR INSERTAR CLIENTE");
			}
		}
	}

}
