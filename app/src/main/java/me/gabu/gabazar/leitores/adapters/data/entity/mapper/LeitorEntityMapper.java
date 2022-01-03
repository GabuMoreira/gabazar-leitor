package me.gabu.gabazar.leitores.adapters.data.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.leitores.adapters.data.entity.LeitorEntity;
import me.gabu.gabazar.leitores.core.model.Leitor;

@Mapper
public interface LeitorEntityMapper extends EntityMapper<LeitorEntity, Leitor> {

    LeitorEntityMapper INSTANCE = Mappers.getMapper(LeitorEntityMapper.class);

}
