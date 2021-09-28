package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DTO.TiendaVirtualSB.ProveedoresDTO;

public class ProveedorDAO {

	/**
	 * Permite registrar un Proveedor nuevo
	 * 
	 * @param persona
	 */

	public void registrarProveedor(ProveedoresDTO proveedor) {
		Conexion conex = new Conexion();
		String sql = "";
		try {
			Statement estatuto = conex.getConnection().createStatement();
			sql = "INSERT INTO proveedores VALUES ('" + proveedor.getNitProveedor() + "', '"
					+ proveedor.getCiudadProveedor() + "', '" + proveedor.getDireccionProveedor() + "', '"
					+ proveedor.getNombreProveedor() + "', '" + proveedor.getTelefonoProveedor() + "')";

			estatuto.executeUpdate(sql);
			System.out.println("Agrego correctamente: " + sql);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("Error: " + sql);
			System.out.println(e.getMessage());

		}
	}

	public void modificarProveedor(ProveedoresDTO proveedor) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();

			estatuto.executeUpdate("UPDATE proveedores SET ciudad_proveedor = '" + proveedor.getCiudadProveedor()
					+ "',direccion_proveedor = '" + proveedor.getDireccionProveedor() + "', nombre_proveedor = '"
					+ proveedor.getNombreProveedor() + "', telefono_proveedor ='" + proveedor.getTelefonoProveedor()
					+ "'" + "WHERE nit_proveedor=" + proveedor.getNitProveedor());
			/* en azul los nombres de los campos de la DB */

			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * permite consultar un Proveedor por numero de Nit
	 * 
	 * @return
	 */
	public ProveedoresDTO consultarProveedor(Long nitProveedor) {
		ProveedoresDTO miProveedor = new ProveedoresDTO();
		Conexion conex = new Conexion();

		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM proveedores WHERE nit_proveedor = '" + nitProveedor + "'");
			System.out.println(consulta);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {

				miProveedor.setNitProveedor(Long.parseLong(res.getString("nit_proveedor")));
				miProveedor.setCiudadProveedor(res.getString("ciudad_proveedor")); /* Campo DB */
				miProveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
				miProveedor.setNombreProveedor(res.getString("nombre_proveedor"));
				miProveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));

			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return miProveedor;
	}

	/**
	 * permite eliminar el proveedor
	 * 
	 * @return
	 */
	public void eliminarProveedor(Long nitProveedor) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();

			estatuto.executeUpdate("DELETE from proveedores WHERE nit_proveedor=" + nitProveedor);

			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

}
