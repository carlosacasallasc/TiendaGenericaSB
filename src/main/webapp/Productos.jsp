<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
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

	UsuarioController uc =new UsuarioController(); 
	uc.cargarProductos();

%>


<script type="text/javascript">
</script>

<div class="divTableRow">
			<div class="divTableCell"></div>
			
		</div>

