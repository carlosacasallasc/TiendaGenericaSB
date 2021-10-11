package com.DAO.TiendaVirtualSB;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.annotation.MultipartConfig;

import com.DTO.TiendaVirtualSB.*;



@MultipartConfig
public class ProductosDAO {

	private Connection connection;
	private Conexion conn;
	private PreparedStatement ps;
	
	public ArrayList<ProductosDTO> importarCSV(){
		ArrayList<ProductosDTO> productos = new ArrayList<ProductosDTO>();

		try {
			String ruta = "D:\\Ksallas\\Universidad El Bosque\\GitTiendaGenerica\\TiendaVirtualSB\\src\\Plantilla_Productos.csv";
			CsvReader leerProductos = new CsvReader(ruta);

			leerProductos.readHeaders();
			
			while(leerProductos.readRecord()) {
				Long codigo_producto = Long.parseLong(leerProductos.get(0));
				String nombre_producto = leerProductos.get(1);
				Long NitProveedor = Long.parseLong(leerProductos.get(2));
				Integer precio_compra = Integer.parseInt(leerProductos.get(3));
				Integer Ivacompra = Integer.parseInt(leerProductos.get(4));
				Integer precio_venta  = Integer.parseInt(leerProductos.get(5));
				
				productos.add(new ProductosDTO(codigo_producto,nombre_producto, NitProveedor, precio_compra, Ivacompra, precio_venta));
			}
			
			leerProductos.close();
			
			System.out.println("Lista de Productos del .csv\n");
			for(ProductosDTO producto: productos) {
				System.out.println(
						producto.getCodigoProducto()+", "+
						producto.getNombreProducto()+", "+
						producto.getNitProveedor()+", "+
						producto.getPrecioCompra()+", "+
						producto.getIvaCompra()+", "+
						producto.getPrecioVenta()
						);
			}
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return productos;
		
	}
	
	
	public boolean insertarProductos(){
		
		ArrayList<ProductosDTO> productos = new ArrayList<ProductosDTO>();
		boolean rst = false;
		
		productos = importarCSV();
		System.out.println(productos);
		conn = new Conexion();
		connection = conn.getConnection();
		
		String query = "INSERT INTO productos(codigo_producto, nombre_producto, nit_proveedor, precio_compra, iva_compra, precio_venta) VALUES(?,?,?,?,?,?)";
		
		try {
			ps = (PreparedStatement) connection.prepareStatement(query); 
			for(int i = 0; i < productos.size(); i++) {
				ps.setLong(1, productos.get(i).getCodigoProducto());
				ps.setString(2, productos.get(i).getNombreProducto());
				ps.setLong(3, productos.get(i).getNitProveedor());
				ps.setInt(4, productos.get(i).getPrecioCompra());
				ps.setInt(5, productos.get(i).getIvaCompra());
				ps.setInt(6, productos.get(i).getPrecioVenta());
				ps.executeUpdate();
				rst = true;
			}
			
			ps.close();
			connection.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			System.out.println(ex.getSQLState());
			System.out.println(ex.getCause());
		}
		
		return rst;
	}
	
	
	public void eliminarProductos() {
		
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			
			String query = "DELETE from productos";

			estatuto.executeUpdate(query);
			
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
