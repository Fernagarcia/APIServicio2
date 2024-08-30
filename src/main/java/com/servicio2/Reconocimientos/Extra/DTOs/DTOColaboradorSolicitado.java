package com.servicio2.Reconocimientos.Extra.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DTOColaboradorSolicitado {
        private String nombre;
        private String apellido;
        private String email;
        private Double puntaje;
        private Long cantidadDonaciones;
}
