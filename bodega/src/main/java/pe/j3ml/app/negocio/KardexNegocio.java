package pe.j3ml.app.negocio;


import java.sql.Date;
import java.text.ParseException;



import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.dao.kardexDAO;
import pe.j3ml.app.util.FechaUtil;
import pe.j3ml.app.model.Kardex;

public class KardexNegocio {
	/*public void insertKardex(int proCodigo, double KrdCantidadReal, double KrdTotalPedidos, Date KrdFechaHoraUltimoPedido
							) throws DAOExcepcion {


		{
			Kardex kardex = new Kardex(proCodigo, KrdCantidadReal, KrdTotalPedidos,  KrdFechaHoraUltimoPedido);
			kardexDAO dao = new kardexDAO();
			try {
				dao.update(kardex);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR UPDATE KARDEX");
			}
		}
	}*/
	
public void updKardex(int proCodigo, double KrdTotalPedidos) throws DAOExcepcion, ParseException {
{
	kardexDAO dao = new kardexDAO();
	String fecha = FechaUtil.getCurrentDate();

	try {
		dao.upd(proCodigo, KrdTotalPedidos, fecha);
	} catch (DAOExcepcion e) {
			throw new DAOExcepcion("ERROR UPDATE KARDEX");
		}
	}
}
	
public Kardex getInfo(int proCodigo) throws DAOExcepcion {
		Kardex kardex = null;
		kardexDAO dao = new kardexDAO();
		try {
			kardex = dao.getInfo(proCodigo);
		} catch (DAOExcepcion e) {
		throw new DAOExcepcion("ERROR UPDATE KARDEX");
		}
		return kardex;
	}
}
