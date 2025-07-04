package voluntariaid_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voluntariaid_backend.model.Pais;
import voluntariaid_backend.repository.PaisRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository repository;

    public List<Pais> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pais> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Pais salvar(Pais pais) {
        return repository.save(pais);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
