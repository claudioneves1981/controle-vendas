package com.magazineaziul.controlevendas.service;

import com.magazineaziul.controlevendas.model.Venda;
import com.magazineaziul.controlevendas.repository.VendaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda findByVenda(String login) throws Exception {
        return vendaRepository.findByUsuario(login);
    }
}
