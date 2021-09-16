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

 /**
  * Permite registrar un Usuario nuevo
  * @param persona
  */
	
	
 public void registrarPersona(UsuariosDTO persona) 
 {
  Conexion conex= new Conexion();
  try {
   Statement estatuto = conex.getConnection().createStatement();
   estatuto.executeUpdate("INSERT INTO usuarios VALUES ('"+persona.getCedulaUsuario()+"', '"
     +persona.getEmailUsuario()+"', '"+persona.getNombreUsuario()+"','"+persona.getPassword()+"','"+persona.getUsuario()+"' )");
    estatuto.close();
   conex.desconectar();
   
  } catch (SQLException e) {
            System.out.println(e.getMessage());
   
  }
 }
   
 
 
/**
 * permite consultar el Usuario asociado al documento enviado
 * como parametro 
 * @param documento 
 * @return
 */
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


public void modificarPersona(UsuariosDTO persona) 
{
 Conexion conex= new Conexion();
 try {
  Statement estatuto = conex.getConnection().createStatement();
/*estatuto.executeUpdate(
		"UPDATE usuarios"+
		  "SET email_usuario = '"+persona.getEmailUsuario()+"',"+
		   "nombre_usuario='"+persona.getNombreUsuario()+"' "+
		   "password='"+persona.getPassword()+"' "+
		   "usuario='"+persona.getUsuario()+"' "+
		   "WHERE cedula_usuario=" + persona.getCedulaUsuario()*/

		  
 estatuto.executeUpdate("UPDATE usuarios SET email_usuario = '"+persona.getEmailUsuario()+"', "+
		   "nombre_usuario ='"+persona.getNombreUsuario()+"', "+
		   "password ='"+persona.getPassword()+"', "+
		   "usuario ='"+persona.getUsuario()+"', "+
		   "WHERE cedula_usuario=" + persona.getCedulaUsuario()
		  
	);
  
 estatuto.close();
 conex.desconectar();
  
 } catch (SQLException e) {
           System.out.println(e.getMessage());
  
 }
}
/**
 * permite consultar la lista de Usuarios
 * @return
 */
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

}