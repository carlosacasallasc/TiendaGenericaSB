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
	UsuariosDTO objUsuario = new UsuariosDTO();
	UsuariosDTO rta = new UsuariosDTO();
	
	long cedulaLong = Long.parseLong(request.getParameter("Cedula"));
	
	objUsuario.setCedulaUsuario(cedulaLong);	
	objUsuario.setNombreUsuario(request.getParameter("Nombre"));
	objUsuario.setEmailUsuario(request.getParameter("Correo"));
	objUsuario.setUsuario(request.getParameter("Usuario"));
	objUsuario.setPassword(request.getParameter("Contraseña"));	

	/*Variable par almacenar la opción seleccionada en el formulario*/
	String opcion = request.getParameter("usuario");
	
	
	if(Integer.parseInt(opcion) == 1){
		
		rta = uc.consultarUsuario(cedulaLong);
		if(rta.getCedulaUsuario() == null){
			%>
			<script type="text/javascript">
		    	alert('El usuario consultado no existe');
		    	window.location.href = "Usuarios.html";
			</script>
		<%		
		}
	} 
	
	if(Integer.parseInt(opcion) == 2){
		rta = uc.consultarUsuario(cedulaLong);
		
		if(rta.getCedulaUsuario() == null){
			uc.crearUsuario(objUsuario);
			%>
				<script type="text/javascript">
			    	alert('Usuario Creado');
			    	window.location.href = "Usuarios.html";
				</script>
			<%	
		}else {
		
		%>
			<script type="text/javascript">
		    	alert('El usuario que intenta crear ya existe');
		    	window.location.href = "Usuarios.html";
			</script>
		<%		
	}
	}
	
	if(Integer.parseInt(opcion) == 3){
		
		rta = uc.consultarUsuario(cedulaLong);
		
		if(rta.getCedulaUsuario() == null){
			%>
			<script type="text/javascript">
		    	alert('El usuario que intenta actualizar no existe');
		    	window.location.href = "Usuarios.html";
			</script>
		<%
		}else {
			uc.actualizarUsuario(objUsuario);
			%>
			<script type="text/javascript">
		    	alert('Datos del Usuario Actualizados');
		    	window.location.href = "Usuarios.html";
			</script>
		<%			
		}
		
		
	}
	
	if(Integer.parseInt(opcion) == 4){
		
		rta = uc.consultarUsuario(cedulaLong);
		
		if(rta.getCedulaUsuario() == null){
			%>
			<script type="text/javascript">
		    	alert('Cédula errada');
		    	window.location.href = "Usuarios.html";
			</script>
		<%
		}else {
			uc.borrarUsuario(cedulaLong);
			%>
			<script type="text/javascript">
		    	alert('Datos del Usuario Borrados');
		    	window.location.href = "Usuarios.html";
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
		<strong>Resultado Consulta</strong><br>
		<div class="divTable">
		<div class="divTableBody">
		<div class="divTableRow">
			<div class="divTableCell">Cedula</div>
			<div class="divTableCell">Nombre Completo</div>
			<div class="divTableCell">Correo Electronico</div>
			<div class="divTableCell">Usuario</div>
			<div class="divTableCell">Contraseña</div>
		</div>
		<div class="divTableRow">
			<div class="divTableCell"><%= rta.getCedulaUsuario()  %></div>
			<div class="divTableCell"><%= rta.getNombreUsuario()  %></div>
			<div class="divTableCell"><%= rta.getEmailUsuario()  %></div>
			<div class="divTableCell"><%= rta.getUsuario()  %></div>
			<div class="divTableCell"><%= rta.getPassword() %></div>
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
