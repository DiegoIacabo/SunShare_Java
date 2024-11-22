package br.com.fiap.SunShare.service;

import br.com.fiap.SunShare.domainmodel.Locatario;

import java.util.List;

public interface LocatarioService {
    Locatario save(Locatario l);

    void delete(Locatario l);

    void deleteById(long id);

    List<Locatario> findAllLocatarios();
}
