package voluntariaid_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import voluntariaid_backend.dto.missao.MissaoCreateDTO;
import voluntariaid_backend.dto.missao.MissaoResponseDTO;
import voluntariaid_backend.model.AvaliacaoEnum;
import voluntariaid_backend.model.Cidade;
import voluntariaid_backend.model.Missao;
import voluntariaid_backend.model.Voluntario;
import voluntariaid_backend.repository.CidadeRepository;
import voluntariaid_backend.repository.MissaoRepository;
import voluntariaid_backend.repository.VoluntarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    @Autowired
    private MissaoRepository repository;
    @Autowired
    private VoluntarioRepository voluntarioRepository;
    @Autowired

    private CidadeRepository cidadeRepository;

    public MissaoResponseDTO salvar(MissaoCreateDTO missaoDTO) {

        Voluntario voluntario = voluntarioRepository.findById(missaoDTO.getVoluntarioId())
                .orElseThrow(() -> new RuntimeException("Voluntário não encontrado"));

        Cidade cidade = cidadeRepository.findById(missaoDTO.getCidadeId())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        Missao missao = new Missao();
        missao.setDataInicio(missaoDTO.getDataInicio());
        missao.setDataFim(missaoDTO.getDataFim());
        missao.setAvaliacaoFinal(AvaliacaoEnum.valueOf(missaoDTO.getAvaliacaoFinal()));
        missao.setParecerCoordenador(missaoDTO.getParecerCoordenador());
        missao.setCidade(cidade);
        missao.setVoluntario(voluntario);

        Missao missaoSalva = repository.save(missao);
        return new MissaoResponseDTO(missaoSalva);
    }

    @Transactional(readOnly = true)
    public Page<MissaoResponseDTO> listarTodas(Pageable pageable) {
        return repository.findAll(pageable)
                .map(MissaoResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public MissaoResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(MissaoResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Missão não encontrada"));
    }

    @Transactional
    public void deletarMissao(Long missaoId) {
        if (!repository.existsById(missaoId)) {
            throw new RuntimeException("Missão não encontrada com o ID: " + missaoId);
        }
        repository.deleteById(missaoId);
    }
}