package com.servicio2.Reconocimientos.Extra.controllers;

import com.servicio2.Reconocimientos.Extra.DTOs.DTOColaborador;
import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import com.servicio2.Reconocimientos.Extra.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    @Autowired
    ColaboradorService colaboradorService;

    @GetMapping
    public List<Colaborador> obtenerColaboradores(){
        return colaboradorService.obtenerColaboradores();
    }

    @PostMapping
    public Colaborador guardarColaborador(@RequestBody Colaborador colaborador){
        return colaboradorService.guardarColaborador(colaborador);
    }

    @DeleteMapping
    public void borrarColaborador(@RequestBody Long id){
        colaboradorService.eliminarColaborador(id);
    }

    @DeleteMapping("/matarbase")
    public void borrarColaboradores(){
        colaboradorService.botonDeEmergencia();
    }

}
