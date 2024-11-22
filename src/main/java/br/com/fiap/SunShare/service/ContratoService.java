package br.com.fiap.SunShare.service;

import br.com.fiap.SunShare.domainmodel.Contrato;
import br.com.fiap.SunShare.domainmodel.Locatario;

import java.util.List;

public interface ContratoService {

    Contrato save(Contrato c);

    void delete(Contrato c);

    void deleteById(long id);

    List<Contrato> findAllContratos();
}
