package com.magazineaziul.controlevendas.service;

import com.magazineaziul.controlevendas.model.Cargo;
import com.magazineaziul.controlevendas.model.Usuario;
import com.magazineaziul.controlevendas.model.Venda;
import com.magazineaziul.controlevendas.repository.UsuarioRepository;
import com.magazineaziul.controlevendas.repository.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
    public class UsuarioService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        public List<Usuario> findByUsuario(Cargo cargo) throws Exception {
            return usuarioRepository.findByCargo(cargo);
        }

        public Usuario findByLogin(String login){
            return usuarioRepository.findByLogin(login);
        }


}
