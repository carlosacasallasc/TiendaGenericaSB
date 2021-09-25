<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="
    java.io.*,
    java.util.*,
    com.BO.TiendaVirtualSB.*,
    com.DTO.TiendaVirtualSB.*
    "
    
    
    %>
<!DOCTYPE html>
<html>

<%
UsuarioController cc=new UsuarioController();
ClienteDTO cli=new ClienteDTO();

Long cedula=Long.parseLong(request.getParameter("Cedula")); /*mismo "name" del html*/
cli.setCedulaCliente(cedula);

cli.setNombreCliente(request.getParameter("Nombre"));


cli.setEmailCliente(request.getParameter("Correo"));

cli.setTelefonoCliente(request.getParameter("Telefono"));

cli.setDireccionCliente(request.getParameter("direccion"));

cc.crearCliente(cli);

%>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>