package com.servicio2.Reconocimientos.Extra.repositories;

import com.servicio2.Reconocimientos.Extra.DTOs.DTOColaboradorSolicitado;
import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("SELECT new com.servicio2.Reconocimientos.Extra.DTOs.DTOColaboradorSolicitado(c.nombre, c.apellido, c.email, c.puntaje, c.cantViandas) " +
            "FROM Colaborador c " +
            "WHERE c.puntaje >= :puntaje and c.cantViandas >= :donacionesUltimoMes " +
            "ORDER BY c. cantViandas DESC, c.puntaje DESC")
    List<DTOColaboradorSolicitado> findAllByPuntajeAndDonaciones(
            @Param("puntaje") Double puntaje,
            @Param("donacionesUltimoMes") Integer donacionesUltimoMes,
            Pageable pageable);


    @Modifying
    @Transactional
    @Query("UPDATE Colaborador c SET c.cantViandas = :cantidad_viandas WHERE c.id = :id_colaborador")
    int updateViandasColaboradorById(@Param("id_colaborador") Integer id,
                                      @Param("cantidad_viandas") Integer cantidad);
}
