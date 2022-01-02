package me.gabu.gabazar.leitores.service;

import me.gabu.gabazar.leitores.core.model.Leitor;
import me.gabu.gabazar.leitores.service.validations.ValidationEnum;

public interface ValidationService {
    public void validate(Leitor leitor, ValidationEnum validation);
}
