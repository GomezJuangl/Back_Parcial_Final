package parcial.com.back.dto;

import java.math.BigDecimal;

public class ProductoDto {

	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private Integer cantidad;

	public ProductoDto(Long id, String nombre, String descripcion, BigDecimal precio, Integer cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Long getId() { return id; }
	public String getNombre() { return nombre; }
	public String getDescripcion() { return descripcion; }
	public BigDecimal getPrecio() { return precio; }
	public Integer getCantidad() { return cantidad; }
}