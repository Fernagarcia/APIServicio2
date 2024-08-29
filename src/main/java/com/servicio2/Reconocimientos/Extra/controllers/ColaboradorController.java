package com.servicio2.Reconocimientos.Extra.controllers;

import com.servicio2.Reconocimientos.Extra.DTOs.DTOConsulta;
import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import com.servicio2.Reconocimientos.Extra.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    @Autowired
    ColaboradorService colaboradorService;

    @GetMapping
    public List<Colaborador> obtenerColaboradores(@RequestBody DTOConsulta consulta){
        return colaboradorService.obtenerColaboradores(consulta);
    }
}
