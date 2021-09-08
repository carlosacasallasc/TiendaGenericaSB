package com.DTO.TiendaVirtualSB;

public class ProductosDTO {
	
	private Number IvaCompra;
	private Long nitProveedor;
	private String nombreProducto;
	private Number precioCompra;
	private Number precioVenta;
	
	private Long codigoProducto;
	public Long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public Number getIvaCompra() {
		return IvaCompra;
	}
	public void setIvaCompra(Number ivaCompra) {
		IvaCompra = ivaCompra;
	}
	public Long getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Number getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(Number precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Number getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Number precioVenta) {
		this.precioVenta = precioVenta;
	}
	
}
