package com.magazineaziul.controlevendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Diretoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRETORIA")
    private Long id;

    @Column(name = "DIRETORIA")
    private String diretoria;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_DIRETORIA_USUARIO",
            joinColumns = @JoinColumn(name="ID_DIRETORIA",
                    referencedColumnName = "ID_DIRETORIA"),
            inverseJoinColumns = @JoinColumn(name = "ID_USUARIO",
                    referencedColumnName ="ID_USUARIO")
    )
    private Usuario usuario;

}
