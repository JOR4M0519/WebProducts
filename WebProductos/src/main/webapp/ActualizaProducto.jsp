<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1 style="text-align: center;">Actualizar Registro</H1>

<form name="form1" method="get" action="ServletCont">
<input type="hidden" name="instruccion" value="actualizarbd">
<input type="hidden" name="cProd" value="${CODART.cArt}">
<table style="width: 400px;">

 <tbody>
 
  <tr>
   <td>SECCI&Oacute;N</td>
   <td><input maxlength="11" size="24" type="text" name="secc" value="${CODART.seccion}"/></td>
  </tr>
 
  <tr>
   <td>NOMBREART&Iacute;CULO</td>
   <td><input maxlength="24" size="24" type="text" name="nomb" value="${CODART.nArt}"/></td>
  </tr>
 
  <tr>
   <td>PRECIO</td>
   <td><input maxlength="10" size="24" type="text" name="prec" value="${CODART.precio}"/></td>
  </tr>
 
  <tr>
   <td>FECHA</td>
   <td><input maxlength="10" size="24" type="text" name="fec" value="${CODART.fecha}"/></td>
  </tr>
 
  <tr>
   <td>IMPORTADO</td>
   <td><input maxlength="9" size="24" type="text" name="impo" value="${CODART.importado}"/></td>
  </tr>
 
  <tr>
   <td>PA&Iacute;SDEORIGEN</td>
   <td><input maxlength="9" size="24" type="text" name="paor" value="${CODART.paisOrig}"/></td>
  </tr>
 
  <tr>
   <td><input type="submit" name="envio" id="envio" value="Enviar" /></td>
   <td><input type="reset" name="borrar" id="borrar" value="Restablecer" /></td>
  </tr>
  
 </tbody>
 
</table>

</form>

</body>
</html>