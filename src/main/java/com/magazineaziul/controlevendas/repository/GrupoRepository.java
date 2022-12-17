package com.magazineaziul.controlevendas.repository;

import com.magazineaziul.controlevendas.model.Grupo;
import com.magazineaziul.controlevendas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByUsuariosIn(List<Usuario> usuario);

}
