package br.com.fiap.SunShare.domainmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato", nullable = false)
    private @Getter @Setter Long id;

    @Column(name = "duracao_contrato", nullable = false)
    private @Getter @Setter int duracaoContrato;

    @Column(name = "quantidade_energia", nullable = false)
    private @Getter @Setter float quantidadeEnergia;

    @Column(name = "preco", nullable = false)
    private @Getter @Setter float preco;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "locador",
            referencedColumnName = "id_locador",
            foreignKey = @ForeignKey(
                    name = "fk_contrato_locador"
            )
//            ,nullable = false
    )
    private @Getter @Setter Locador locador;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "locatario",
            referencedColumnName = "id_locatario",
            foreignKey = @ForeignKey(
                    name = "fk_contrato_locatario"
            )
//            ,
//            nullable = false
    )
    private @Getter @Setter Locatario locatario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contrato contrato)) return false;
        return id == contrato.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
