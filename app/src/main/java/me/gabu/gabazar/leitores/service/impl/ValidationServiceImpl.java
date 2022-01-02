package me.gabu.gabazar.leitores.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import me.gabu.gabazar.leitores.core.exceptions.BadRequestException;
import me.gabu.gabazar.leitores.core.model.Leitor;
import me.gabu.gabazar.leitores.service.ValidationService;
import me.gabu.gabazar.leitores.service.validations.Create;
import me.gabu.gabazar.leitores.service.validations.Update;
import me.gabu.gabazar.leitores.service.validations.ValidationEnum;

@Service
public class ValidationServiceImpl implements ValidationService {

    private @Autowired Validator validator;

    @Override
    public void validate(Leitor leitor, ValidationEnum validation) {

        Set<ConstraintViolation<Leitor>> contraints = getContraints(leitor, validation);

        if (!CollectionUtils.isEmpty(contraints))
            throw new BadRequestException(processaContraint(contraints));

    }

    private Set<ConstraintViolation<Leitor>> getContraints(Leitor leitor, ValidationEnum validation) {
        switch (validation) {
        case CREATE:
            return validator.validate(leitor, Create.class);

        case UPDATE:
        default:
            return validator.validate(leitor, Update.class);
        }
    }

    private List<String> processaContraint(Set<ConstraintViolation<Leitor>> contraints) {
        return contraints.stream()
                .map(violation -> String.format("[%s %s]",
                        StreamSupport.stream(violation.getPropertyPath().spliterator(), false)
                                .reduce((first, second) -> second).orElse(null),
                        violation.getMessage()))
                .collect(Collectors.toList());
    }

}
