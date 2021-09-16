package com.BO.TiendaVirtualSB;

import java.util.ArrayList;
/*import java.util.HashMap;*/

/*import org.springframework.boot.json.GsonJsonParser;*/
/*import org.springframework.boot.json.JsonParser;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.UsuarioDAO;
/*import com.fasterxml.jackson.databind.JsonNode;*/
import com.DTO.TiendaVirtualSB.UsuariosDTO;



@RestController
public class UsuarioController {
	
	
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


}