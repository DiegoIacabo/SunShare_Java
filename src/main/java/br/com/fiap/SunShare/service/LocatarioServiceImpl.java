package br.com.fiap.SunShare.service;

import br.com.fiap.SunShare.datasource.LocatarioRepository;
import br.com.fiap.SunShare.domainmodel.Locatario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LocatarioServiceImpl implements LocatarioService {

    private LocatarioRepository repo;

    @Override
    @Transactional
    public Locatario save(Locatario l) {
        return this.repo.save(l);
    }

    @Override
    @Transactional
    public void delete(final Locatario l) {
        this.repo.delete(l);
    }

    @Override
    @Transactional
    public void deleteById(final long id) {
        this.repo.deleteById(id);
    }

    @Override
    @Transactional
    public List<Locatario> findAllLocatarios() {
        return this.repo.findAll();
    }

    @Transactional
    public Optional<Locatario> findById(final long id) {
        return this.repo.findById(id);
    }
}
