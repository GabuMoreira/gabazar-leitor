package me.gabu.gabazar.leitores.core.usecases;

import java.util.Collection;

import me.gabu.gabazar.leitores.core.model.Leitor;

public interface ListarLeitoresUseCase {
    Collection<Leitor> run(String nome);
}
