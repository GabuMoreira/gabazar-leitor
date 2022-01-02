package me.gabu.gabazar.leitores.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.leitores.adapters.data.dao.LeitorDAO;
import me.gabu.gabazar.leitores.core.model.Leitor;
import me.gabu.gabazar.leitores.core.usecases.AtualizarLeitorUseCase;
import me.gabu.gabazar.leitores.core.usecases.ConsultarLeitorUseCase;
import me.gabu.gabazar.leitores.service.ValidationService;
import me.gabu.gabazar.leitores.service.validations.ValidationEnum;

@Slf4j
@Service
public class AtualizarLeitorUseCaseImpl implements AtualizarLeitorUseCase {

    private @Autowired LeitorDAO dao;
    private @Autowired ConsultarLeitorUseCase consultarUC;
    private @Autowired ValidationService validator;

    @Override
    public Leitor run(Leitor leitor, String usuario) {
        Leitor registroAnterior = consultarUC.run(leitor.getId());

        validator.validate(leitor, ValidationEnum.UPDATE);
        log.info("[USECASE] [UPDATE]\nRegistro anterior: {} \nRegistro recebido:{}", registroAnterior, leitor);

        leitor.setUsuarioAlteracao(usuario);
        leitor.setUsuarioCriacao(registroAnterior.getUsuarioCriacao());
        leitor.setDataCriacao(registroAnterior.getDataCriacao());

        return dao.update(leitor);
    }

}
