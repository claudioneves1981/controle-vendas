package com.magazineaziul.controlevendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public enum Diretoria implements Serializable {

    TESTE(0L, "TESTE"),
    SEDE(1L, "SEDE"),
    SUL(2L, "SUL"),
    SUDESTE(3L, "SUDESTE"),
    CENTROOESTE(4L, "CENTRO OESTE");

    @Id
    @Column(name = "ID_DIRETORIA")
    private Long id;


    @Column(name = "DIRETORIA")
    private String diretoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiretoria() {
        return diretoria;
    }

    public void setDiretoria(String diretoria) {
        this.diretoria = diretoria;
    }




}
