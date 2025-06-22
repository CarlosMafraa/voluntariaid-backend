package voluntariaid_backend.model;

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
    @JoinColumn(name = "voluntario_id")
    private Voluntario voluntario;
}
