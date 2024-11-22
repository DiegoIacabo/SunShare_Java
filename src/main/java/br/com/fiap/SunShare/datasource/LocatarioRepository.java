package br.com.fiap.SunShare.datasource;

import br.com.fiap.SunShare.domainmodel.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
}
