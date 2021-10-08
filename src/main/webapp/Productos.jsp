<%@page import="javax.servlet.annotation.MultipartConfig"%>
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
	//boolean rst = uc.cargarProductos();
	//Part part = request.getPart("csv");
	//String header = part.getHeader("content-disposition");
	//String fileName = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;
	
	
	

%>




<div class="divTableRow">
	<div class="divTableCell"><%= basePath %></div>
</div>

