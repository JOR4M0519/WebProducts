package modelo;

import java.util.Date;

public class Producto {

	private String cArt;
	private String seccion;
	private String nArt;
	private double precio;
	private Date fecha;
	private String importado;
	private String paisOrig;
	
	public Producto(String pCA,String pSec,String pNA,double pPr,Date pF,String pIm,String pPO) {
		cArt = pCA;
		seccion = pSec;
		nArt = pNA;
		precio = pPr;
		fecha = pF;
		importado = pIm;
		paisOrig = pPO;
	}

	public Producto(String pSec,String pNA,double pPr,Date pF,String pIm,String pPO) {
		seccion = pSec;
		nArt = pNA;
		precio = pPr;
		fecha = pF;
		importado = pIm;
		paisOrig = pPO;
	}

	public String getcArt() {
		return cArt;
	}

	public void setcArt(String cArt) {
		this.cArt = cArt;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getnArt() {
		return nArt;
	}

	public void setnArt(String nArt) {
		this.nArt = nArt;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getPaisOrig() {
		return paisOrig;
	}

	public void setPaisOrig(String paisOrig) {
		this.paisOrig = paisOrig;
	}

	@Override
	public String toString() {
		return "Productos [cArt=" + cArt + ", seccion=" + seccion + ", nArt=" + nArt + ", precio=" + precio + ", fecha="
				+ fecha + ", importado=" + importado + ", paisOrig=" + paisOrig + "]";
	}
}
