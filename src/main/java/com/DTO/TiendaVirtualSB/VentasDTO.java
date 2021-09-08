package com.DTO.TiendaVirtualSB;

public class VentasDTO {
	
	private Long codigoVenta;
	private Long cedulaCliente;
	private Long cedulaUsuario;
	private Number ivaVenta; 
	private Number totalVenta;
	private Number valorVenta;
	
	public Long getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(Long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public Long getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(Long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public Long getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(Long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public Number getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(Number ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public Number getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(Number totalVenta) {
		this.totalVenta = totalVenta;
	}
	public Number getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(Number valorVenta) {
		this.valorVenta = valorVenta;
	}
	
}
