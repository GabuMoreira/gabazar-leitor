package me.gabu.gabazar.leitores.adapters.html.in.dto;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.gabu.gabazar.leitores.adapters.html.in.dto.mapper.LeitorDTOMapper;
import me.gabu.gabazar.leitores.core.model.Leitor;

@Getter
@Setter
@ToString
public class LeitorDTO {

    private String id;
    private String nome;
    private String documento;
    private String email;
    private String endereco;
    private String usuarioCriacao;
    private String usuarioAlteracao;
    private @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") Date dataCriacao;
    private @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") Date dataAlteracao;

    public Leitor toModel() {
        return LeitorDTOMapper.INSTANCE.dtoToModel(this);
    }

    public static LeitorDTO fromModel(Leitor leitor) {
        return LeitorDTOMapper.INSTANCE.modelToDto(leitor);
    }

    public static Collection<LeitorDTO> fromModel(Collection<Leitor> leitor) {
        return LeitorDTOMapper.INSTANCE.modelToDto(leitor);
    }
}
