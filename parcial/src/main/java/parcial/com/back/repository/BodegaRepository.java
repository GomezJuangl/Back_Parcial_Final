package parcial.com.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parcial.com.back.entity.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega, Long> {
}