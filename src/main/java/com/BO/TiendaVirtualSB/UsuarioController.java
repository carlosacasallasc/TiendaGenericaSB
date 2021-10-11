package com.BO.TiendaVirtualSB;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.*;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;

@RestController
@MultipartConfig
public class UsuarioController extends HttpServlet {

	/* METODOS LOGIN */

	@RequestMapping("/iniciarLogin")
	public int validarLogin(UsuariosDTO usuario) {
		LoginDAO login = new LoginDAO();
		int r = 0;
		r = login.IniciarLogin(usuario);
		return r;
	}

	
	
	/* METODOS USUARIOS */

	@RequestMapping("/consultarUsuario")
	public UsuariosDTO consultarUsuario(Long cedula) {
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.consultarUsuario(cedula);
	}

	@RequestMapping("/crearUsuario")
	public void crearUsuario(UsuariosDTO usuario) {
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.crearUsuario(usuario);
	}

	@RequestMapping("/actualizarUsuario")
	public void actualizarUsuario(UsuariosDTO usuario) {
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.actualizarUsuario(usuario);
	}

	@RequestMapping("/borrarUsuario")
	public void borrarUsuario(Long cedula) {
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.borrarUsuario(cedula);
	}

		
}