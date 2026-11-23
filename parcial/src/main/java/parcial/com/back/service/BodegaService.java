package parcial.com.back.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parcial.com.back.dto.BodegaDto;
import parcial.com.back.dto.BodegaRequest;
import parcial.com.back.dto.ProductoDto;
import parcial.com.back.entity.Bodega;
import parcial.com.back.entity.Producto;
import parcial.com.back.repository.BodegaRepository;

@Service
public class BodegaService {

	private final BodegaRepository bodegaRepository;

	public BodegaService(BodegaRepository bodegaRepository) {
		this.bodegaRepository = bodegaRepository;
	}

	@Transactional(readOnly = true)
	public List<BodegaDto> listar() {
		return bodegaRepository.findAll()
				.stream()
				.map(this::aDto)
				.toList();
	}

	@Transactional
	public BodegaDto registrar(BodegaRequest request) {
		Bodega bodega = new Bodega(request.getNombre(), request.getUbicacion());
		return aDto(bodegaRepository.save(bodega));
	}

	private BodegaDto aDto(Bodega bodega) {
		List<ProductoDto> productos = bodega.getProductos()
				.stream()
				.map(this::aDto)
				.toList();
		return new BodegaDto(bodega.getId(), bodega.getNombre(), bodega.getUbicacion(), productos);
	}

	private ProductoDto aDto(Producto p) {
		return new ProductoDto(p.getId(), p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getCantidad());
	}
}