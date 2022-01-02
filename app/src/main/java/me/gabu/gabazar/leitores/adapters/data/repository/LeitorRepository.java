package me.gabu.gabazar.leitores.adapters.data.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.gabu.gabazar.leitores.adapters.data.entity.LeitorEntity;

@Repository
public interface LeitorRepository extends JpaRepository<LeitorEntity, String> {

    Collection<LeitorEntity> findByNome(String nome);
}
