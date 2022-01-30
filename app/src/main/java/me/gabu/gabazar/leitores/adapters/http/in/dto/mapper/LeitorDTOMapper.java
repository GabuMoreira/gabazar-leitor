package me.gabu.gabazar.leitores.adapters.http.in.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.leitores.adapters.http.in.dto.LeitorDTO;
import me.gabu.gabazar.leitores.core.model.Leitor;

@Mapper
public interface LeitorDTOMapper extends DTOMapper<LeitorDTO, Leitor> {

    LeitorDTOMapper INSTANCE = Mappers.getMapper(LeitorDTOMapper.class);

}
