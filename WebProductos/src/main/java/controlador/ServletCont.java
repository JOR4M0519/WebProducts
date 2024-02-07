package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
import modelo.Producto;
import modelo.ProductoDTO;
import modelo.persistencia.ProductoDAO;

/**
 * Servlet implementation class ServletCont
 */
@WebServlet("/ServletCont")
public class ServletCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDTO lista;
    //Establecer el DataSource
	@Resource(name="jdbc/Productos")
	private DataSource pc;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
		   lista = new ProductoDTO(pc);
		}catch(Exception e) {
		   throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//leer parámetro del formulario
		String com = request.getParameter("instruccion");
		//Si no se envía el parámetro, entonces listar productos
		if(com == null) com = "listar";
		//redirigir el flujo de ejecución
		switch(com) {
		case "listar":
			obtenerProductos(request, response);
			break;
		case "insertarbd":
			agregarProducto(request,response);
			break;
		case "cargar":
			try {
				cargaProducto(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "actualizarbd":
			try {
			   actualizaProducto(request,response);
			} catch (Exception e) {
			   e.printStackTrace();
			}
			break;
		case "eliminar":
			try {
				eliminarProducto(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			obtenerProductos(request, response);
		}
	}

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
       String codart = request.getParameter("codart");
       lista.getProducto().eliminarProducto(codart);
       obtenerProductos(request, response);
	}

	private void actualizaProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
	   //Leer la información que viene del formulario
	   String cart = request.getParameter("cProd");
	   String secc = request.getParameter("secc");
	   String nomb = request.getParameter("nomb");
	   double prec = Double.parseDouble(request.getParameter("prec"));
	   SimpleDateFormat ffec = new SimpleDateFormat("yyyy-MM-dd");
	   Date fec = null;
	   try {
		  fec = ffec.parse(request.getParameter("fec"));
		  String impo = request.getParameter("impo");
		  String paor = request.getParameter("paor");   
	   //Crear un objeto de tipo producto
		  Producto nprod = new Producto(cart,secc,nomb,prec,fec,impo,paor);	
	   //Enviar el objeto al modelo y actualizarlo en la bd
		  lista.getProducto().actualizarProducto(nprod);
	   //Volver al listado de productos
		  obtenerProductos(request, response);
		} catch(ParseException e) {
		   e.printStackTrace();
		} catch(Exception e) {
		   e.printStackTrace();
		}
    }

	private void cargaProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
	   String codart = request.getParameter("codart");
	   Producto prod = lista.getProducto().getProducto(codart);
	   request.setAttribute("CODART", prod);
	   RequestDispatcher rd = request.getRequestDispatcher("/ActualizaProducto.jsp");
	   rd.forward(request, response);	
	}

	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		//Leer la información que viene del formulario
		String cart = request.getParameter("cart");
		String secc = request.getParameter("secc");
		String nomb = request.getParameter("nomb");
		double prec = Double.parseDouble(request.getParameter("prec"));
		SimpleDateFormat ffec = new SimpleDateFormat("yyyy-MM-dd");
		Date fec = null;
		try {
		   fec = ffec.parse(request.getParameter("fec"));
		   String impo = request.getParameter("impo");
		   String paor = request.getParameter("paor");
		//Crear un objeto de tipo producto
		   Producto nprod = new Producto(cart,secc,nomb,prec,fec,impo,paor);
		//Enviar el objeto al modelo e insertarlo en la bd
		   lista.getProducto().agregarProducto(nprod);
		//Volver al listado de productos
		   obtenerProductos(request, response);
		} catch(ParseException e) {
		   e.printStackTrace();
		} catch(Exception e) {
		   e.printStackTrace();
		}
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//obtener la lista de productos desde el modelo
		ArrayList<Producto> productos;
		try {
		   productos = lista.getProducto().verListado();
		   if(productos == null || productos.size() == 0)
			 System.out.println("ArrayList vacío");
		//agregar la lista de productos al request
		   request.setAttribute("listaproductos", productos);
		//enviar request al JSP
		   RequestDispatcher rd =request.getRequestDispatcher("/ListaProductos.jsp");
		   rd.forward(request, response);
		}catch(Exception e) {
		   e.printStackTrace();
		}
	}
}
