package com.magazineaziul.controlevendas.controller;

import com.magazineaziul.controlevendas.model.Cargo;
import com.magazineaziul.controlevendas.model.Usuario;
import com.magazineaziul.controlevendas.model.Venda;
import com.magazineaziul.controlevendas.service.UsuarioService;
import com.magazineaziul.controlevendas.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@Validated
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{cargo}")
    public List<Usuario> findByLogin(@PathVariable Cargo cargo) throws Exception {
        return usuarioService.findByUsuario(cargo);
    }
}
