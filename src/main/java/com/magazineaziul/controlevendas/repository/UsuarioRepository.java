package com.magazineaziul.controlevendas.repository;

import com.magazineaziul.controlevendas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);
}
