package com.test.dao;

import com.test.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

    @Query(value="SELECT public.listar_reservas()", nativeQuery = true)
    List<Object>consultarReservaCompleta();

}
