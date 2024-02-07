package modelo.persistencia;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Producto;

public class ProductoDAO {
   private BaseDatos bd;
   
   public ProductoDAO(BaseDatos pBd) {
	  bd = pBd;
   }
/**
 * <b>Descrición:Lista todos los productos de la tabla	
 */
   public ArrayList<Producto> verListado() throws SQLException{
	  ArrayList<Producto> productos = new ArrayList<>();
	  try { 
         productos = bd.listar();  
         return productos;
	  } catch (SQLException ex) {
		 ex.printStackTrace();
		 return productos;
	  } 
   }
   
   public void agregarProducto(Producto pProd) throws SQLException{
	  try{ 
	     bd.agregar(pProd);  
	  } catch (SQLException ex) {
	     ex.printStackTrace();
	  } 
   }
   
   public Producto getProducto(String codart) throws SQLException{
	  Producto p = null;
	  try{ 
		 p = bd.leer(codart);  
	  } catch (SQLException ex) {
		 ex.printStackTrace();
	  } finally {
		 return p;
	  } 
   }
   
   public void actualizarProducto(Producto pProd) throws SQLException{
	  try{ 
		 bd.actualizar(pProd);  
	  } catch (SQLException ex) {
		 ex.printStackTrace();
	  }
   }
   
   public void eliminarProducto(String codart) throws SQLException{
	  try{ 
		 bd.eliminar(codart);  
	  } catch (SQLException ex) {
		 ex.printStackTrace();
	  }	  
   }
}
