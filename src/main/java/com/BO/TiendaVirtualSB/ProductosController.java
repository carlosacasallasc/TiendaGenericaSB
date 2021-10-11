package com.BO.TiendaVirtualSB;


import org.springframework.web.bind.annotation.RequestMapping;
import com.DAO.TiendaVirtualSB.*;


public class ProductosController {

	@RequestMapping("/cargarProductos")
	public boolean cargarProductos() {
		ProductosDAO Dao = new ProductosDAO();
		return Dao.insertarProductos();
	}
	
	@RequestMapping("/eliminarProductos")
	public void eliminarProductos() {
		ProductosDAO Dao = new ProductosDAO();
		Dao.eliminarProductos();
	}
	
}
