package com.magazineaziul.controlevendas.service;

import com.magazineaziul.controlevendas.model.Usuario;
import com.magazineaziul.controlevendas.repository.UsuarioRepository;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        Usuario usuario = usuarioRepository.findByLogin(login);
        System.out.print(usuario);
        if (usuario == null) {
            throw new Exception("User " + login + " was not found in the database");
        }

        return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));

     }
        public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
            return authorities(List.of(usuario.getCargo().getDescricao().split(" ")));
        }

        public Collection<? extends GrantedAuthority> authorities(List<String> grupos) {
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (String grupo : grupos) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(grupo);
                grantedAuthorities.add(grantedAuthority);
            }
            return grantedAuthorities;
        }
}
