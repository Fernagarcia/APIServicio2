package com.servicio2.Reconocimientos.Extra.repositories;

import com.servicio2.Reconocimientos.Extra.DTOs.DTOColaboradorSolicitado;
import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("SELECT new com.servicio2.Reconocimientos.Extra.DTOs.DTOColaboradorSolicitado(c.nombre, c.apellido, c.email, c.puntaje, COUNT(dv)) " +
            "FROM Colaborador c " +
            "LEFT JOIN DonacionVianda dv ON c.id = dv.colaborador.id " +
            "AND MONTH(dv.fechaDonacion) = (MONTH(CURDATE()) - 1) " +
            "AND YEAR(dv.fechaDonacion) = YEAR(CURDATE()) " +
            "WHERE c.puntaje >= :puntaje " +
            "GROUP BY c.id, c.nombre, c.apellido, c.puntaje " +
            "HAVING COUNT(dv) >= :donacionesUltimoMes " +
            "ORDER BY COUNT(dv) DESC, c.puntaje DESC")
    List<DTOColaboradorSolicitado> findAllByPuntajeAndDonaciones(
            @Param("puntaje") Double puntaje,
            @Param("donacionesUltimoMes") Integer donacionesUltimoMes,
            Pageable pageable);

}
