package voluntariaid_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String passaporte;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Transient
    private Integer idade;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSanguineoEnum tipoSanguineo;

    @Column(nullable = false)
    private String profissao;

    @Column(nullable = false)
    private Integer anosExperiencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoSaudeEnum situacaoSaude;

    @OneToMany(mappedBy = "voluntario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Missao> missoes;

    public Integer getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public Voluntario(Long id,
                      String cpf,
                      String passaporte,
                      String nomeCompleto,
                      LocalDate dataNascimento,
                      Integer idade,
                      String telefone,
                      String email,
                      TipoSanguineoEnum tipoSanguineo,
                      String profissao,
                      Integer anosExperiencia,
                      SituacaoSaudeEnum situacaoSaude,
                      List<Missao> missoes) {
        this.id = id;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.tipoSanguineo = tipoSanguineo;
        this.profissao = profissao;
        this.anosExperiencia = anosExperiencia;
        this.situacaoSaude = situacaoSaude;
        this.missoes = missoes;
    }

    public Voluntario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoSanguineoEnum getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineoEnum tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Integer getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(Integer anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public SituacaoSaudeEnum getSituacaoSaude() {
        return situacaoSaude;
    }

    public void setSituacaoSaude(SituacaoSaudeEnum situacaoSaude) {
        this.situacaoSaude = situacaoSaude;
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<Missao> missoes) {
        this.missoes = missoes;
    }
}
