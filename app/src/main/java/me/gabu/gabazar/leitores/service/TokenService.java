
package me.gabu.gabazar.leitores.service;

public interface TokenService {

    public void validaToken(String token);
    public String recuperarUsuario(String token);
}
