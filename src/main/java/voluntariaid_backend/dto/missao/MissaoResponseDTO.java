package voluntariaid_backend.dto.missao;


import voluntariaid_backend.model.AvaliacaoEnum;
import voluntariaid_backend.model.Cidade;
import voluntariaid_backend.model.Voluntario;

import java.time.LocalDate;

public class MissaoResponseDTO {
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private AvaliacaoEnum avaliacaoFinal;
    private String parecerCoordenador;
    private Cidade cidade;
    private Voluntario voluntario;

    public MissaoResponseDTO(voluntariaid_backend.model.Missao missao) {
        this.id = missao.getId();
        this.dataInicio = missao.getDataInicio();
        this.dataFim = missao.getDataFim();
        this.avaliacaoFinal = missao.getAvaliacaoFinal();
        this.parecerCoordenador = missao.getParecerCoordenador();
        this.cidade = missao.getCidade();
        this.voluntario = missao.getVoluntario();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public AvaliacaoEnum getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public String getParecerCoordenador() {
        return parecerCoordenador;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }
}
