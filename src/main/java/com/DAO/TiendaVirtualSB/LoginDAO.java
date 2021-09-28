package com.DAO.TiendaVirtualSB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.Console;
import java.sql.CallableStatement;

import javax.swing.JOptionPane;
import com.DTO.TiendaVirtualSB.*;

public class LoginDAO {
	
	private Connection connection;
	private Conexion conn;
	private PreparedStatement ps;
	private int rta = 0;
	private ResultSet rs;
	
	public int IniciarLogin(UsuariosDTO usuario) {
			
		conn = new Conexion();
		
		String nombreUsuario = usuario.getNombreUsuario();
		String contraseña = usuario.getPassword();
		
		String sql = "SELECT nombre_usuario, password  FROM usuarios WHERE usuario = '"+ nombreUsuario +"' AND password ='"+ contraseña +"' ";
		
		try {
			connection = conn.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				rta = 1;
				usuario.setNombreUsuario("nombre_usuario");
				usuario.setPassword("password");
			}
			
			if(rta == 1)
			{
				return 1;
			} else {
				return 0;
			}
				
			
		}catch (SQLException ex) {
			System.out.println("Error en BBDD: " + ex.getMessage());
		}
		
		return rta;
	}
	

}
