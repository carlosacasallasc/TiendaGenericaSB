package com.BO.TiendaVirtualSB;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.*;
import javax.servlet.http.HttpServlet;

@RestController
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

	
	
	/* METODOS CLIENTES */

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

	
	
	/* METODOS PROVEEDORES */
	
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
	
	

	/* METODOS PRODUCTOS */

	@RequestMapping("/cargarProductos")
	public ArrayList<ProductosDTO> cargarProductos(String miArchivo) {
		ProductosDAO Dao = new ProductosDAO();
		return Dao.insertarProductos(miArchivo);
	}

}