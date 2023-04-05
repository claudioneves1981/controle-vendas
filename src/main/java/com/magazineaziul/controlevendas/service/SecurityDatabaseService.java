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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityDatabaseService implements UserDetailsService {
    @Autowired
    private UsuarioRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
        Usuario userEntity = userRepository.findByLogin(username);
        if(userEntity == null){
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        userEntity.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role)));

        return new org.springframework.security.core.userdetails.User(userEntity.getLogin(),
                userEntity.getSenha(),
                authorities);
    }
}
