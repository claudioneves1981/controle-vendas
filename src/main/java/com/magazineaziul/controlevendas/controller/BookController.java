package com.magazineaziul.controlevendas.controller;

import com.magazineaziul.controlevendas.model.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Validated
public class BookController {

    @GetMapping("/books")
    List<Venda> findAll() {
        List<Venda> livros = new ArrayList<Venda>(Arrays.asList(
                new Venda(1l, new Usuario(1l, "claudio", "teste", "teste", "teste", new Grupo(1l, "teste", "teste", new Permissao(1l, "teste"))),new Unidade(1l, "teste", "teste", new Usuario()),"teste","teste", true, new BigDecimal(2))
        ));
        return livros;
    }

    @GetMapping("/books2")
    List<Venda> findAll2() {
        List<Venda> livros = new ArrayList<Venda>();
        livros.addAll(
                Arrays.asList(
                        new Venda("Livro 2", new BigDecimal(1))
                ));
        return livros;
    }

}
