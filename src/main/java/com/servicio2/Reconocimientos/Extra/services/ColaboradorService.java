package com.servicio2.Reconocimientos.Extra.services;

import com.servicio2.Reconocimientos.Extra.DTOs.DTOActualizarViandas;
import com.servicio2.Reconocimientos.Extra.DTOs.DTOColaboradorSolicitado;
import com.servicio2.Reconocimientos.Extra.DTOs.DTOConsulta;
import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import com.servicio2.Reconocimientos.Extra.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Double.valueOf;

@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public List<DTOColaboradorSolicitado> obtenerColaboradores(Integer minPuntos, Integer minViandas, Integer cantidad){
        Pageable pageable = PageRequest.of(0, cantidad);

        return colaboradorRepository.findAllByPuntajeAndDonaciones(valueOf(minPuntos), minViandas, pageable);
    }

    public int actualizarColaborador(DTOActualizarViandas actualizacion) {
        return colaboradorRepository.updateViandasColaboradorById(actualizacion.getId_colaborador(), actualizacion.getCantidad_viandas());
    }

    public List<Colaborador> obtenerTodos(){
        return colaboradorRepository.findAll();
    }
}
