package com.magazineaziul.controlevendas.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serial;
import java.util.Collection;

public class UsuarioSistema extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String nome;

    public UsuarioSistema(String nome, String login, String senha, Collection<? extends GrantedAuthority> authorities) {
        super(login, senha, authorities);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}