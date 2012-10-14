package pe.j3ml.app.negocio;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import pe.j3ml.app.util.FechaUtil;
import pe.j3ml.app.dao.promocionDAO;
import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.model.Promocion;
import pe.j3ml.app.model.PromocionW;


public class PromocionNegocio {

	public void insertarPromocion(String nombre, String fecIni, String fecFin,
			int codpro, double cantidad, double precio) throws DAOExcepcion {

		if (nombre == null || fecIni == null || fecFin == null || codpro == 0
				|| cantidad == 0 || precio == 0) {

			System.out.println("PARAMETROS INVALIDOS");
			throw new DAOExcepcion("PARAMETROS INVALIDOS");
		} else {
			Promocion promocion = new Promocion(nombre, fecIni, fecFin, codpro,	cantidad, precio);
			promocionDAO dao = new promocionDAO();
			try {
				dao.insertar(promocion);
			} catch (DAOExcepcion e) {
				throw new DAOExcepcion("ERROR INSERTAR PROMOCION");
			}
		}
	}
	public void actualizarPromocion(int codigoProducto, double cantidadVendida) throws DAOExcepcion {
        promocionDAO dao = new promocionDAO();
        try {
	dao.actualizar(codigoProducto, cantidadVendida);
        } catch (DAOExcepcion e) {
	throw new DAOExcepcion("ERROR INSERTAR PROMOCION");
        }
}

    public Promocion getInfo(int codigoProducto) throws DAOExcepcion  {
        promocionDAO dao = new promocionDAO();
        try {
	Promocion promocion = dao.getInfo(codigoProducto);
            return promocion;
        } catch (DAOExcepcion e) {
	throw new DAOExcepcion("ERROR INSERTAR PROMOCION");
        }
    }

    public Collection <Promocion> getPromociones()throws DAOExcepcion, ParseException  {
        promocionDAO dao = new promocionDAO();
        int numeroPromos = 0;
        Collection <Promocion> promociones = dao.getPromociones();
        
        String fecha = FechaUtil.getCurrentDate();
        Collection <Promocion> promocionesvalidas = null;
        for (Promocion promo : promociones) {
            if (fecha.compareTo(promo.getFecIni()) >=0 &&
                fecha.compareTo(promo.getFecFin()) <=0 ) {
                if (numeroPromos == 0)
                {
                    promocionesvalidas = new ArrayList<Promocion>();
                }
                numeroPromos++;
                promocionesvalidas.add(promo);
            }
        }
        return promocionesvalidas;
    }

    public PromocionW getPrecio(int codigoProducto, double cantidad) throws DAOExcepcion, ParseException  {
        promocionDAO dao = new promocionDAO();
        try {
            PromocionW promocionW = new PromocionW(codigoProducto,cantidad);
            Promocion promocion = dao.getInfo(codigoProducto);
            String fecha = FechaUtil.getCurrentDate();
            if (fecha.compareTo(promocion.getFecIni()) >=0 &&
                fecha.compareTo(promocion.getFecFin()) <=0 ) {
                if (promocion.getCantidad() != 0.0 &&
                    cantidad != 0.0 &&
                    promocion.getCantidad() <= cantidad)
                {
                    int numeroProductos = (int) (cantidad / promocion.getCantidad());
                    double precioCobrar = numeroProductos * promocion.getPrecio();
                    promocionW.setPrecioCobrar(precioCobrar);
                    promocionW.setCantidadAdd(cantidad % promocion.getCantidad());
                    promocionW.setCantidad(promocion.getCantidad());
                }
            }
            return promocionW;
        } catch (DAOExcepcion e) {
	throw new DAOExcepcion("ERROR INSERTAR PROMOCION");
        }
    }
	
}
