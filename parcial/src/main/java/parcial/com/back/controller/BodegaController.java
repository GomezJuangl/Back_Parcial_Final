package parcial.com.back.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import parcial.com.back.dto.BodegaDto;
import parcial.com.back.dto.BodegaRequest;
import parcial.com.back.service.BodegaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

	private final BodegaService bodegaService;

	public BodegaController(BodegaService bodegaService) {
		this.bodegaService = bodegaService;
	}

	@GetMapping
	public ResponseEntity<List<BodegaDto>> listar() {
		return ResponseEntity.ok(bodegaService.listar());
	}

	@PostMapping
	public ResponseEntity<BodegaDto> registrar(@Valid @RequestBody BodegaRequest request) {
		BodegaDto creada = bodegaService.registrar(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(creada.getId())
				.toUri();
		return ResponseEntity.created(location).body(creada);
	}
}