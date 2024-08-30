package com.servicio2.Reconocimientos.Extra.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "DonacionViandas")
public class DonacionVianda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @Column(name = "donation_date")
    private LocalDate fechaDonacion;

    @Column(name = "food_description")
    private String vianda;
}
