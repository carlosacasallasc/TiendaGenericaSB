package com.BO.TiendaVirtualSB;

import org.springframework.web.bind.annotation.RequestMapping;
import com.DAO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.*;

public class ClienteController {
	
	@RequestMapping("/consultarCliente")
	public ClienteDTO consultarCliente(Long cedula) {
		ClienteDAO Dao = new ClienteDAO();
		return Dao.consultarCliente(cedula);
	}

	@RequestMapping("/crearCliente")
	public void crearCliente(ClienteDTO cliente) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.crearCliente(cliente);
	}

	@RequestMapping("/modificarCliente")
	public void modificarCliente(ClienteDTO cliente) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.modificarCliente(cliente);
	}

	@RequestMapping("/eliminarCliente")
	public void eliminarCliente(Long cedula) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.eliminarCliente(cedula);
	}

}
