package com.servicio2.Reconocimientos.Extra.controllers;

import com.servicio2.Reconocimientos.Extra.DTOs.DTOActualizarViandas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import com.servicio2.Reconocimientos.Extra.services.ColaboradorService;
import com.servicio2.Reconocimientos.Extra.DTOs.DTOColaboradorSolicitado;
import com.servicio2.Reconocimientos.Extra.DTOs.DTOConsulta;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ColaboradorController {
    @Autowired
    ColaboradorService colaboradorService;

    @Operation(summary = "Obtener lista de colaboradores", description = "Retorna una lista de colaboradores filtrados"
            + "por cantidad de donaciones el ultimo mes y puntos obtenidos históricamente")
    @ApiResponse(responseCode = "200", description = "Lista de colaboradores",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DTOColaboradorSolicitado.class)))

    @GetMapping("/colaboradores")
    public List<DTOColaboradorSolicitado> obtenerColaboradores(@RequestBody DTOConsulta consulta){
        return colaboradorService.obtenerColaboradores(consulta);
    }

    @PutMapping("/colaboradores/cantidad_viandas")
    public int actualizarViandasColaborador(@RequestBody DTOActualizarViandas actualizacion){
        return colaboradorService.actualizarColaborador(actualizacion);
    }
}
