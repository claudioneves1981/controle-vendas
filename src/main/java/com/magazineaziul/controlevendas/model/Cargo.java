package com.magazineaziul.controlevendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public enum Cargo implements Serializable {

    TESTE(0L,"TESTE"),
    DIRETORGERAL(1L, "DIRETORGERAL"),
    DIRETOR(2L, "DIRETOR"),
    GERENTE(3L,"GERENTE"),
    VENDEDOR(4L, "VENDEDOR");


    @Id
    @Column(name = "ID_CARGO")
    private Long id;

    @Column(name = "CARGO")
    private String cargo;

   // @Column(name = "ROLE")
   //  private String role;
}
