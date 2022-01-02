package me.gabu.gabazar.leitores.core.usecases;

import me.gabu.gabazar.leitores.core.model.Leitor;

public interface ConsultarLeitorUseCase {
    Leitor run(String leitorId);
}
