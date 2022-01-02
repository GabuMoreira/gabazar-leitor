package me.gabu.gabazar.leitores.adapters.data.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.leitores.adapters.data.dao.LeitorDAO;
import me.gabu.gabazar.leitores.adapters.data.entity.LeitorEntity;
import me.gabu.gabazar.leitores.adapters.data.entity.mapper.LeitorEntityMapper;
import me.gabu.gabazar.leitores.adapters.data.repository.LeitorRepository;
import me.gabu.gabazar.leitores.core.exceptions.NotFoundException;
import me.gabu.gabazar.leitores.core.model.Leitor;

@Slf4j
@Service
public class LeitorDAOImpl implements LeitorDAO {

    private @Autowired LeitorRepository repository;
    private LeitorEntityMapper mapper = LeitorEntityMapper.INSTANCE;

    @Override
    public Leitor findById(String id) {
        LeitorEntity enditoraEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Leitor não encontrada"));
        return mapper.leitorEntityToLeitor(enditoraEntity);
    }

    @Override
    public Leitor save(Leitor leitor) {
        LeitorEntity enditoraEntity = mapper.leitorToLeitorEntity(leitor);
        log.info("[DAO] [PERSIST] [{}]", leitor);
        return mapper.leitorEntityToLeitor(repository.save(enditoraEntity));
    }

    @Override
    public Collection<Leitor> listAll() {
        return mapper.leitorEntityToLeitor(repository.findAll());
    }

    @Override
    public Collection<Leitor> findByNome(String name) {
        return mapper.leitorEntityToLeitor(repository.findByNome(name));
    }

    @Override
    public Leitor update(Leitor leitor) {
        LeitorEntity enditoraEntity = mapper.leitorToLeitorEntity(leitor);
        log.info("[DAO] [UPDATE] [{}]", leitor);
        return mapper.leitorEntityToLeitor(repository.save(enditoraEntity));
    }

    @Override
    public void delete(Leitor leitor) {
        repository.deleteById(leitor.getId());
    }

}
