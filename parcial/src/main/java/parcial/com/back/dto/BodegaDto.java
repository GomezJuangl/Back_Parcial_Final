package parcial.com.back.dto;

import java.util.List;

public class BodegaDto {

	private Long id;
	private String nombre;
	private String ubicacion;
	private List<ProductoDto> productos;

	public BodegaDto(Long id, String nombre, String ubicacion, List<ProductoDto> productos) {
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.productos = productos;
	}

	public Long getId() { return id; }
	public String getNombre() { return nombre; }
	public String getUbicacion() { return ubicacion; }
	public List<ProductoDto> getProductos() { return productos; }
}