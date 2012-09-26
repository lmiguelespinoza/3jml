package pe.j3ml.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pe.j3ml.app.excepcion.*;
import pe.j3ml.app.util.*;
import pe.j3ml.app.model.*;


public class promocionDAO  extends baseDAO  {
	
	 public void insertar(Promocion vo) throws DAOExcepcion {
	        System.out.println("promocionDAO: insertar(Promocion vo)");
	        String query = "INSERT INTO mpromocion(PrmNombre, PrmFecIni, PrmFecFin, ProdCodigo, PrmCantidad,PrmPrecio) VALUES (?,?,?,?,?,?)";

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

}
