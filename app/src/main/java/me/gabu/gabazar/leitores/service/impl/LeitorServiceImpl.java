package me.gabu.gabazar.leitores.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabu.gabazar.leitores.core.model.Leitor;
import me.gabu.gabazar.leitores.core.usecases.ApagarLeitorUseCase;
import me.gabu.gabazar.leitores.core.usecases.AtualizarLeitorUseCase;
import me.gabu.gabazar.leitores.core.usecases.ConsultarLeitorUseCase;
import me.gabu.gabazar.leitores.core.usecases.CriarLeitorUseCase;
import me.gabu.gabazar.leitores.core.usecases.ListarLeitoresUseCase;
import me.gabu.gabazar.leitores.service.LeitorService;

@Service
public class LeitorServiceImpl implements LeitorService {

    private @Autowired CriarLeitorUseCase criarLeitor;
    private @Autowired ConsultarLeitorUseCase consultarLeitor;
    private @Autowired AtualizarLeitorUseCase atualizarLeitor;
    private @Autowired ListarLeitoresUseCase listarLeitores;
    private @Autowired ApagarLeitorUseCase apagarLeitor;

    @Override
    public Leitor criarLeitor(Leitor leitor, String usuario) {
        return criarLeitor.run(leitor, usuario);
    }

    @Override
    public Leitor consultarLeitor(String leitorId) {
        return consultarLeitor.run(leitorId);
    }

    @Override
    public Leitor atualizarLeitor(Leitor leitor, String usuario) {
        return atualizarLeitor.run(leitor, usuario);
    }

    @Override
    public Collection<Leitor> listarLeitores(String nome) {
        return listarLeitores.run(nome);
    }

    @Override
    public void apagarLeitor(String leitorId, String usuario) {
        apagarLeitor.run(leitorId, usuario);
    }

}
