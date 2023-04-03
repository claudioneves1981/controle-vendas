package com.magazineaziul.controlevendas.component;

import com.magazineaziul.controlevendas.model.Cargo;
import com.magazineaziul.controlevendas.model.Usuario;
import com.magazineaziul.controlevendas.repository.UsuarioRepository;
import com.magazineaziul.controlevendas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StartApplication  implements CommandLineRunner {
    @Autowired
    private UsuarioRepository repository;
    @Transactional
    @Override
    public void run(String... args) throws Exception{
        List<Usuario> user = repository.findByCargo(Cargo.DIRETORGERAL);
        for (Usuario usuario : user) {
            if (usuario != null) {
                assert false;
                usuario.getRoles().add("USERS");
                usuario.getRoles().add("ADMIN");
                repository.save(usuario);
            }
        }
        user = repository.findByCargo(Cargo.DIRETOR);
        for (Usuario usuario : user) {
            if (usuario != null) {
                assert false;
                usuario.getRoles().add("USERS");
                usuario.getRoles().add("DIRECTORS");
                repository.save(usuario);
            }
        }
        user = repository.findByCargo(Cargo.GERENTE);
        for (Usuario usuario : user) {
            if (usuario != null) {
                assert false;
                usuario.getRoles().add("USERS");
                usuario.getRoles().add("MANAGERS");
                repository.save(usuario);
            }
        }
        user = repository.findByCargo(Cargo.VENDEDOR);
        for (Usuario usuario : user) {
            if (usuario != null) {
                assert false;
                usuario.getRoles().add("USERS");
                repository.save(usuario);
            }
        }
    }
}