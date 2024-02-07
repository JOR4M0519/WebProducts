package modelo.persistencia;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;
import modelo.Producto;

public class BaseDatos {
   
   private DataSource datos;
   
   public BaseDatos(DataSource pDatos) {
	  datos = pDatos;
   }
   
   public ArrayList<Producto> listar() throws SQLException{
	  ArrayList<Producto> productos = new ArrayList<>();
	  Connection conexion = null;
	  Statement st = null;
	  ResultSet rs = null;
	  try {
		 conexion = datos.getConnection();
		 st = conexion.createStatement();
		 String isql = "SELECT * FROM PRODUCTOS";
		 rs = st.executeQuery(isql);
	     while (rs.next()) {
		    String cart = rs.getString(1);
			String secc = rs.getString(2);
			String nomb = rs.getString(3);
			double prec = rs.getDouble(4);
			Date fec = rs.getDate(5);
			String impo = rs.getString(6);
			String paor = rs.getString(7);
			Producto prod = new Producto(cart,secc,nomb,prec,fec,impo,paor);
			productos.add(prod);
		 }
	  } catch (SQLException ex) {
		  ex.printStackTrace();
	  } catch (Exception ex) {
		  ex.printStackTrace();
	  } finally {
		  st.close();
	 	  conexion.close();
	 	  return productos;
	  }
   }
   
   public void agregar(Producto pPro) throws SQLException{
	  Connection conexion = null;
	  PreparedStatement ps = null;
	  try {
		 conexion=datos.getConnection(); 
	     String isql = "INSERT INTO PRODUCTOS (CODIGO,SECCION,NOMBRE,PRECIO,FECHA,IMPORTADO,PAIS) "+
	                   "VALUES(?,?,?,?,?,?,?)";
	     ps = conexion.prepareStatement(isql);
	     ps.setString(1,pPro.getcArt());
	     ps.setString(2,pPro.getSeccion());
	     ps.setString(3,pPro.getnArt());
	     ps.setDouble(4,pPro.getPrecio());
	     java.util.Date ufec=pPro.getFecha();
	     java.sql.Date sqlfec= new java.sql.Date(ufec.getTime());
	     ps.setDate(5,sqlfec);
	     ps.setString(6,pPro.getImportado());
	     ps.setString(7,pPro.getPaisOrig());
	     ps.execute();
	  }catch(SQLException ex) {
	     ex.printStackTrace();
      }catch(Exception ex) {
    	 ex.printStackTrace();
      }finally {
 		 ps.close();
 		 conexion.close();
 	  }
   }

   public Producto leer(String codart) throws SQLException {
	  Producto p = null;
	  Connection conexion = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  String cod = codart;
	  try {
		 conexion=datos.getConnection(); 
	     String isql = "SELECT * FROM PRODUCTOS WHERE CODIGO=?";
	     ps = conexion.prepareStatement(isql);
	     ps.setString(1,cod);
	     rs = ps.executeQuery();
	     if(rs.next()) {
	    	String codi = rs.getString(1);
			String secc = rs.getString(2);
			String nomb = rs.getString(3);
		    double prec = rs.getDouble(4);
			Date fec = rs.getDate(5);
			String impo = rs.getString(6);
			String paor = rs.getString(7);
			p = new Producto(codi,secc,nomb,prec,fec,impo,paor);
	     } else {
	    	throw new Exception("No se encontro producto "+cod);
	     }
	  } catch(SQLException ex) {
		 ex.printStackTrace();
      } catch(Exception ex) {
    	 ex.printStackTrace();
      } finally {
  		 ps.close();
  		 conexion.close();
  		 return p;
  	  }
   }

   public void actualizar(Producto pPro) throws SQLException{
	  Connection conexion = null;
	  PreparedStatement ps = null;
	  try {
	     conexion=datos.getConnection(); 
		 String isql = "UPDATE PRODUCTOS SET SECCION=?, NOMBRE=?, PRECIO=?, "+
		               "FECHA=?, IMPORTADO=?, PAIS=? WHERE CODIGO=?";
		 ps = conexion.prepareStatement(isql);
		 ps.setString(1,pPro.getSeccion());
		 ps.setString(2,pPro.getnArt());
		 ps.setDouble(3,pPro.getPrecio());
		 java.util.Date ufec=pPro.getFecha();
		 java.sql.Date sqlfec= new java.sql.Date(ufec.getTime());
		 ps.setDate(4,sqlfec);
		 ps.setString(5,pPro.getImportado());
		 ps.setString(6,pPro.getPaisOrig());
		 ps.setString(7,pPro.getcArt());
		 ps.execute();
	  }catch(SQLException ex) {
		 ex.printStackTrace();
	  }catch(Exception ex) {
	     ex.printStackTrace();
	  }finally {
		 ps.close();
		 conexion.close();
	  }	
   }

   public void eliminar(String codart) throws SQLException{
	  Connection conexion = null;
	  PreparedStatement ps = null;
	  try {
		 conexion=datos.getConnection(); 
		 String isql = "DELETE FROM PRODUCTOS WHERE CODIGO=?";
		 ps = conexion.prepareStatement(isql);
		 ps.setString(1,codart);
		 ps.execute();
	  }catch(SQLException ex) {
		 ex.printStackTrace();
	  }catch(Exception ex) {
		 ex.printStackTrace();
	  } finally {
		 ps.close();
		 conexion.close();
	  }
   }   
}
