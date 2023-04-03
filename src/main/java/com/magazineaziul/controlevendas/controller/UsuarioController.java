package com.magazineaziul.controlevendas.controller;

import com.magazineaziul.controlevendas.model.Cargo;
import com.magazineaziul.controlevendas.model.Usuario;
import com.magazineaziul.controlevendas.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/users")
    public List<Usuario> users(){
        return usuarioService.findAll();
    }

    @GetMapping("/managers/{manager}")
    public List<Usuario> managers(@PathVariable String manager) throws Exception {
        return usuarioService.findByUsuario(manager);

    }

    @GetMapping("/directories/{directory}")
    public List<Usuario> directories(@PathVariable String directory) throws Exception {
        return usuarioService.findByUsuario(directory);
    }


    @GetMapping("/admin/{admin}")
    public List<Usuario> admin(@PathVariable String admin) throws Exception {
        return usuarioService.findByUsuario(admin);
    }
}
