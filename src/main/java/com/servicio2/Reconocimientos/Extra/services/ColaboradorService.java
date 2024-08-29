package com.servicio2.Reconocimientos.Extra.services;

import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import com.servicio2.Reconocimientos.Extra.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {
    @Autowired
    ColaboradorRepository colaboradorRepository;

    public List<Colaborador> obtenerColaboradores(){
        return colaboradorRepository.findAll();
    }

    public Colaborador guardarColaborador(Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }

    public void eliminarColaborador(Long id){
        colaboradorRepository.deleteById(id);
    }

    public void botonDeEmergencia() {
        colaboradorRepository.deleteAll();
    }
}
