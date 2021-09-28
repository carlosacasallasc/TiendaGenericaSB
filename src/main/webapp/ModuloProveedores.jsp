<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="
        java.io.*,
        java.util.*,
        com.BO.TiendaVirtualSB.*,
        com.DTO.TiendaVirtualSB.*"
    
    %>
<!DOCTYPE html>
<html lang="es">
<meta charset="ISO-8859-1">

<%
	
	UsuarioController uc = new UsuarioController();
	ProveedoresDTO objProveedor = new ProveedoresDTO();
	ProveedoresDTO rta = new ProveedoresDTO();
	
	long nitLong = Long.parseLong(request.getParameter("Nit"));
	
	objProveedor.setNitProveedor(nitLong);	
	objProveedor.setNombreProveedor(request.getParameter("Nombre"));
	objProveedor.setDireccionProveedor(request.getParameter("Direccion"));
	objProveedor.setTelefonoProveedor(request.getParameter("Telefono"));
	objProveedor.setCiudadProveedor(request.getParameter("Ciudad"));	

	/*Variable par almacenar la opción seleccionada en el formulario*/
	String opcion = request.getParameter("proveedor");
	
	
	if(Integer.parseInt(opcion) == 1){
		
		rta = uc.consultarProveedor(nitLong);
				
		if(rta.getNitProveedor() == null){
			%>
			<script type="text/javascript">
		    	alert('El proveedor consultado no existe');
		    	window.location.href = "ModuloProveedores.html";
			</script>
		<%		
		}
	} 
	
	if(Integer.parseInt(opcion) == 2){
		rta = uc.consultarProveedor(nitLong);
		
		if(rta.getNitProveedor() == null){
			uc.registrarProveedor(objProveedor);
			%>
				<script type="text/javascript">
			    	alert('Proveedor Creado');
			    	window.location.href = "ModuloProveedores.html";
				</script>
			<%	
		}else {
		
		%>
			<script type="text/javascript">
		    	alert('El proveedor que intenta crear ya existe');
		    	window.location.href = "ModuloProveedores.html";
			</script>
		<%		
	}
	}
	
	if(Integer.parseInt(opcion) == 3){
		
		rta = uc.consultarProveedor(nitLong);
		
		if(rta.getNitProveedor() == null){
			%>
			<script type="text/javascript">
		    	alert('El usuario que intenta actualizar no existe');
		    	window.location.href = "ModuloProveedores.html";
			</script>
		<%
		}else {
			uc.modificarProveedor(objProveedor);
			%>
			<script type="text/javascript">
		    	alert('Datos del Proveedor Actualizados');
		    	window.location.href = "ModuloProveedores.html";
			</script>
		<%			
		}
		
		
	}
	
	if(Integer.parseInt(opcion) == 4){
		
		rta = uc.consultarProveedor(nitLong);
		
		if(rta.getNitProveedor() == null){
			%>
			<script type="text/javascript">
		    	alert('Nit errado');
		    	window.location.href = "ModuloProveedores.html";
			</script>
		<%
		}else {
			uc.eliminarProveedor(nitLong);
			%>
			<script type="text/javascript">
		    	alert('Datos del Proveedor Borrados');
		    	window.location.href = "ModuloProveedores.html";
			</script>
		<%			
		}
		
	}

%>



<head>

<title>Resultado</title>

<style type="text/css">
		.divTable{
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
		
		.tabla{
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
		<strong>Resultado Proveedor Consultado</strong><br>
		<div class="divTable">
		<div class="divTableBody">
		<div class="divTableRow">
			<div class="divTableCell">Nit Proveedor</div>
			<div class="divTableCell">Nombre Proveedor</div>
			<div class="divTableCell">Dirección</div>
			<div class="divTableCell">Telefono</div>
			<div class="divTableCell">Ciudad</div>
		</div>
		<div class="divTableRow">
			<div class="divTableCell"><%= rta.getNitProveedor() %></div>
			<div class="divTableCell"><%= rta.getNombreProveedor()  %></div>
			<div class="divTableCell"><%= rta.getDireccionProveedor()  %></div>
			<div class="divTableCell"><%= rta.getTelefonoProveedor()  %></div>
			<div class="divTableCell"><%= rta.getCiudadProveedor() %></div>
		</div>
		<br>
		<br>
			<div>
				<input type="button" onclick="history.back()" name="volver atrás" value="volver atrás">
				
			</div>
		</div>
		</div>
	</div>
			
	</body>