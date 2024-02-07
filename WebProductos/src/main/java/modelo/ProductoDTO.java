package modelo;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import modelo.persistencia.BaseDatos;
import modelo.persistencia.ProductoDAO;

public class ProductoDTO {
	private ProductoDAO producto;
    private BaseDatos bd;
    
	public ProductoDTO(DataSource pDS) throws SQLException{
	   bd = new BaseDatos(pDS);
	   producto = new ProductoDAO(bd);
	}

	public ProductoDAO getProducto() {
	   return producto;
	}

	public void setProducto(ProductoDAO pProd) {
		producto = pProd;
	}

	public BaseDatos getBd() {
		return bd;
	}

	public void setBd(BaseDatos pBd) {
		bd = pBd;
	}	
}
