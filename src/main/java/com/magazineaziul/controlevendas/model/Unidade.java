package com.magazineaziul.controlevendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Unidade {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class UnidadeId implements Serializable {

        private Long idUnidade;
        private Long idGerente;

    }

    @EmbeddedId
    private UnidadeId id;

    @Column(name = "LAT_LON")
    private String latlon;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "CIDADE")
    private String cidade;

    @ManyToOne
    private Diretoria diretoria;

}
