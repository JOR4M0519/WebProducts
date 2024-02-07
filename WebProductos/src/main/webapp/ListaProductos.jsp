<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.cabecera{
   font-size:1.2em;
   font-weight:bold;
   color:#FFFFFF;
   background-color:#08088A;
}
.filas{
   text-align:center;
   background-color:#5882FA;
}
table{
   float:left;
}
#botones{
   margin-left:700px;
}
</style>
</head>
<body>
  <table>
  <tr>
  <td class="cabecera">Código</td>
  <td class="cabecera">Sección</td>
  <td class="cabecera">Nombre Artículo</td>
  <td class="cabecera">Precio</td>
  <td class="cabecera">Fecha</td>
  <td class="cabecera">Importado</td>
  <td class="cabecera">País de Origen</td>
  <td class="cabecera">Acción</td>
  </tr>
  <c:forEach var="prod" items="${listaproductos}">
  <c:url var="enlaceU" value="ServletCont">
    <c:param name="instruccion" value="cargar"></c:param>
    <c:param name="codart" value="${prod.cArt}"></c:param>
  </c:url>
    <c:url var="enlaceD" value="ServletCont">
    <c:param name="instruccion" value="eliminar"></c:param>
    <c:param name="codart" value="${prod.cArt}"></c:param>
  </c:url>
  <tr>
  <td class="filas">${prod.cArt}</td>
  <td class="filas">${prod.seccion}</td>
  <td class="filas">${prod.nArt}</td>
  <td class="filas">${prod.precio}</td>
  <td class="filas">${prod.fecha}</td>
  <td class="filas">${prod.importado}</td>
  <td class="filas">${prod.paisOrig}</td>
  <td class="filas"><a href="${enlaceU}">Modificar</a>&nbsp;<a href="${enlaceD}">Eliminar</a></td>
  </tr>
  </c:forEach>
  </table>
  <div id="botones">
     <input type="button" value="Insertar" onclick="window.location.href='InsertaProducto.jsp'">
  </div>
</body>
</html>