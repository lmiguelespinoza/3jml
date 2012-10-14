package pe.j3ml.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pe.j3ml.app.excepcion.*;
import pe.j3ml.app.util.*;
import pe.j3ml.app.model.*;

public class clienteDAO extends baseDAO  {
	
    public void insertar(Cliente vo) throws DAOExcepcion {
        System.out.println("clienteDAO: insertar(Cliente vo)");
        String query = "INSERT INTO mcliente(CliRuc, CliRazonsocial, CliDireccion, CliDistrito, CliTelefono, CliCorreo, CliContacto, CliEstado) VALUES (?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            String query2 = "SELECT CliRazonsocial from mcliente where CliRuc = ?";
            stmt = con.prepareStatement(query2);
            stmt.setString(1, vo.getRuc() );
            ResultSet rs;
            rs = stmt.executeQuery();
            if (rs != null && rs.next() )
            {
                System.out.println("REGISTRO YA EXISTE");
                throw new DAOExcepcion("REGISTRO YA EXISTE");
            } else {
                stmt = con.prepareStatement(query);
                stmt.setString(1, vo.getRuc());
                stmt.setString(2, vo.getRazonSocial());
                stmt.setString(3, vo.getDireccion());
                stmt.setString(4, vo.getDistrito());
                stmt.setString(5, vo.getTelefono());
                stmt.setString(6, vo.getCorreo());
                stmt.setString(7, vo.getContacto());
                stmt.setString(8, "Activo");
                
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
    
    public Cliente obtenerCliente(String pRuc) throws DAOExcepcion {
		Cliente cReg = new Cliente();	
		Connection cCon=null;
		PreparedStatement cCom=null;
		ResultSet cRst=null;
		try {
			cCon = ConexionBD.obtenerConexion();
			String cSql="SELECT CliRUC,  CliRazonSocial, CliEstado FROM mCliente WHERE CliEstado = 'Activo' AND CliRUC = ?";
			cCom=cCon.prepareStatement(cSql);
			cCom.setString(1, pRuc);
			cRst=cCom.executeQuery();			  						
			if (cRst.next()) {				
				cReg.setRuc(cRst.getString("CliRUC"));
				cReg.setRazonSocial(cRst.getString("CliRazonSocial"));
				cReg.setEstado(cRst.getString("CliEstado"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(cRst);
			this.cerrarStatement(cCom);
			this.cerrarConexion(cCon);
		}
		return cReg;
	}

}
