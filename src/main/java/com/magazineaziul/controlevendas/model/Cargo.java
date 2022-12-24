package com.magazineaziul.controlevendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public enum Cargo implements Serializable {

    TESTE(0L,"TESTE","TESTE"),
    DIRETORGERAL(1L, "DIRETORGERAL", "ROLE_ADMIN"),
    DIRETOR(2L, "DIRETOR","ROLE_ADMIN ROLE_DIRETOR"),
    GERENTE(3L,"GERENTE","ROLE_ADMIN ROLE_DIRETOR ROLE_GERENTE"),
    VENDEDOR(4L, "VENDEDOR","ROLE_ADMIN ROLE_DIRETOR ROLE_GERENTE ROLE_VENDEDOR");

    @Id
    @Column(name = "ID_CARGO")
    private Long id;

    @Column(name = "CARGO")
    private String cargo;

    @Column(name = "DESCRICAO")
    private String descricao;

    Cargo(Long id, String cargo, String descricao) {
        this.id = id;
        this.cargo = cargo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
