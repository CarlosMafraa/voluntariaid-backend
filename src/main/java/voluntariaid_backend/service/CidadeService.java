package voluntariaid_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voluntariaid_backend.model.Cidade;
import voluntariaid_backend.repository.CidadeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository repository;

    public List<Cidade> listarTodas() {
        return repository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Cidade salvar(Cidade cidade) {
        return repository.save(cidade);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
