package tech.ada.filmes_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false)
    private Integer anoLancamento;

    @Column(nullable = false, length = 100)
    private String diretor;

    @Column(nullable = false, length = 50)
    private String genero;

    @Column(columnDefinition = "TEXT")
    private String sinopse;
}
