package voluntariaid_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Missao  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    private AvaliacaoEnum avaliacaoFinal;

    @Column(length = 500)
    private String parecerCoordenador;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "voluntario_id")
    private Voluntario voluntario;

    public Missao() {
    }

    public Missao(Long id, LocalDate dataInicio, LocalDate dataFim, AvaliacaoEnum avaliacaoFinal, String parecerCoordenador, Cidade cidade, Voluntario voluntario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.avaliacaoFinal = avaliacaoFinal;
        this.parecerCoordenador = parecerCoordenador;
        this.cidade = cidade;
        this.voluntario = voluntario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AvaliacaoEnum getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public void setAvaliacaoFinal(AvaliacaoEnum avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }

    public String getParecerCoordenador() {
        return parecerCoordenador;
    }

    public void setParecerCoordenador(String parecerCoordenador) {
        this.parecerCoordenador = parecerCoordenador;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }
}
