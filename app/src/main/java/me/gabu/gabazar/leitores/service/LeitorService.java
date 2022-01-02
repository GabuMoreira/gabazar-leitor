
package me.gabu.gabazar.leitores.service;

import java.util.Collection;

import me.gabu.gabazar.leitores.core.model.Leitor;

public interface LeitorService {

    public Leitor criarLeitor(Leitor leitor, String usuario);

    public Leitor consultarLeitor(String leitorId);

    public Leitor atualizarLeitor(Leitor leitor, String usuario);

    public Collection<Leitor> listarLeitores(String nome);

    public void apagarLeitor(String leitorId, String usuario);

}
