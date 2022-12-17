package com.magazineaziul.controlevendas.repository;

import com.magazineaziul.controlevendas.model.Grupo;
import com.magazineaziul.controlevendas.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(List<Grupo> grupo);

}
