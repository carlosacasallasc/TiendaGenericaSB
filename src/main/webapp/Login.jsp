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



<%
	String mensaje = "";
	String url = "MenuPrincipal.html";
	String urlLogin = "Login.html";
	UsuarioController uc = new UsuarioController();
	UsuariosDTO log = new UsuariosDTO();
	String usuario = request.getParameter("user");
	String pwd = request.getParameter("password");
	log.setNombreUsuario(usuario);
	log.setPassword(pwd);
	int rta = uc.validarLogin(log);
	
	if(rta == 1){
		response.sendRedirect(url);
	} else {
		%>
		<script type="text/javascript">
	    	alert('usuario o contraseña errados, intente de nuevo');
	    	window.location.href = "Login.html";
		</script>
	<%	
		
		
	}
%>