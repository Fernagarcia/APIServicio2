package com.servicio2.Reconocimientos.Extra.repositories;

import com.servicio2.Reconocimientos.Extra.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

}
