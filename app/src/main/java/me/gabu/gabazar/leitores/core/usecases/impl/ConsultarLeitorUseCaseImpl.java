package me.gabu.gabazar.leitores.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabu.gabazar.leitores.adapters.data.dao.LeitorDAO;
import me.gabu.gabazar.leitores.core.model.Leitor;
import me.gabu.gabazar.leitores.core.usecases.ConsultarLeitorUseCase;

@Service
public class ConsultarLeitorUseCaseImpl implements ConsultarLeitorUseCase {

    private @Autowired LeitorDAO dao;

    @Override
    public Leitor run(String leitorId) {
        return dao.findById(leitorId);
    }

}
