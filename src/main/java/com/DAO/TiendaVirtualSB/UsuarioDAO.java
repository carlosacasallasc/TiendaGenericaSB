package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*import javax.swing.JOptionPane;*/
/*import com.BO.TiendaVirtualSB.*;*/
import com.DTO.TiendaVirtualSB.UsuariosDTO;


/**
 * Clase que permite el acceso a la base de datos
 * 
 *
 */
public class UsuarioDAO 
{

 
	/*METODOS EJEMPLO*/  
public ArrayList<UsuariosDTO> consultarPersona(int documento) {
  ArrayList< UsuariosDTO> miUsuario = new ArrayList< UsuariosDTO>();
  Conexion conex= new Conexion();
    
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where cedula_usuario = ? ");
   consulta.setInt(1, documento);
   ResultSet res = consulta.executeQuery();
   
  if(res.next()){
	  UsuariosDTO persona= new UsuariosDTO();
    persona.setCedulaUsuario(Long.parseLong(res.getString("email_usuario")));
    persona.setEmailUsuario(res.getString("email_usuario"));
    persona.setNombreUsuario(res.getString("nombrel_usuario"));
    persona.setPassword(res.getString("password"));
    persona.setUsuario(res.getString("usuario"));
 
    miUsuario.add(persona);
          }
          res.close();
          consulta.close();
          conex.desconectar();
   
  } catch (Exception e) {
   
  }
  return miUsuario;
 }

public ArrayList< UsuariosDTO> listaDePersonas() {

  ArrayList< UsuariosDTO> miUsuario = new ArrayList< UsuariosDTO>();
  Conexion conex= new Conexion();
    
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
   ResultSet res = consulta.executeQuery();
   while(res.next()){
    UsuariosDTO persona= new UsuariosDTO();
    
    persona.setCedulaUsuario(Long.parseLong(res.getString("cedula_usuario")));
    persona.setEmailUsuario(res.getString("email_usuario"));
    persona.setNombreUsuario(res.getString("nombre_usuario"));
    persona.setPassword(res.getString("password"));
    persona.setUsuario(res.getString("usuario"));
    
    
  
    miUsuario.add(persona);
          }
          res.close();
          consulta.close();
          conex.desconectar();
   
  } catch (Exception e) {
   
  }
  return miUsuario;
 }


/*SECCION FORMULARIO USUARIOS*/

public UsuariosDTO consultarUsuario(Long cedula) {
		UsuariosDTO usuario= new UsuariosDTO();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where cedula_usuario = '"+ cedula +"' ");
	   
	   ResultSet res = consulta.executeQuery();
	   
	  if(res.next()){
		 	  
		  usuario.setCedulaUsuario(Long.parseLong(res.getString("cedula_usuario")));
		  usuario.setEmailUsuario(res.getString("email_usuario")); 
		  usuario.setNombreUsuario(res.getString("nombre_usuario"));
		  usuario.setPassword(res.getString("password"));
		  usuario.setUsuario(res.getString("usuario"));
		  
		  
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (SQLException e) {
		  System.out.println("Error al consultar en BBDD " + e.getMessage());
	   
	  }
	  return usuario;
	  
	 }

public void crearUsuario(UsuariosDTO usuario) {
	Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO usuarios VALUES ('"+usuario.getCedulaUsuario()+"', '"
	     +usuario.getEmailUsuario()+"', '"+usuario.getNombreUsuario()+"','"+usuario.getPassword()+"','"+usuario.getUsuario()+"' )");
	    estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {
	            System.out.println(e.getMessage());
	   
	  }
  
 }

public void actualizarUsuario(UsuariosDTO usuario) {
	Conexion conex= new Conexion();
	 try {
	  Statement estatuto = conex.getConnection().createStatement();
	  
	  String query = "UPDATE usuarios SET email_usuario = '"+usuario.getEmailUsuario()+"', "+
			   "nombre_usuario ='"+usuario.getNombreUsuario()+"', "+
			   "password ='"+usuario.getPassword()+"', "+
			   "usuario ='"+usuario.getUsuario()+"' "+
			   "WHERE cedula_usuario= " + usuario.getCedulaUsuario();
			    
	 estatuto.executeUpdate(query);
	  
	 estatuto.close();
	 conex.desconectar();
	  
	 } catch (SQLException e) {
	           System.out.println(e.getMessage());
	 }
	
}

public void borrarUsuario(Long cedula) {
	Conexion conex= new Conexion();
	 try {
	  Statement estatuto = conex.getConnection().createStatement();
	  
	  String query = "DELETE FROM usuarios WHERE  cedula_usuario = '"+ cedula +"'";
			   
	 estatuto.executeUpdate(query);
	  
	 estatuto.close();
	 conex.desconectar();
	  
	 } catch (SQLException e) {
	           System.out.println(e.getMessage());
	 }
	
}
	
	

}