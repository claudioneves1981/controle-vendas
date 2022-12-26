package com.magazineaziul.controlevendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public enum Unidade {

    TESTE(0L, "-30.048750057541955, -51.228587422990806"),
    SEDE(1L, "-30.048750057541955, -51.228587422990806"),
    PORTOALEGRE(2L, "-30.048750057541955, -51.228587422990806"),
    FLORIANOPOLIS(3L, "-27.5539352507396, -48,49841515885026"),
    CURITIBA(4L,"-25.473704465731746, -49.24787198992874"),
    SAOPAULO(5L,"-23,544259437612844, -46,64370714029131"),
    RIODEJANEIRO(6L,"-22.923447510604802,-43.23208495438858"),
    BELOHORIZONTE(7L,"-19,917854829716372,-43,94089385954766"),
    VITORIA(8L, "-20.340992420772206, -40.3833271475097"),
    CAMPOGRANDE(9L, "-20.462652006300377,-54.615658937666645"),
    GOIANIA(10L, "-16.673126240814387,-49.25248826354209"),
    CUIABA(11L, "-15.601754458320842, -56.09832706558089");


    @Id
    @Column(name = "ID_UNIDADE")
    private Long id;

    @Column(name = "LATLON")
    private String latlon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatlon() {
        return latlon;
    }

    public void setLatlon(String latlon) {
        this.latlon = latlon;
    }

}
