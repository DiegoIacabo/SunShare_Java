package br.com.fiap.SunShare.datasource;

import br.com.fiap.SunShare.domainmodel.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
