package com.DAO.TiendaVirtualSB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.BO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.ClienteDTO;
import com.DTO.TiendaVirtualSB.ClienteVO;

/**
 * Clase que permite el acceso a la base de datos
 * 
 *
 */
public class ClienteDAO {

	/**
	 * permite consultar el Cliente asociado al documento enviado como parametro
	 * 
	 * @param documento
	 * @return
	 */
	public ArrayList<ClienteVO> consultarPersona(int documento) {
		ArrayList<ClienteVO> miCliente = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();

		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM Cliente where idCliente = ? ");
			consulta.setInt(1, documento);
			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				ClienteVO persona = new ClienteVO();
				persona.setIdCliente(Integer.parseInt(res.getString("idCliente")));
				persona.setNombreCliente(res.getString("Nombre"));
				persona.setApellidoCliente(res.getString("Apellido"));

				miCliente.add(persona);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
		}
		return miCliente;
	}

	/**
	 * permite consultar la lista de Clientes
	 * 
	 * @return
	 */
	public ArrayList<ClienteVO> listaDePersonas() {
		ArrayList<ClienteVO> miCliente = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM Cliente");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				ClienteVO persona = new ClienteVO();
				persona.setIdCliente(Integer.parseInt(res.getString("idCliente")));
				persona.setNombreCliente(res.getString("nombre"));
				persona.setApellidoCliente(res.getString("Apellido"));

				miCliente.add(persona);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
		}
		return miCliente;
	}

	public void crearCliente(ClienteDTO cliente) {
		Conexion conex = new Conexion();
		String sql = "";

		try {
			Statement estatuto = conex.getConnection().createStatement();
			sql = "INSERT INTO clientes VALUES ('" + cliente.getCedulaCliente() + "', '" + cliente.getDireccionCliente()
					+ "', '" + cliente.getEmailCliente() + "', '" + cliente.getNombreCliente() + "', '"
					+ cliente.getTelefonoCliente() + "')";

			estatuto.executeUpdate(sql);
			System.out.println("Agrego correctamente: " + sql);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("Error: " + sql);
			System.out.println(e.getMessage());

		}

	}

	/**
	 * permite ELIMINAR un Usuario
	 * 
	 * @return
	 */
	public void eliminarCliente(Long cedula) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			
			String query = "DELETE from clientes WHERE cedula_cliente= '"+ cedula +"'";

			estatuto.executeUpdate(query);
			
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	/*
	 * permite MODIFICAR el Usuario asociado al documento enviado como parametro
	 * 
	 * @param documento
	 * 
	 * @return
	 */

	public void modificarCliente(ClienteDTO cliente) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();

			estatuto.executeUpdate("UPDATE clientes SET email_cliente = '" + cliente.getEmailCliente()
					+ "',nombre_cliente = '" + cliente.getNombreCliente() + "', direccion_cliente = '"
					+ cliente.getDireccionCliente() + "', telefono_cliente ='" + cliente.getTelefonoCliente() + "'"
					+ "WHERE cedula_cliente=" + cliente.getCedulaCliente());
			/* en azul los nombres de los campos de la DB */

			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * permite consultar la LISTA DE USUARIOS
	 * 
	 * @return
	 */
	public ClienteDTO consultarCliente(Long cedula) {
		ClienteDTO miCliente = new ClienteDTO();
		Conexion conex = new Conexion();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_cliente = '"+ cedula +"'");
			
			ResultSet res = consulta.executeQuery();
			if (res.next()) {

				miCliente.setCedulaCliente(Long.parseLong(res.getString("cedula_cliente")));
				miCliente.setEmailCliente(res.getString("email_cliente")); /* Campo DB */
				miCliente.setNombreCliente(res.getString("nombre_cliente"));
				miCliente.setDireccionCliente(res.getString("direccion_cliente"));
				miCliente.setTelefonoCliente(res.getString("telefono_cliente"));

			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			System.out.println("Error al consultar en BBDD " + e.getMessage());

		}
		return miCliente;
	}

}