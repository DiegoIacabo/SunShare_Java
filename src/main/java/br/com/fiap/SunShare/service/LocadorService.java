package br.com.fiap.SunShare.service;

import br.com.fiap.SunShare.domainmodel.Locador;

import java.util.List;

public interface LocadorService {

    Locador save(Locador l);

    void delete(Locador l);

    void deleteById(long id);

    List<Locador> findAllLocadores();
}
