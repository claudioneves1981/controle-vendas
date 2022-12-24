package com.magazineaziul.controlevendas.repository;

import com.magazineaziul.controlevendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

   // @Query("SELECT v FROM Venda v " +
   //         "WHERE v.usuario u " +
   //         "JOIN u.login = :login " +
   //         "JOIN u.senha = :senha " +
   //         "JOIN u.grupo.id >= :id")
     Venda findByUsuario(String login);

}
