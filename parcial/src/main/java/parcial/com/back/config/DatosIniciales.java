package parcial.com.back.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import parcial.com.back.entity.Bodega;
import parcial.com.back.entity.Producto;
import parcial.com.back.repository.BodegaRepository;
import parcial.com.back.repository.ProductoRepository;

@Configuration
public class DatosIniciales {

	@Bean
	CommandLineRunner cargarDatos(BodegaRepository bodegaRepository, ProductoRepository productoRepository) {
		return args -> {
			if (bodegaRepository.count() == 0) {
				Bodega norte = bodegaRepository.save(new Bodega("Bodega Norte", "Calle 170 # 15-20, Bogotá"));
				Bodega sur = bodegaRepository.save(new Bodega("Bodega Sur", "Autopista Sur # 60-45, Bogotá"));

				productoRepository.save(new Producto("Computador portátil", "Portátil de 14 pulgadas",
						new BigDecimal("2500000"), 15, norte));
				productoRepository.save(new Producto("Monitor", "Monitor de 24 pulgadas",
						new BigDecimal("750000"), 20, norte));
				productoRepository.save(new Producto("Impresora", "Impresora multifuncional",
						new BigDecimal("1200000"), 8, sur));
			}
		};
	}
}