package br.com.fiap.SunShare.service;

import br.com.fiap.SunShare.datasource.LocadorRepository;
import br.com.fiap.SunShare.domainmodel.Locador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LocadorServiceImpl implements LocadorService {

    private LocadorRepository repo;
    @Override
    @Transactional
    public Locador save(Locador l) {
        return this.repo.save(l);
    }

    @Override
    @Transactional
    public void delete(final Locador l) {
        this.repo.delete(l);
    }

    @Override
    @Transactional
    public void deleteById(final long id) {
        this.repo.deleteById(id);
    }

    @Override
    @Transactional
    public List<Locador> findAllLocadores() {
        return this.repo.findAll();
    }

    @Transactional
    public Optional<Locador> findById(final long id) {
        return this.repo.findById(id);
    }
}
