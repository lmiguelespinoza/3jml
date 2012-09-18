package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import excepcion.*;
import modelo.*;
import util.*;
public class clienteDAO extends baseDAO  {
    public void insertar(Cliente vo) throws DAOExcepcion {
        System.out.println("clienteDAO: insertar(Cliente vo)");
	String query = "INSERT INTO Cliente(ruc,razonsocial,direccion,distrito,telefono,correo,contacto) VALUES (?,?,?,?,?,?,?)";
	Connection con = null;
	PreparedStatement stmt = null;
	try {
            con = ConexionBD.obtenerConexion();

            String query2 = "select razonsocial from Cliente where ruc = ?";
            stmt = con.prepareStatement(query2);
            stmt.setString(1, vo.getRuc() );
            ResultSet rs;
            rs = stmt.executeQuery();
            if (rs != null && rs.next() )
            {
                System.out.println("REGISTRO YA EXISTE");
                throw new DAOExcepcion("REGISTRO YA EXISTE");
	    }
	    else
	    {
                stmt = con.prepareStatement(query);
		stmt.setString(1, vo.getRuc());
                stmt.setString(2, vo.getRazonSocial());
                stmt.setString(3, vo.getDireccion());
                stmt.setString(4, vo.getDistrito());
                stmt.setString(5, vo.getTelefono());
                stmt.setString(6, vo.getCorreo());
                stmt.setString(7, vo.getContacto());

                int i = stmt.executeUpdate();
                if (i != 1) {
                    throw new SQLException("Error insertando registro. !Consulte DBA");
		}
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
	}    finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
	}
    }

    public Cliente buscar(String ruc) throws DAOExcepcion {
        Cliente vo = new Cliente(ruc);
        System.out.println("clienteDAO: buscar(Cliente vo)");
	String query = "select razonsocial,direccion,distrito,telefono,correo,contacto from Cliente where ruc = ?";
	Connection con = null;
	PreparedStatement stmt = null;
	try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, ruc );
            ResultSet rs;
            rs = stmt.executeQuery();
            if (rs != null && rs.next() )
            {
                vo.setRazonSocial(rs.getString(1));
                vo.setDireccion(rs.getString(2));
                vo.setDistrito(rs.getString(3));
                vo.setTelefono(rs.getString(4));
                vo.setCorreo(rs.getString(5));
                vo.setContacto(rs.getString(6));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
	}    finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
	}
        return vo;
    }

}
