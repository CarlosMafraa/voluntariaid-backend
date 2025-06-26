package voluntariaid_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voluntariaid_backend.dto.voluntario.VoluntarioCreateDTO;
import voluntariaid_backend.dto.voluntario.VoluntarioResponseDTO;
import voluntariaid_backend.model.Voluntario;
import voluntariaid_backend.repository.VoluntarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository repository;

    public VoluntarioResponseDTO salvar(VoluntarioCreateDTO dto) {
        if (repository.findByCpf(dto.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        if (repository.findByPassaporte(dto.getPassaporte()).isPresent()) {
            throw new RuntimeException("Passaporte já cadastrado");
        }

        if (dto.getAnosExperiencia() < 3) {
            throw new IllegalArgumentException("Mínimo 3 anos de experiência requeridos");
        }

        Voluntario voluntario = getVoluntario(dto);
        Voluntario voluntarioSalvo = repository.save(voluntario);
        return new VoluntarioResponseDTO(voluntarioSalvo);

    }

    private static Voluntario getVoluntario(VoluntarioCreateDTO dto) {
        Voluntario voluntario = new Voluntario();
        voluntario.setCpf(dto.getCpf());
        voluntario.setPassaporte(dto.getPassaporte());
        voluntario.setNomeCompleto(dto.getNomeCompleto());
        voluntario.setDataNascimento(dto.getDataNascimento());
        voluntario.setTelefone(dto.getTelefone());
        voluntario.setEmail(dto.getEmail());
        voluntario.setTipoSanguineo(dto.getTipoSanguineo());
        voluntario.setProfissao(dto.getProfissao());
        voluntario.setAnosExperiencia(dto.getAnosExperiencia());
        voluntario.setSituacaoSaude(dto.getSituacaoSaude());
        return voluntario;
    }

    @Transactional(readOnly = true)
    public Page<VoluntarioResponseDTO> listarTodos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(VoluntarioResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public VoluntarioResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(VoluntarioResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Voluntário não encontrado"));
    }
    @Transactional
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Voluntário não encontrado");
        }
        repository.deleteById(id);
    }
}
