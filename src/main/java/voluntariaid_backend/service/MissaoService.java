package voluntariaid_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import voluntariaid_backend.model.Missao;
import voluntariaid_backend.repository.MissaoRepository;

import java.util.List;

@Service
public class MissaoService {
    @Autowired
    private MissaoRepository repository;

    public Missao salvar(Missao missao) {
        return repository.save(missao);
    }

    public List<Missao> listarTodas() {
        return repository.findAll();
    }
}
