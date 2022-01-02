package me.gabu.gabazar.leitores.core.usecases.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import me.gabu.gabazar.leitores.adapters.data.dao.LeitorDAO;
import me.gabu.gabazar.leitores.core.model.Leitor;
import me.gabu.gabazar.leitores.core.usecases.ListarLeitoresUseCase;

@Service
public class ListarLeitoresUseCaseImpl implements ListarLeitoresUseCase {

    private @Autowired LeitorDAO dao;

    @Override
    public Collection<Leitor> run(String nome) {

        if (StringUtils.hasLength(nome))
            return dao.findByNome(nome);

        return dao.listAll();
    }

}
