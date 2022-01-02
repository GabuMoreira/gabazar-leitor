package me.gabu.gabazar.leitores.adapters.data.entity.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.leitores.adapters.data.entity.LeitorEntity;
import me.gabu.gabazar.leitores.core.model.Leitor;

@Mapper
public interface LeitorEntityMapper {

    LeitorEntityMapper INSTANCE = Mappers.getMapper(LeitorEntityMapper.class);

    LeitorEntity leitorToLeitorEntity(Leitor leitor);

    Leitor leitorEntityToLeitor(LeitorEntity leitorEntity);

    Collection<LeitorEntity> leitorToLeitorEntity(Collection<Leitor> leitor);

    Collection<Leitor> leitorEntityToLeitor(Collection<LeitorEntity> leitorEntity);

}
