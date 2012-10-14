package pe.j3ml.app.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import pe.j3ml.app.excepcion.*;
import pe.j3ml.app.util.*;
import pe.j3ml.app.model.*;


public class promocionDAO  extends baseDAO  {
	
	 public void insertar(Promocion vo) throws DAOExcepcion {
	        System.out.println("promocionDAO: insertar(Promocion vo)");
	        String query = "INSERT INTO mpromocion (PrmNombre, PrmFecIni, PrmFecFin, ProCodigo, PrmCantidad,PrmPrecio) VALUES (?,?,?,?,?,?)";

	        Connection con = null;
	        PreparedStatement stmt = null;
	        try {
	            con = ConexionBD.obtenerConexion();
	            String query2 = "select PrmNombre from mpromocion where PrmNombre = ?";
	            stmt = con.prepareStatement(query2);
	            stmt.setString(1,vo.getFecFin());
	            		
	            ResultSet rs;
	            rs = stmt.executeQuery();
	            if (rs != null && rs.next() )
	            {
	                System.out.println("REGISTRO YA EXISTE");
	                throw new DAOExcepcion("REGISTRO YA EXISTE");
	            } else {
	                stmt = con.prepareStatement(query);
	                stmt.setString(1, vo.getNombre());         		
                    stmt.setString(2, vo.getFecIni());
	                stmt.setString(3, vo.getFecFin());
	                                		
	                stmt.setInt(4, vo.getCodprod());
	                
	                stmt.setDouble(5, vo.getCantidad());
	                
	                stmt.setDouble(6, vo.getPrecio());
	                		
	                int i = stmt.executeUpdate();
	                if (i != 1) {
	                    throw new SQLException("Error insertando registro. Consulte DBA!");
	                }
	            }
	        } catch (SQLException e) {
	            System.err.println(e.getMessage());
	            throw new DAOExcepcion(e.getMessage());
			} finally {
		    	this.cerrarStatement(stmt);
		    	this.cerrarConexion(con);
			}
	    }

       public void actualizar(int codigoProducto, double cantidadVendida) throws DAOExcepcion {
            Promocion promocion = getInfo(codigoProducto);
            System.out.println("promocionDAO: actualizar(codigoProducto, cantidadVendida)");
            String query = "UPDATE MPromocion" + " set PrmCantidad = ? WHERE ProCodigo = ?";
            Connection con = null;
            PreparedStatement stmt = null;
            try {
                con = ConexionBD.obtenerConexion();
                if (promocion.getCantidad()  > cantidadVendida)
                {
                    throw new SQLException("Error actualizado registro promociones. Total de vendidos excede a la cantidad asignada para promocion");
                }
                stmt = con.prepareStatement(query);
                stmt.setDouble(1, promocion.getCantidad() - cantidadVendida);
                stmt.setInt(2, codigoProducto);
                int i = stmt.executeUpdate();
                if (i != 1)
                {
                    throw new SQLException("Error actualizado registro kardex. Consulte DBA!");
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                throw new DAOExcepcion(e.getMessage());
            } finally {
	    	this.cerrarStatement(stmt);
	    	this.cerrarConexion(con);
            }
     }

     public Promocion getInfo(int codigoProducto)  throws DAOExcepcion {
            System.out.println("promocionDAO: getInfo(int codigoProducto)");
            String query = "SELECT PrmNombre, PrmFecini, PrmFecfin, PrmCantidad, PrmPrecio FROM MPromocion WHERE ProCodigo = ?";

            Connection con = null;
            PreparedStatement stmt = null;
            try {
                con = ConexionBD.obtenerConexion();
                stmt = con.prepareStatement(query);
                stmt.setInt(1, codigoProducto);
                ResultSet rs2 = stmt.executeQuery();
                if (rs2.next()) {
                    Promocion promocion = new Promocion();
                    promocion.setNombre(rs2.getString(1));
                    promocion.setFecIni(rs2.getString(2));
                    promocion.setFecFin(rs2.getString(3));
                    promocion.setCantidad(rs2.getDouble(4));
                    promocion.setPrecio(rs2.getDouble(5));
                    promocion.setCodprod(codigoProducto);
                    return promocion;
                }
                throw new SQLException("Error procesando promociones o codigo no existe. Consulte DBA!");
            } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
		} finally {
	    	this.cerrarStatement(stmt);
	    	this.cerrarConexion(con);
		}
	    }

     public Collection <Promocion> getPromociones()  throws DAOExcepcion {
            System.out.println("promocionDAO: getPromociones()");
            String query = "SELECT PrmNombre, PrmFecini, PrmFecfin,  PrmCantidad, PrmPrecio, ProCodigo FROM MPromocion";

            Connection con = null;
            PreparedStatement stmt = null;
            try {
                con = ConexionBD.obtenerConexion();
                stmt = con.prepareStatement(query);
                ResultSet rs2 = stmt.executeQuery();
                if (rs2.next()) {
                    Collection<Promocion> lista = new ArrayList<Promocion>();
                    do {
                        Promocion promocion = new Promocion();
                        promocion.setNombre(rs2.getString(1));
                        promocion.setFecIni(rs2.getString(2));
                        promocion.setFecFin(rs2.getString(3));
                        promocion.setCantidad(rs2.getDouble(4));
                        promocion.setPrecio(rs2.getDouble(5));
                        promocion.setCodprod(rs2.getInt(6));
                        lista.add(promocion);
                    } while (rs2.next());
                    return lista;
                }
                throw new SQLException("Error procesando promociones o no existe promociones. Consulte DBA!");
            } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
		} finally {
	    	this.cerrarStatement(stmt);
	    	this.cerrarConexion(con);
		}
	    }
}
