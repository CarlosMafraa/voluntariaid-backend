package voluntariaid_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import voluntariaid_backend.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
