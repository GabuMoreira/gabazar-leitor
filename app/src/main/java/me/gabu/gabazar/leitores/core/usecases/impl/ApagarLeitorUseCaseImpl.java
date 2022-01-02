package me.gabu.gabazar.leitores.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.leitores.adapters.data.dao.LeitorDAO;
import me.gabu.gabazar.leitores.core.usecases.ApagarLeitorUseCase;
import me.gabu.gabazar.leitores.core.usecases.ConsultarLeitorUseCase;

@Slf4j
@Service
public class ApagarLeitorUseCaseImpl implements ApagarLeitorUseCase {

    private @Autowired LeitorDAO dao;
    private @Autowired ConsultarLeitorUseCase consultarUC;

    @Override
    public void run(String leitorId, String usuario) {
        log.info("[USECASE] [DELETE] {}", leitorId);

        dao.delete(consultarUC.run(leitorId));
    }

}
