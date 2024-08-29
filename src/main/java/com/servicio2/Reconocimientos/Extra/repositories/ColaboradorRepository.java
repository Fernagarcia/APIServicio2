package com.servicio2.Reconocimientos.Extra.repositories;

import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("SELECT c FROM Colaborador c WHERE c.puntaje >= :puntaje AND c.donacionesUltimoMes >= :donacionesUltimoMes ORDER BY c.puntaje DESC ")
    List<Colaborador> findAllByPuntajeAndDonaciones(@Param("puntaje") Double puntaje, @Param("donacionesUltimoMes") Integer donacionesUltimoMes, Pageable pageable);

}
