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

public class pedidoDAO extends baseDAO {
    public void insertar(CPedido vo) throws DAOExcepcion {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
        	Cliente cCli = new Cliente();    
        	cCli.setRuc(vo.getCliRUC());
            con = ConexionBD.obtenerConexion();           
            String qCliente= "SELECT CliRazonSocial,CliDireccion,CliDistrito FROM MCliente WHERE CliRUC=?";
            stmt = con.prepareStatement(qCliente);
            stmt.setString(1, vo.getCliRUC());            
            ResultSet rstCliente;
            rstCliente = stmt.executeQuery();            
            if (rstCliente != null && rstCliente.next() )
            {
            	cCli.setRazonSocial(rstCliente.getString("CliRazonSocial"));
            	cCli.setDireccion(rstCliente.getString("CliDireccion"));
            	cCli.setDistrito(rstCliente.getString("CliDistrito"));
            } else {            	
                throw new DAOExcepcion("CLIENTE NO CREADO");
            }        	        	        	
        	con = ConexionBD.obtenerConexion();
        	String query = "INSERT INTO MCPedido(CliRuc,CliRazonSocial,CliDireccion,CliDistrito,PedFecReg,PedFecAte,PedTotal,PedEstado) VALUES (?,?,?,?,?,?,?,?)";
        	stmt = con.prepareStatement(query);
            stmt.setString(1, vo.getCliRUC());
            stmt.setString(2, cCli.getRazonSocial());
            stmt.setString(3, cCli.getDireccion());
            stmt.setString(4, cCli.getDistrito());
            stmt.setString(5, vo.getPedFecReg());
            stmt.setString(6, "");
            stmt.setDouble(7, vo.getPedTotal());
            stmt.setString(8, "N");
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("Error insertando registro. Consulte DBA!");
            }            
            con = ConexionBD.obtenerConexion();
            String query2 = "SELECT PedCodigo FROM MCPedido WHERE PedEstado='N' And CliRUC=?";
            stmt = con.prepareStatement(query2);            
            stmt.setString(1, cCli.getRuc());
            ResultSet rs;
            rs = stmt.executeQuery();
            if (rs != null && rs.next() )
            {
            	CPedido cReg = new CPedido();
            	cReg.setPedCodigo(rs.getInt("PedCodigo"));
            	String query3 = "INSERT INTO MDPedido(PedCodigo,ProCodigo,PedCantidad,ProPrecio,PedParcial) VALUES (?,?,?,?,?)";            	            	
                stmt = con.prepareStatement(query3);
                stmt.setInt(1, cReg.getPedCodigo());
                stmt.setInt(2, vo.getDpedido().getProCodigo());
                stmt.setInt(3, vo.getDpedido().getPedCantidad());
                stmt.setDouble(4, vo.getDpedido().getProPrecio());
                stmt.setDouble(5, vo.getDpedido().getPedParcial());
                int ii = stmt.executeUpdate();
                if (ii != 1) {
                    throw new SQLException("Error insertando registro. Consulte DBA!");
                }            	
            } else {
                System.out.println("PEDIDO NO CREADO");
                throw new DAOExcepcion("PEDIDO NO CREADO");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
		} finally {
	    	this.cerrarStatement(stmt);
	    	this.cerrarConexion(con);
		}
    }	
    
	public Collection<CPedido> listar() throws DAOExcepcion {
		Collection<CPedido> c = new ArrayList<CPedido>();
		Connection cCon=null;
		PreparedStatement cCom=null;
		ResultSet cRst=null;
		try {
			cCon = ConexionBD.obtenerConexion();
			String cSql="Select a.PedCodigo,a.CliRUC,a.CliRazonSocial,a.CliDireccion,a.CliDistrito,a.PedFecReg,a.PedFecAte,a.PedTotal,a.PedEstado,b.ProCodigo,c.ProNombre,c.ProUniVta,b.PedCantidad,b.ProPrecio,b.PedParcial From 3JML.MCPedido a Inner Join 3JML.MDPedido b On (a.PedCodigo=b.PedCodigo) Inner Join 3JML.MProducto c On (b.ProCodigo=c.ProCodigo)";
			cCom=cCon.prepareStatement(cSql);
			cRst=cCom.executeQuery();
			while (cRst.next()) {
				CPedido cReg = new CPedido();
				cReg.setPedCodigo(cRst.getInt("PedCodigo"));
				cReg.setCliRUC(cRst.getString("CliRUC"));
				cReg.setCliRazonSocial(cRst.getString("CliRazonSocial"));
                cReg.setCliDireccion(cRst.getString("CliDireccion"));
                cReg.setCliDistrito(cRst.getString("CliDistrito"));
                cReg.setPedFecReg(cRst.getString("PedFecReg"));
                cReg.setPedFecAte(cRst.getString("PedFecAte"));
                cReg.setPedTotal(cRst.getDouble("PedTotal"));
                cReg.setPedEstado(cRst.getString("PedEstado"));            	
				c.add(cReg);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(cRst);
			this.cerrarStatement(cCom);
			this.cerrarConexion(cCon);
		}
		return c;
	}    

	public CPedido obtener(int pPedCodigo) throws DAOExcepcion {
		CPedido cReg = new CPedido();	
		return cReg;
	}
	
}
