package com.BO.TiendaVirtualSB;

import org.springframework.web.bind.annotation.RequestMapping;
import com.DAO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.*;

public class ProveedorController {

	
	@RequestMapping("/consultarProveedor")
	public ProveedoresDTO consultarProveedor(Long nitProveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.consultarProveedor(nitProveedor);
	}
	
	@RequestMapping("/registrarProveedor")
	public void registrarProveedor(ProveedoresDTO proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.registrarProveedor(proveedor);
	}

	@RequestMapping("/modificarProveedor")
	public void modificarProveedor(ProveedoresDTO proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.modificarProveedor(proveedor);
	}

	@RequestMapping("/eliminarProveedor")
	public void eliminarProveedor(Long nitProveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.eliminarProveedor(nitProveedor);
	}
}
