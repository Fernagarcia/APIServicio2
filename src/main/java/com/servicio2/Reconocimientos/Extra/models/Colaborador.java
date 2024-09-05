package com.servicio2.Reconocimientos.Extra.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "colaboradores")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fname")
    private String nombre;

    @Column(name = "lname")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "score")
    private Double puntaje;

    @Column(name = "viandas_donadas")
    private Integer cantViandas;
}
