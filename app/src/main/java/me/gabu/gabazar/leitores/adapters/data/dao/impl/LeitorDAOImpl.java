package me.gabu.gabazar.leitores.adapters.data.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.leitores.adapters.data.dao.LeitorDAO;
import me.gabu.gabazar.leitores.adapters.data.entity.LeitorEntity;
import me.gabu.gabazar.leitores.adapters.data.repository.LeitorRepository;
import me.gabu.gabazar.leitores.core.exceptions.NotFoundException;
import me.gabu.gabazar.leitores.core.model.Leitor;

@Slf4j
@Service
public class LeitorDAOImpl implements LeitorDAO {

    private @Autowired LeitorRepository repository;

    @Override
    public Leitor findById(String id) {
        LeitorEntity enditoraEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Leitor não encontrada"));
        return enditoraEntity.toModel();
    }

    @Override
    public Leitor save(Leitor leitor) {
        log.info("[DAO] [PERSIST] [{}]", leitor);
        return repository.save(LeitorEntity.fromModel(leitor)).toModel();
    }

    @Override
    public Collection<Leitor> listAll() {
        return LeitorEntity.toModel(repository.findAll());
    }

    @Override
    public Collection<Leitor> findByNome(String name) {
        return LeitorEntity.toModel(repository.findByNome(name));
    }

    @Override
    public Leitor update(Leitor leitor) {
        log.info("[DAO] [UPDATE] [{}]", leitor);
        return repository.save(LeitorEntity.fromModel(leitor)).toModel();
    }

    @Override
    public void delete(Leitor leitor) {
        repository.deleteById(leitor.getId());
    }

}
