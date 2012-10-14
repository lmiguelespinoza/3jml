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


public class productoDAO extends baseDAO{

    public void insertar(Producto vo) throws DAOExcepcion {
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
    
	public Collection<Producto> listar() throws DAOExcepcion {
		Collection<Producto> c = new ArrayList<Producto>();
		Connection cCon=null;
		PreparedStatement cCom=null;
		ResultSet cRst=null;
		try {
			cCon = ConexionBD.obtenerConexion();
			String cSql="Select a.ProCodigo,a.ProNombre,a.ProUnivta,a.ProPrecio,a.ProStock,IfNull(b.PrmCantidad,0) PrmCantidad,IfNull(b.PrmPrecio,0) PrmPrecio From 3JML.MProducto a Left Join 3JML.MPromocion b On (a.ProCodigo=b.ProCodigo) Order By a.ProNombre";
			cCom=cCon.prepareStatement(cSql);
			cRst=cCom.executeQuery();
			while (cRst.next()) {
				Producto cReg = new Producto();
				cReg.setProCodigo(cRst.getInt("ProCodigo"));
				cReg.setProNombre(cRst.getString("ProNombre"));
				cReg.setProUnivta(cRst.getString("ProUnivta"));
                cReg.setProPrecio(cRst.getDouble("ProPrecio"));
                cReg.setProStock(cRst.getDouble("ProStock"));
                cReg.setPrmCantid(cRst.getDouble("PrmCantidad"));
                cReg.setPrmPrecio(cRst.getDouble("PrmPrecio"));
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

	public Producto obtener(int pProCodigo) throws DAOExcepcion {
		Producto cReg = new Producto();	
		Connection cCon=null;
		PreparedStatement cCom=null;
		ResultSet cRst=null;
		try {
			cCon = ConexionBD.obtenerConexion();
			String cSql="Select a.ProCodigo,a.ProNombre,a.ProUnivta,a.ProPrecio,a.ProStock,IfNull(b.PrmCantidad,0) PrmCantidad,IfNull(b.PrmPrecio,0) PrmPrecio From 3JML.MProducto a Left Join 3JML.MPromocion b On (a.ProCodigo=b.ProCodigo) Where a.ProCodigo=?";
			cCom=cCon.prepareStatement(cSql);
			cCom.setInt(1, pProCodigo);
			cRst=cCom.executeQuery();			  						
			if (cRst.next()) {				
				cReg.setProCodigo(cRst.getInt("ProCodigo"));
				cReg.setProNombre(cRst.getString("ProNombre"));
				cReg.setProUnivta(cRst.getString("ProUnivta"));
                cReg.setProPrecio(cRst.getDouble("ProPrecio"));
                cReg.setProStock(cRst.getDouble("ProStock"));
                cReg.setPrmCantid(cRst.getDouble("PrmCantidad"));
                cReg.setPrmPrecio(cRst.getDouble("PrmPrecio"));
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
