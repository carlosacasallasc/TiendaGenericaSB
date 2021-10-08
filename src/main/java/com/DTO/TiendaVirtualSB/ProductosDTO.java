package com.DTO.TiendaVirtualSB;

public class ProductosDTO {
	
	private Integer IvaCompra;
	private Long nitProveedor;
	private String nombreProducto;
	private Integer precioCompra;
	private Integer precioVenta;
	private Long codigoProducto;
	
	public ProductosDTO(Long codigoProducto,String nombreProducto, Long nitProveedor, Integer precioCompra, Integer ivaCompra,   
			Integer precioVenta) {
		super();
		IvaCompra = ivaCompra;
		this.nitProveedor = nitProveedor;
		this.nombreProducto = nombreProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.codigoProducto = codigoProducto;
		
	}
	
	public ProductosDTO() {
		
	}
	
	public Long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public Integer getIvaCompra() {
		return IvaCompra;
	}
	public void setIvaCompra(Integer ivaCompra) {
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
	public Integer getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(Integer precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Integer getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Integer precioVenta) {
		this.precioVenta = precioVenta;
	}
	
}
