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
	
	public int numeroPedido() throws DAOExcepcion {
		int c = 0;
		Connection cCon=null;
		PreparedStatement cCom=null;
		ResultSet cRst=null;
		try {
			cCon = ConexionBD.obtenerConexion();
			String cSql="Select Max(PedCodigo)+1 PedCodigo From 3JML.MCPedido ";
			cCom=cCon.prepareStatement(cSql);
			cRst=cCom.executeQuery();
			while (cRst.next()) {
				c=cRst.getInt("PedCodigo");
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
	
    public void insertarCPedido(CPedido vo) throws DAOExcepcion {
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
            if (rstCliente != null && rstCliente.next() ) {
            	cCli.setRazonSocial(rstCliente.getString("CliRazonSocial"));
            	cCli.setDireccion(rstCliente.getString("CliDireccion"));
            	cCli.setDistrito(rstCliente.getString("CliDistrito"));
               } else {            	
                throw new DAOExcepcion("CLIENTE NO CREADO");
            }        	        	        	
        	con = ConexionBD.obtenerConexion();
        	String query = "INSERT INTO MCPedido(PedCodigo,UsuNombre,CliRuc,CliRazonSocial,CliDireccion,CliDistrito,PedFecReg,PedFecAte,PedTotal,PedEstado) VALUES (?,?,?,?,?,?,?,?,?,?)";
        	stmt = con.prepareStatement(query);
            stmt.setInt(1, vo.getPedCodigo());
            stmt.setString(2, vo.getUsuNombre());
            stmt.setString(3, vo.getCliRUC());
            stmt.setString(4, cCli.getRazonSocial());
            stmt.setString(5, cCli.getDireccion());
            stmt.setString(6, cCli.getDistrito());
            stmt.setString(7, vo.getPedFecReg());
            stmt.setString(8, "");
            stmt.setDouble(9, vo.getPedTotal());
            stmt.setString(10, "N");
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("Error insertando registro. Consulte DBA!");
             }
        }catch (SQLException e) {
               System.err.println(e.getMessage());
              throw new DAOExcepcion(e.getMessage());
		} finally {
	    	this.cerrarStatement(stmt);
	    	this.cerrarConexion(con);
		}
    }	
    
    public void insertarDPedido(DPedido vo) throws DAOExcepcion {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
        	Producto cPro = new Producto();    
        	cPro.setProCodigo(vo.getProCodigo());
            con = ConexionBD.obtenerConexion();           
            String qProducto= "SELECT ProNombre,ProUnivta FROM MProducto WHERE ProCodigo=?";
            stmt = con.prepareStatement(qProducto);
            stmt.setInt(1, vo.getProCodigo());            
            ResultSet rstProducto;
            rstProducto = stmt.executeQuery();            
            if (rstProducto != null && rstProducto.next()) {
            	cPro.setProNombre(rstProducto.getString("ProNombre"));
            	cPro.setProUnivta(rstProducto.getString("ProUnivta"));
            } else {            	
                throw new DAOExcepcion("PRODUCTO NO CREADO");
            }        	        	        	
        	con = ConexionBD.obtenerConexion();
        	String query = "INSERT INTO MDPedido(PedCodigo,ProCodigo,ProNombre,ProUnivta,PedCantidad,ProPrecio,PedParcial) VALUES (?,?,?,?,?,?,?)";
        	stmt = con.prepareStatement(query);
            stmt.setInt(1, vo.getPedCodigo());
            stmt.setInt(2, vo.getProCodigo());
            stmt.setString(3, cPro.getProNombre());
            stmt.setString(4, cPro.getProUnivta());
            stmt.setDouble(5, vo.getPedCantidad());
            stmt.setDouble(6, vo.getProPrecio());
            stmt.setDouble(7, vo.getPedParcial());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("Error insertando registro. Consulte DBA!");
            }            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
		} finally {
	    	this.cerrarStatement(stmt);
	    	this.cerrarConexion(con);
		}
    }
    
	public Collection<TPedido> listar() throws DAOExcepcion {
		Collection<TPedido> c = new ArrayList<TPedido>();
		Connection cCon=null;
		PreparedStatement cCom=null;
		ResultSet cRst=null;
		try {
			cCon = ConexionBD.obtenerConexion();
			String cSql="Select a.PedCodigo,a.UsuNombre,a.CliRUC,a.CliRazonSocial,a.CliDireccion,a.CliDistrito,a.PedFecReg,a.PedFecAte,a.PedTotal,a.PedEstado,b.ProCodigo,b.ProNombre,b.ProUniVta,b.PedCantidad,b.ProPrecio,b.PedParcial From 3JML.MCPedido a Inner Join 3JML.MDPedido b On (a.PedCodigo=b.PedCodigo) ";
			cCom=cCon.prepareStatement(cSql);
			cRst=cCom.executeQuery();
			while (cRst.next()) {
				TPedido cReg = new TPedido();
				cReg.setPedCodigo(cRst.getInt("PedCodigo"));
				cReg.setUsuNombre(cRst.getString("UsuNombre"));
				cReg.setCliRUC(cRst.getString("CliRUC"));
				cReg.setCliRazonSocial(cRst.getString("CliRazonSocial"));
                cReg.setCliDireccion(cRst.getString("CliDireccion"));
                cReg.setCliDistrito(cRst.getString("CliDistrito"));
                cReg.setPedFecReg(cRst.getString("PedFecReg"));
                cReg.setPedFecAte(cRst.getString("PedFecAte"));
                cReg.setPedTotal(cRst.getDouble("PedTotal"));
                cReg.setPedEstado(cRst.getString("PedEstado"));
				cReg.setProCodigo(cRst.getInt("ProCodigo"));
                cReg.setProNombre(cRst.getString("ProNombre"));		                
                cReg.setProUnivta(cRst.getString("ProUnivta"));
                cReg.setPedCantidad(cRst.getInt("PedCantidad"));
                cReg.setProPrecio(cRst.getDouble("ProPrecio"));
                cReg.setPedParcial(cRst.getDouble("PedParcial"));                          	            	
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
	
	public Collection<TPedido> obtener(int pPedCodigo) throws DAOExcepcion {
		Collection<TPedido> c = new ArrayList<TPedido>();
		Connection cCon=null;
		PreparedStatement cCom=null;
		ResultSet cRst=null;
		try {
			cCon = ConexionBD.obtenerConexion();
			String cSql="Select a.PedCodigo,a.UsuNombre,a.CliRUC,a.CliRazonSocial,a.CliDireccion,a.CliDistrito,a.PedFecReg,a.PedFecAte,a.PedTotal,a.PedEstado,b.ProCodigo,b.ProNombre,b.ProUniVta,b.PedCantidad,b.ProPrecio,b.PedParcial From 3JML.MCPedido a Inner Join 3JML.MDPedido b On (a.PedCodigo=b.PedCodigo)  Where a.PedCodigo=?";
			cCom=cCon.prepareStatement(cSql);
			cCom.setInt(1, pPedCodigo);			
			cRst=cCom.executeQuery();
			while (cRst.next()) {
				TPedido cReg = new TPedido();
				cReg.setPedCodigo(cRst.getInt("PedCodigo"));
				cReg.setUsuNombre(cRst.getString("UsuNombre"));
				cReg.setCliRUC(cRst.getString("CliRUC"));
				cReg.setCliRazonSocial(cRst.getString("CliRazonSocial"));
                cReg.setCliDireccion(cRst.getString("CliDireccion"));
                cReg.setCliDistrito(cRst.getString("CliDistrito"));
                cReg.setPedFecReg(cRst.getString("PedFecReg"));
                cReg.setPedFecAte(cRst.getString("PedFecAte"));
                cReg.setPedTotal(cRst.getDouble("PedTotal"));
                cReg.setPedEstado(cRst.getString("PedEstado"));
				cReg.setProCodigo(cRst.getInt("ProCodigo"));
                cReg.setProNombre(cRst.getString("ProNombre"));		                
                cReg.setProUnivta(cRst.getString("ProUnivta"));
                cReg.setPedCantidad(cRst.getInt("PedCantidad"));
                cReg.setProPrecio(cRst.getDouble("ProPrecio"));
                cReg.setPedParcial(cRst.getDouble("PedParcial"));                          	            	
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

}
