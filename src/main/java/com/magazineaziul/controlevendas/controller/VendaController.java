package com.magazineaziul.controlevendas.controller;

import com.magazineaziul.controlevendas.model.*;
import com.magazineaziul.controlevendas.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vendas")
@Validated
@AllArgsConstructor
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/{login}")
    public Venda findByVenda(@PathVariable String login) throws Exception {
        return vendaService.findByVenda(login);
    }

}
