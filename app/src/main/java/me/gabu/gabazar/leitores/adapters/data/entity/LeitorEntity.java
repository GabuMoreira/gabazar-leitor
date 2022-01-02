package me.gabu.gabazar.leitores.adapters.data.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Entity
@Slf4j
@ToString
@Table(name = "TBGB_LEIT")
public class LeitorEntity {

    @Id
    private String id;
    private String nome;
    private String email;
    private String documento;
    private String endereco;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuarioCriacao;
    private String usuarioAlteracao;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID().toString();
        dataCriacao = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        dataAlteracao = new Date();
    }

    @PostPersist
    public void postPersist() {
        log.info("[ENTITY] [POS-PERSIST] Usuario {} cadastrou o leitor {}", usuarioCriacao, this);
    }

    @PostUpdate
    public void postUpdate() {
        log.info("[ENTITY] [POS-UPDATE] Usuario {} atualizou os dados do leitor {}", usuarioAlteracao, this);
    }

    @PostRemove
    public void postRemoval() {
        log.info("[ENTITY] [POS-REMOVAL] Usuario {} apagou o leitor {}", usuarioAlteracao, this);
    }

}
