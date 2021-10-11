package com.BO.TiendaVirtualSB;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import com.DAO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.*;

public class ReportesController {

	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuariosDTO> listarUsuarios() {
		ReporteDAO Dao=new ReporteDAO(); 
		return Dao.listarUsuarios();		
	}
	
	@RequestMapping("/listarClientes")
	public ArrayList<ClienteDTO> listarClientes() {
		ReporteDAO Dao=new ReporteDAO(); 
		return Dao.listarClientes();		
	}
	
	@RequestMapping("/listarVentas")
	public ArrayList<VentasDTO> listarVentas() {
		ReporteDAO Dao=new ReporteDAO(); 
		return Dao.listarVentas();		
	}
	
}
