package com.magazineaziul.controlevendas.service;

import com.magazineaziul.controlevendas.model.Cargo;
import com.magazineaziul.controlevendas.model.Usuario;
import com.magazineaziul.controlevendas.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class UsuarioService {

        @Autowired
        private UsuarioRepository usuarioRepository;
        @Autowired
        private PasswordEncoder encoder;

        public List<Usuario> findByUsuario(String cargo) throws Exception {
            return usuarioRepository.findByCargo(Cargo.valueOf(cargo.toUpperCase()));
        }

        public void createUser(Usuario user){
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
        usuarioRepository.save(user);
    }

        public Usuario findByUsername(String username){
            return usuarioRepository.findByUsername(username);
        }

        public List<Usuario> findAll(){
            return usuarioRepository.findAll();

        }


}
