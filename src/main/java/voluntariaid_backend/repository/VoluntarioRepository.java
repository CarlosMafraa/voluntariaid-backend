package voluntariaid_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import voluntariaid_backend.model.Voluntario;

import java.util.Optional;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
    Optional<Voluntario> findByCpf(String cpf);
    Optional<Voluntario> findByPassaporte(String passaporte);
}
