package me.gabu.gabazar.leitores.service.impl;

import org.springframework.stereotype.Service;

import me.gabu.gabazar.leitores.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String recuperarUsuario(String token) {
        return token;
    }

    @Override
    public void validaToken(String token) {
    }

}
