package com.servicio2.Reconocimientos.Extra.services;

import com.servicio2.Reconocimientos.Extra.DTOs.DTOActualizarViandas;
import com.servicio2.Reconocimientos.Extra.DTOs.DTOColaboradorSolicitado;
import com.servicio2.Reconocimientos.Extra.DTOs.DTOConsulta;
import com.servicio2.Reconocimientos.Extra.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Double.valueOf;

@Service
public class ColaboradorService {
    @Autowired
    ColaboradorRepository colaboradorRepository;

    public List<DTOColaboradorSolicitado> obtenerColaboradores(DTOConsulta consulta){
        Pageable pageable = PageRequest.of(0, consulta.getCantidadMaxADevolver());

        return colaboradorRepository.findAllByPuntajeAndDonaciones(valueOf(consulta.getMinPuntos()), consulta.getMinDonacionUltMes(), pageable);
    }

    public int actualizarColaborador(DTOActualizarViandas actualizacion) {
        return colaboradorRepository.updateViandasColaboradorById(actualizacion.getId_colaborador(), actualizacion.getCantidad_viandas());
    }
}
