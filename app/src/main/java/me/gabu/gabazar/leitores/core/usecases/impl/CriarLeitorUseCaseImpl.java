package me.gabu.gabazar.leitores.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.leitores.adapters.data.dao.LeitorDAO;
import me.gabu.gabazar.leitores.core.model.Leitor;
import me.gabu.gabazar.leitores.core.usecases.CriarLeitorUseCase;
import me.gabu.gabazar.leitores.service.ValidationService;
import me.gabu.gabazar.leitores.service.validations.ValidationEnum;

@Slf4j
@Service
public class CriarLeitorUseCaseImpl implements CriarLeitorUseCase {

    private @Autowired LeitorDAO dao;
    private @Autowired ValidationService validator;

    @Override
    public Leitor run(Leitor leitor, String usuario) {
        log.info("[USECASE] [CREATE] {}", leitor);
        validator.validate(leitor, ValidationEnum.CREATE);
        leitor.setUsuarioCriacao(usuario);
        return dao.save(leitor);
    }

}
