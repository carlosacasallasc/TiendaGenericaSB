package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DTO.TiendaVirtualSB.ClienteDTO;
import com.DTO.TiendaVirtualSB.UsuariosDTO;
import com.DTO.TiendaVirtualSB.VentasDTO;

public class ReporteDAO {
	
	/* Metodo listar usuarios*/
	
	public ArrayList<UsuariosDTO> listarUsuarios() {
	  ArrayList< UsuariosDTO> misUsuarios = new ArrayList< UsuariosDTO>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    UsuariosDTO usuarios = new UsuariosDTO();
	   
	    usuarios.setCedulaUsuario(Long.parseLong(res.getString("cedula_usuario")));
	    usuarios.setNombreUsuario(res.getString("nombre_usuario"));
	    usuarios.setEmailUsuario(res.getString("email_usuario"));  
	    usuarios.setPassword(res.getString("password"));
	    usuarios.setUsuario(res.getString("usuario"));
	  
	    misUsuarios.add(usuarios);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   
	  }
	  return misUsuarios;
	 }	
	
	/* Metodo Listar Clientes*/
	
	public ArrayList<ClienteDTO> listarClientes() {
	  ArrayList< ClienteDTO> miCliente = new ArrayList< ClienteDTO>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    ClienteDTO cliente = new ClienteDTO();
	   
	    cliente.setCedulaCliente(Long.parseLong(res.getString("cedula_cliente")));
	    cliente.setNombreCliente(res.getString("nombre_cliente"));
	    cliente.setEmailCliente(res.getString("email_cliente"));
	    cliente.setDireccionCliente(res.getString("direccion_cliente")); 
	    cliente.setTelefonoCliente(res.getString("telefono_cliente"));
	  
	    miCliente.add(cliente);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   
	  }
	  return miCliente;
	 }	
	
	/* Metodo listar ventas*/
	
	public ArrayList<VentasDTO>listarVentas() {
		  ArrayList< VentasDTO> misventas = new ArrayList< VentasDTO>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    VentasDTO ventas = new VentasDTO();
		   
		    ventas.setCedulaCliente(Long.parseLong(res.getString("cedula_cliente")));
		    ventas.setTotalVenta(res.getDouble("total_venta")); 
		  
		    misventas.add(ventas);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   
		  }
		  return misventas;
		 }	
}
