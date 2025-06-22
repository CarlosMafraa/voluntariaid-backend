package voluntariaid_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import voluntariaid_backend.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
