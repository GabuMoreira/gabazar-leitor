package me.gabu.gabazar.leitores.core.usecases;

import me.gabu.gabazar.leitores.core.model.Leitor;

public interface CriarLeitorUseCase {
    Leitor run(Leitor leitor, String usuario);
}
