package com.DTO.TiendaVirtualSB;

public class DetalleVentasDTO {

	private Long codigoDetalleVenta;
	private Integer cantidadProducto;
	private Long codigoProducto;
	private Long codigoVenta;
	private Number valorTotal;
	private Number valorVenta;
	private Number valorIva;
	
	public Long getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}
	public void setCodigoDetalleVenta(Long codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}
	public Integer getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public Long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public Long getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(Long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public Number getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Number valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Number getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(Number valorVenta) {
		this.valorVenta = valorVenta;
	}
	public Number getValorIva() {
		return valorIva;
	}
	public void setValorIva(Number valorIva) {
		this.valorIva = valorIva;
	}
	
}
