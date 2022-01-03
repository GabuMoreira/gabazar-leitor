package me.gabu.gabazar.leitores.adapters.data.entity;

import java.util.Collection;
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
import me.gabu.gabazar.leitores.adapters.data.entity.mapper.LeitorEntityMapper;
import me.gabu.gabazar.leitores.core.model.Leitor;

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

    public Leitor toModel() {
        return LeitorEntityMapper.INSTANCE.entityToModel(this);
    }

    public static Collection<Leitor> toModel(Collection<LeitorEntity> leitores) {
        return LeitorEntityMapper.INSTANCE.entityToModel(leitores);
    }

    public static LeitorEntity fromModel(Leitor leitor) {
        return LeitorEntityMapper.INSTANCE.modelToEntity(leitor);
    }

    public static Collection<LeitorEntity> fromModel(Collection<Leitor> leitor) {
        return LeitorEntityMapper.INSTANCE.modelToEntity(leitor);
    }
}
