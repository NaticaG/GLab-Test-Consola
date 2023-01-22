package com.test.controller;

import com.test.dto.ReservaCompletaDTO;
import com.test.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/booking")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
  
    @PutMapping(value="/update")
    public ResponseEntity<?> actualizarReserva(@RequestBody ReservaCompletaDTO booking){
        System.out.println("actualizarReserva");
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.actualizarReserva(booking));
    }

    @GetMapping
    public ResponseEntity<?> listarReservas(){
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.listarReservas());
    }
    @GetMapping(value="/res")
    public ResponseEntity<?> listarReservasCompletas(){
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.listarReservasCompletas());
    }
}
