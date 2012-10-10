package pe.j3ml.app.dao;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import pe.j3ml.app.excepcion.*;
import pe.j3ml.app.util.*;
import pe.j3ml.app.model.*;


public class kardexDAO extends baseDAO{

    public void upd(int proCodigo, double KrdTotalPedidos, String fecha) throws DAOExcepcion {
        System.out.println("kardexDAO: upd(Kardex vo)");
        Kardex kardex = getInfo(proCodigo);
        
        //String query = "UPDATE mKARDEX.KrdTotalPedidos, KrdFechaHoraUltimoPedido) VALUES (?,?) WHERE ProCodigo = ?";
        String query = "UPDATE mKARDEX" + " set KrdTotalPedidos = ?,KrdFechaHoraUltimoPedido = ? WHERE ProCodigo = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            if (kardex.getKrdTotalPedidos() + KrdTotalPedidos > kardex.getKrdCantidadReal())
            {
            	throw new SQLException("Error actualizado registro kardex. Total de pedidos excede a la cantidad real");
            }
            stmt = con.prepareStatement(query);
            stmt.setDouble(1, kardex.getKrdTotalPedidos() + KrdTotalPedidos);
            stmt.setString(2, fecha );
            stmt.setInt(3, proCodigo );
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
	
    public void update(Kardex	 vo) throws DAOExcepcion {
        System.out.println("kardexDAO: insertar(Kardex vo)");
        String query = "UPDATE INTO mKARDEX(KrdTotalPedidos, KrdFechaHoraUltimoPedido) VALUES (?,?) WHERE ProCodigo = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            
			{
                stmt = con.prepareStatement(query);
                stmt.setDouble(1, vo.getKrdTotalPedidos());
                stmt.setString(2, vo.getKrdFechaHoraUltimoPedido());
                stmt.setInt(3, vo.getProCodigo());
                int i = stmt.executeUpdate();
                if (i != 1) 
				{
                    throw new SQLException("Error actualizado registro kardex. Consulte DBA!");
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

    public Kardex getInfo(int proCodigo) throws DAOExcepcion {
    	
    	System.out.println("kardexDAO: getInfo(int proCodigo)");
        String query = "SELECT KrdCantidadReal, KrdTotalPedidos,KrdFechaHoraUltimoPedido FROM mKardex WHERE proCodigo = ?";
        
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            
			{
                stmt = con.prepareStatement(query);
                stmt.setInt(1, proCodigo);
                ResultSet rs2 = stmt.executeQuery();
                if (rs2.next()) 
				{
                	Kardex kardex = new Kardex();
                	kardex.setProCodigo(proCodigo);
                    kardex.setKrdCantidadReal(rs2.getDouble(1));
                    kardex.setKrdTotalPedidos(rs2.getDouble(2));
                    kardex.setKrdFechaHoraUltimoPedido(rs2.getString(3));
                    return kardex;
                }
                throw new SQLException("Error procesando registro kardex o codigo no existe. Consulte DBA!");
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
