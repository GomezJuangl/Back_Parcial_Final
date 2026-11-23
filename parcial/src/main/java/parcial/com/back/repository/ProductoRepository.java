package parcial.com.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parcial.com.back.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}