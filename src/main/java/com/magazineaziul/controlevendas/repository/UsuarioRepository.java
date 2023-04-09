package com.magazineaziul.controlevendas.repository;

import com.magazineaziul.controlevendas.model.Cargo;
import com.magazineaziul.controlevendas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByCargo(Enum<Cargo> cargo);

	@Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.username = (:username)")
	Usuario findByUsername(String username);

	boolean existsByUsername(String username);

}
