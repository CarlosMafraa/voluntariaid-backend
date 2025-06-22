package voluntariaid_backend.model;

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
    private List<Missao> missoes;

    public Integer getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }
}
