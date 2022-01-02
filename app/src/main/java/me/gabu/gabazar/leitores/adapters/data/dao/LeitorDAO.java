package me.gabu.gabazar.leitores.adapters.data.dao;

import java.util.Collection;

import me.gabu.gabazar.leitores.core.model.Leitor;

public interface LeitorDAO {

    public Leitor findById(String id);
    public Leitor save(Leitor leitor);
    public Collection<Leitor> listAll();
    public Collection<Leitor> findByNome(String name);
    public Leitor update(Leitor leitor);
    public void delete(Leitor leitor);
}
