package parcial.com.back.dto;

import jakarta.validation.constraints.NotBlank;

public class BodegaRequest {

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;

	@NotBlank(message = "La ubicación es obligatoria")
	private String ubicacion;

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getUbicacion() { return ubicacion; }
	public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}