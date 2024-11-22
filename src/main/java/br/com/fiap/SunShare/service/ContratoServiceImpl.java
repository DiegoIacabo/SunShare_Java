package br.com.fiap.SunShare.service;

import br.com.fiap.SunShare.datasource.ContratoRepository;
import br.com.fiap.SunShare.domainmodel.Contrato;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContratoServiceImpl implements ContratoService {

    private ContratoRepository repo;

    @Override
    @Transactional
    public Contrato save(Contrato c) {
        return this.repo.save(c);
    }

    @Override
    @Transactional
    public void delete(final Contrato c) {
        this.repo.delete(c);
    }

    @Override
    @Transactional
    public void deleteById(final long id) {
        this.repo.deleteById(id);
    }

    @Override
    @Transactional
    public List<Contrato> findAllContratos() {
        return this.repo.findAll();
    }

    @Transactional
    public Optional<Contrato> findById(final long id) {
        return this.repo.findById(id);
    }
}
