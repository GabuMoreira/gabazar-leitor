package me.gabu.gabazar.leitores.adapters.html.in.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

}
