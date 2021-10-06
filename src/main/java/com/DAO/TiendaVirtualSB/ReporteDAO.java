package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.TiendaVirtualSB.ClienteDTO;
import com.DTO.TiendaVirtualSB.UsuariosDTO;
import com.DTO.TiendaVirtualSB.VentasDTO;

public class ReporteDAO {
	
	
	/**
	 * permite consultar la LISTA DE USUARIOS
	 * @return
	 */
	public ArrayList<UsuariosDTO> listarUsuarios() {
	  ArrayList< UsuariosDTO> misUsuarios = new ArrayList< UsuariosDTO>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    UsuariosDTO usuarios = new UsuariosDTO();
	   
	    usuarios.setCedulaUsuario(Long.parseLong(res.getString("cedula_usuario")));
	    usuarios.setEmailUsuario(res.getString("email_usuario"));  /*Campo DB*/
	    usuarios.setNombreUsuario(res.getString("nombre_usuario"));
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

}
