package voluntariaid_backend.dto.missao;

import java.time.LocalDate;


public class MissaoCreateDTO {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String avaliacaoFinal;
    private String parecerCoordenador;
    private Long cidadeId;
    private Long voluntarioId;

    public MissaoCreateDTO() {
    }

    public MissaoCreateDTO(LocalDate dataInicio, LocalDate dataFim, String avaliacaoFinal,
                           String parecerCoordenador, Long cidadeId, Long voluntarioId) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.avaliacaoFinal = avaliacaoFinal;
        this.parecerCoordenador = parecerCoordenador;
        this.cidadeId = cidadeId;
        this.voluntarioId = voluntarioId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public void setAvaliacaoFinal(String avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }

    public String getParecerCoordenador() {
        return parecerCoordenador;
    }

    public void setParecerCoordenador(String parecerCoordenador) {
        this.parecerCoordenador = parecerCoordenador;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Long getVoluntarioId() {
        return voluntarioId;
    }

    public void setVoluntarioId(Long voluntarioId) {
        this.voluntarioId = voluntarioId;
    }
}
