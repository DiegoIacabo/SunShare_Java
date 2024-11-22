package br.com.fiap.SunShare.datasource;

import br.com.fiap.SunShare.domainmodel.Locador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocadorRepository extends JpaRepository<Locador, Long> {
}
