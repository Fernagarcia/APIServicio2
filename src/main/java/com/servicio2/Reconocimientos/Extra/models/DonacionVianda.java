package com.servicio2.Reconocimientos.Extra.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonacionVianda {
    private Long id;

    private Long id_colaborador;

    private LocalDate fechaDonacion;

    private Long id_vianda;
}
