package pe.j3ml.app.dao;
/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import pe.j3ml.app.excepcion.*;
import pe.j3ml.app.util.*;
import pe.j3ml.app.model.*;
*/
public class pedidoDAO extends baseDAO {
/*
    public void insertar(CPedido vo) throws DAOExcepcion {
        System.out.println("pedidoDAO: insertar(Pediddo vo)");
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
			String cSql="Select ProNombre, ProUnivta, ProPrecio, ProStock From MPRODUCTO Order By 1";
			cCom=cCon.prepareStatement(cSql);
			cRst=cCom.executeQuery();
			while (cRst.next()) {
				Producto cReg = new Producto();
				cReg.setProNombre(cRst.getString("ProNombre"));
				cReg.setProUnivta(cRst.getString("ProUnivta"));
                cReg.setProPrecio(cRst.getDouble("ProPrecio"));
                cReg.setProStock(cRst.getDouble("ProStock"));
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
	 */
}
