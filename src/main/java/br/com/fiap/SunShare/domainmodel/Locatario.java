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
@Table(name = "locatario", uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_locatario_cpf",
                columnNames = "cpf")
})
public class Locatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_locatario")
    private @Getter @Setter Long id;

    @Column(name = "nm_locatario", nullable = false)
    private @Getter @Setter String name;

    @Column(name = "cpf_locatario", nullable = false)
    private @Getter @Setter String cpf;

    @Column(name = "email_locatario", nullable = false)
    private @Getter @Setter String email;

    @Column(name = "telefone_locatario", nullable = false)
    private @Getter @Setter String telefone;

    @Column(name = "consumo_medio_energia", nullable = false)
    private @Getter @Setter float consumoMedioEnergia;

    @Column(name = "distribuidora_locatario", nullable = false)
    private @Getter @Setter String distribuidora;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locatario locatario)) return false;
        return id == locatario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
