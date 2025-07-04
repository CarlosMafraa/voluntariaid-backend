package voluntariaid_backend.dto.voluntario;

import voluntariaid_backend.model.Missao;
import voluntariaid_backend.model.SituacaoSaudeEnum;
import voluntariaid_backend.model.TipoSanguineoEnum;

import java.time.LocalDate;
import java.util.List;

public class VoluntarioResponseDTO {
    private Long id;
    private String cpf;
    private String passaporte;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private Integer idade;
    private String telefone;
    private String email;
    private TipoSanguineoEnum tipoSanguineo;
    private String profissao;
    private Integer anosExperiencia;
    private SituacaoSaudeEnum situacaoSaude;
    private List<Missao> missoes;

    // Construtor que recebe a entidade Voluntario
    public VoluntarioResponseDTO(voluntariaid_backend.model.Voluntario voluntario) {
        this.id = voluntario.getId();
        this.cpf = voluntario.getCpf();
        this.passaporte = voluntario.getPassaporte();
        this.nomeCompleto = voluntario.getNomeCompleto();
        this.dataNascimento = voluntario.getDataNascimento();
        this.idade = voluntario.getIdade(); // Idade será calculada pelo método getIdade()
        this.telefone = voluntario.getTelefone();
        this.email = voluntario.getEmail();
        this.tipoSanguineo = voluntario.getTipoSanguineo();
        this.profissao = voluntario.getProfissao();
        this.anosExperiencia = voluntario.getAnosExperiencia();
        this.situacaoSaude = voluntario.getSituacaoSaude();
        this.missoes = voluntario.getMissoes();
    }

    // Getters (não precisa de setters pois o DTO é imutável após construção)
    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public TipoSanguineoEnum getTipoSanguineo() {
        return tipoSanguineo;
    }

    public String getProfissao() {
        return profissao;
    }

    public Integer getAnosExperiencia() {
        return anosExperiencia;
    }

    public SituacaoSaudeEnum getSituacaoSaude() {
        return situacaoSaude;
    }

    public List<Missao> getMissoes() {
        return missoes;
    }
}