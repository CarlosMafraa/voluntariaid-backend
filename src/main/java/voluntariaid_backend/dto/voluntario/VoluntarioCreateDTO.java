package voluntariaid_backend.dto.voluntario;

import voluntariaid_backend.model.SituacaoSaudeEnum;
import voluntariaid_backend.model.TipoSanguineoEnum;

import java.time.LocalDate;

public class VoluntarioCreateDTO {
    private String cpf;
    private String passaporte;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private TipoSanguineoEnum tipoSanguineo;
    private String profissao;
    private Integer anosExperiencia;
    private SituacaoSaudeEnum situacaoSaude;

    // Construtores
    public VoluntarioCreateDTO() {
    }

    public VoluntarioCreateDTO(String cpf, String passaporte, String nomeCompleto, LocalDate dataNascimento,
                               String telefone, String email, TipoSanguineoEnum tipoSanguineo,
                               String profissao, Integer anosExperiencia, SituacaoSaudeEnum situacaoSaude) {
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.tipoSanguineo = tipoSanguineo;
        this.profissao = profissao;
        this.anosExperiencia = anosExperiencia;
        this.situacaoSaude = situacaoSaude;
    }

    // Getters e Setters
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
}