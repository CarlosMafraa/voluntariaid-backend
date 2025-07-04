package voluntariaid_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import voluntariaid_backend.model.Missao;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
}
