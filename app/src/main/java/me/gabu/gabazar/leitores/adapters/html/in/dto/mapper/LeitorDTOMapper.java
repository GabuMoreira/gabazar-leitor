package me.gabu.gabazar.leitores.adapters.html.in.dto.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.leitores.adapters.html.in.dto.LeitorDTO;
import me.gabu.gabazar.leitores.core.model.Leitor;

@Mapper
public interface LeitorDTOMapper {

    LeitorDTOMapper INSTANCE = Mappers.getMapper(LeitorDTOMapper.class);

    LeitorDTO leitorToLeitorDto(Leitor leitor);

    Leitor leitorDtoToLeitor(LeitorDTO leitordto);

    Collection<LeitorDTO> leitorToLeitorDto(Collection<Leitor> leitor);

    Collection<Leitor> leitorDtoToLeitor(Collection<LeitorDTO> leitordto);

}
