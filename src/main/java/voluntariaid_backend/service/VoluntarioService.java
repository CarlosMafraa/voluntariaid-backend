package voluntariaid_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voluntariaid_backend.model.Voluntario;
import voluntariaid_backend.repository.VoluntarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntarioService {
    @Autowired
    private VoluntarioRepository repository;

    public Voluntario salvar(Voluntario voluntario) {
        if (repository.findByCpf(voluntario.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado.");
        }
        if (repository.findByPassaporte(voluntario.getPassaporte()).isPresent()) {
            throw new RuntimeException("Passaporte já cadastrado.");
        }
        return repository.save(voluntario);
    }

    public List<Voluntario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Voluntario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
