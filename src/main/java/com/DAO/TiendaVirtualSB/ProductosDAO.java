package com.DAO.TiendaVirtualSB;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.TiendaVirtualSB.*;




public class ProductosDAO {

	private Connection connection;
	private Conexion conn;
	private PreparedStatement ps;
	
	public ArrayList<ProductosDTO> leerArchivoProductos(String miArchivo){
		ArrayList<ProductosDTO> lstProductos = new ArrayList<ProductosDTO>();

		
		
		return lstProductos;
	}
	
	
	public ArrayList<ProductosDTO> insertarProductos(String miArchivo){
		
		ArrayList<ProductosDTO> lstProductos = new ArrayList<ProductosDTO>();
		lstProductos = leerArchivoProductos(miArchivo);
		System.out.println("Se van a insertar: "+ lstProductos.size() + " registros\n");
		
		conn = new Conexion();
		connection = conn.getConnection();
		
		String query = "INSERT INTO productos(codigo_producto, iva_compra, nit_proveedor,nombre_producto,precio_compra,precio_venta) VALUES(?,?,?,?,?,?)";
		
		try {
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			for(int i = 0; i < lstProductos.size(); i++) {
				ps.setLong(1, lstProductos.get(i).getCodigoProducto());
				ps.setString(2, lstProductos.get(i).getNombreProducto());
				ps.setLong(1, lstProductos.get(i).getNitProveedor());
				ps.setInt(1, lstProductos.get(i).getPrecioCompra());
				ps.setInt(1, lstProductos.get(i).getIvaCompra());
				ps.setInt(1, lstProductos.get(i).getPrecioVenta());
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return lstProductos;
	}
	
	
	
}
