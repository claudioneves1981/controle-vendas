package com.magazineaziul.controlevendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENDA")
    private Long id;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_VENDA_USUARIO",
            joinColumns = @JoinColumn(name="ID_VENDA",
                    referencedColumnName = "ID_VENDA"),
            inverseJoinColumns = @JoinColumn(name = "ID_USUARIO",
                    referencedColumnName ="ID_USUARIO")
    )
    private Usuario usuario;

    @ManyToOne
    private Unidade unidade;

    @Column(name = "LAT_LON")
    private String latlon;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "ROAMING")
    private Boolean roaming;

    @Column(name = "VALOR")
    private BigDecimal valor;
}
