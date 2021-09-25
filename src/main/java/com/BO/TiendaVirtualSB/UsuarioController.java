package com.BO.TiendaVirtualSB;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@RestController
public class UsuarioController extends HttpServlet{
	
	LoginDAO login = new LoginDAO();
	UsuariosDTO usu = new UsuariosDTO();
	int r = 0;
	
	@RequestMapping("/iniciarLogin")
	public int validarLogin(UsuariosDTO usuario){
		r = login.IniciarLogin(usuario);
		return r;
	}
	
	
	@RequestMapping("/registrarPersona")
	public void registrarPersona(UsuariosDTO persona) 
	 {
		UsuarioDAO Dao=new UsuarioDAO(); 
	    Dao.registrarPersona(persona);
	    
	 }
	   
	 
	@RequestMapping("/modificarPersona")
	public void modificarPersona(UsuariosDTO persona) 
	 {
		UsuarioDAO Dao=new UsuarioDAO(); 
	    Dao.modificarPersona(persona);
	    }
	
	 
	/**
	 * permite consultar el Usuario asociado al documento enviado
	 * como parametro 
	 * @param documento 
	 * @return
	 */
	
	@RequestMapping("/consultarPersona")
	public ArrayList<UsuariosDTO> consultarPersona(int documento) {
		UsuarioDAO Dao=new UsuarioDAO(); 
	return 	Dao.consultarPersona(documento);
		
	}



	/**
	 * permite consultar la lista de Usuarios
	 * @return
	 */
	@RequestMapping("/listarPersonas")
	public ArrayList< UsuariosDTO> listaDePersonas() {
		UsuarioDAO Dao=new UsuarioDAO(); 
			
		return Dao.listaDePersonas();
		
	}
	
	
	@RequestMapping("/crearCliente")
	public void crearCliente(ClienteDTO cliente) {
		ClienteDAO Dao=new ClienteDAO(); 
		Dao.crearCliente(cliente);
		
		
	}

}