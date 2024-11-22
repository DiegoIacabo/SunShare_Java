package br.com.fiap.SunShare.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "locador", uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_locador_cpf",
                columnNames = "cpf")
})
public class Locador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_locador")
    private @Getter @Setter Long id;

    @Column(name = "nm_locador", nullable = false)
    private @Getter @Setter String name;

    @Column(name = "cpf_locador", nullable = false)
    private @Getter @Setter String cpf;

    @Column(name = "email_locador", nullable = false)
    private @Getter @Setter String email;

    @Column(name = "telefone_locador", nullable = false)
    private @Getter @Setter String telefone;

    @Column(name = "energia_gerada", nullable = false)
    private @Getter @Setter float energiaGerada;

    @Column(name = "energia_disponivel", nullable = false)
    private @Getter @Setter float energiaDisponivel;

    @Column(name = "distribuidora_locador", nullable = false)
    private @Getter @Setter String distribuidora;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locador locador)) return false;
        return id == locador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
