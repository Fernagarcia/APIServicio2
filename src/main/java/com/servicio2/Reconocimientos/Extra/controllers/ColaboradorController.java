package com.servicio2.Reconocimientos.Extra.controllers;

import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import com.servicio2.Reconocimientos.Extra.services.ColaboradorService;
import com.servicio2.Reconocimientos.Extra.DTOs.DTOColaboradorSolicitado;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ColaboradorController {
    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @Operation(summary = "Mostrar todos los colaboradores", description = "Todos los colaboradores")
    @ApiResponse(responseCode = "200", description = "Lista de colaboradores",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Colaborador.class)))
    @GetMapping
    public List<Colaborador> inicio(){
        return colaboradorService.obtenerTodos();
    }

    @Operation(summary = "Obtener lista de colaboradores en base a parametros",
            description = "Retorna una lista de colaboradores filtrados "
            + "por cantidad de donaciones el ultimo mes y puntos obtenidos históricamente")
    @ApiResponse(responseCode = "200", description = "Lista de colaboradores",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DTOColaboradorSolicitado.class)))
    @GetMapping("/colaboradores")
    public List<DTOColaboradorSolicitado> obtenerColaboradores(@RequestParam Integer minPuntos,
                                                               @RequestParam Integer minDonacionUltMes,
                                                               @RequestParam Integer cantidadMaxADevolver){
        return colaboradorService.obtenerColaboradores(minPuntos, minDonacionUltMes, cantidadMaxADevolver);
    }
}
