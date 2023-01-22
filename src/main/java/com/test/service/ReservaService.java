package com.test.service;

import com.test.dto.ReservaCompletaDTO;
import com.test.entity.Reserva;
import com.test.dao.ReservaDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaDAO reservaDAO;

    public Reserva actualizarReserva(ReservaCompletaDTO bookingDTO){
        Reserva booking = reservaDAO.findById(bookingDTO.getIdReserva()).get();
        booking.setEstado(bookingDTO.getEstado());
        return reservaDAO.saveAndFlush(booking);
    }

    public List<Reserva> listarReservas(){
        return reservaDAO.findAll();
//        return reservaDAO.consultarReservaCompleta();
    }
    public List<ReservaCompletaDTO> listarReservasCompletas(){
        List<Object> objetos = reservaDAO.consultarReservaCompleta();
        List<ReservaCompletaDTO>reservas = new ArrayList<>();
        for(Object obj:objetos){
            System.out.println(obj);
            String aux[] = obj.toString().split(",");
            ReservaCompletaDTO dto = new ReservaCompletaDTO();
            dto.setIdReserva(Integer.parseInt(aux[0].replace("(","")));
            dto.setNombre(aux[1].replace("\"", ""));
            dto.setApellido(aux[2]);
            dto.setFechaReserva(aux[3].replace("\"", ""));
            dto.setCantidadPersonas(aux[4]);
            dto.setTipoReserva(aux[5]);
            dto.setObservaciones(aux[6]);
            dto.setEstado(aux[7].replace(")",""));
            reservas.add(dto);
        }
        return reservas;
    }
}
