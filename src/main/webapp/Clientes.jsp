<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="
    java.io.*,
    java.util.*,
    com.BO.TiendaVirtualSB.*,
    com.DTO.TiendaVirtualSB.*
    "%>
<!DOCTYPE html>
<html lang="es">
<meta charset="ISO-8859-1">


<%
ClienteController uc = new ClienteController();
ClienteDTO objCliente = new ClienteDTO();
ClienteDTO rta = new ClienteDTO();

long cedulaLong = Long.parseLong(request.getParameter("Cedula"));

objCliente.setCedulaCliente(cedulaLong);
objCliente.setNombreCliente(request.getParameter("Nombre"));
objCliente.setEmailCliente(request.getParameter("Correo"));
objCliente.setTelefonoCliente(request.getParameter("Telefono"));
objCliente.setDireccionCliente(request.getParameter("direccion"));

/*Variable par almacenar la opción seleccionada en el formulario*/
String opcion = request.getParameter("cliente");

if (Integer.parseInt(opcion) == 1) {

	rta = uc.consultarCliente(cedulaLong);
	
	if (rta.getCedulaCliente() == null) {
%>
<script type="text/javascript">
	alert('El cliente consultado no existe');
	window.location.href = "Clientes.html";
</script>
<%
}
}

if (Integer.parseInt(opcion) == 2) {

	rta = uc.consultarCliente(cedulaLong);
	
if (rta.getCedulaCliente() == null) {
uc.crearCliente(objCliente);
%>
<script type="text/javascript">
	alert('Cliente Creado');
	window.location.href = "Clientes.html";
</script>
<%
} else {
%>
<script type="text/javascript">
	alert('El cliente que intenta crear ya existe');
	window.location.href = "Clientes.html";
</script>
<%
}
}

if (Integer.parseInt(opcion) == 3) {

	rta = uc.consultarCliente(cedulaLong);
	
if (rta.getCedulaCliente() == null) {
%>
<script type="text/javascript">
	alert('El cliente que intenta actualizar no existe');
	window.location.href = "Clientes.html";
</script>
<%
} else {
uc.modificarCliente(objCliente);
%>
<script type="text/javascript">
	alert('Datos del Cliente Actualizados');
	window.location.href = "Clientes.html";
</script>
<%
}

}

if (Integer.parseInt(opcion) == 4) {

	rta = uc.consultarCliente(cedulaLong);
	
if (rta.getCedulaCliente() == null) {
%>
<script type="text/javascript">
	alert('Cédula errada');
	window.location.href = "Clientes.html";
</script>
<%
} else {
uc.eliminarCliente(cedulaLong);
%>
<script type="text/javascript">
	alert('Datos del Cliente Borrados');
	window.location.href = "Clientes.html";
</script>
<%
}

}
%>

<head>

<title>Resultado</title>

<style type="text/css">
.divTable {
	display: table;
	width: 100%;
}

.divTableRow {
	display: table-row;
}

.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
}

.divTableCell, .divTableHead {
	border: 1px solid #999999;
	display: table-cell;
	padding: 3px 10px;
}

.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
	font-weight: bold;
}

.divTableFoot {
	background-color: #EEE;
	display: table-footer-group;
	font-weight: bold;
}

.divTableBody {
	display: table-row-group;
}

.tabla {
	width: 600px;
	margin: 0 auto;
	margin-top: 80px;
	float: center;
	text-align: center;
	font-weight: bold;
	border: 2px solid
}
</style>

</head>


<body>

	<div class="tabla">
		<strong>Resultado Cliente Consultado</strong><br>
		<div class="divTable">
			<div class="divTableBody">
				<div class="divTableRow">
					<div class="divTableCell">Cedula</div>
					<div class="divTableCell">Nombre Completo</div>
					<div class="divTableCell">Correo Electronico</div>
					<div class="divTableCell">Dirección Cliente</div>
					<div class="divTableCell">Telefono Cliente</div>
				</div>
				<div class="divTableRow">
					<div class="divTableCell"><%=rta.getCedulaCliente()%></div>
					<div class="divTableCell"><%=rta.getNombreCliente()%></div>
					<div class="divTableCell"><%=rta.getEmailCliente()%></div>
					<div class="divTableCell"><%=rta.getDireccionCliente()%></div>
					<div class="divTableCell"><%=rta.getTelefonoCliente()%></div>
				</div>
				<br> <br>
				<div>
					<input type="button" onclick="history.back()" name="volver atrás"
						value="volver atrás">

				</div>
			</div>
		</div>
	</div>

</body>