package pe.j3ml.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pe.j3ml.app.excepcion.*;
import pe.j3ml.app.util.*;
import pe.j3ml.app.model.*;


public class productoDAO extends baseDAO{

    public void insertar(Producto vo) throws DAOExcepcion {
        System.out.println("productoDAO: insertar(Producto vo)");
        String query = "INSERT INTO MPRODUCTO(ProNombre, ProUnivta, ProPrecio, ProStock) VALUES (?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            String query2 = "SELECT ProNombre FROM MPRODUCTO WHERE ProNombre= ?";
            stmt = con.prepareStatement(query2);
            stmt.setString(1, vo.getProNombre() );
            ResultSet rs;
            rs = stmt.executeQuery();
            if (rs != null && rs.next() )
            {
                System.out.println("REGISTRO YA EXISTE");
                throw new DAOExcepcion("REGISTRO YA EXISTE");
            } else {
                stmt = con.prepareStatement(query);
                stmt.setString(1, vo.getProNombre());
                stmt.setString(2, vo.getProUnivta());
                stmt.setDouble(3, vo.getProPrecio());
                stmt.setDouble(4, vo.getProStock());
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
