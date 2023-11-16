package com.example.pti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pti.modelo.Medidores;
import com.example.pti.service.ServiceMedidores;

import java.util.List;

@RestController
@RequestMapping("/medidores")
public class RestMedidores {

    @Autowired
    private ServiceMedidores serviceMedidores;

    @GetMapping
    public ResponseEntity<List<Medidores>> getAllMedidores() {
        try {
            List<Medidores> medidoresList = serviceMedidores.getAllMedidores();
            return new ResponseEntity<>(medidoresList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medidores> getMedidoresById(@PathVariable Long id) {
        try {
            return serviceMedidores.getMedidoresById(id)
                    .map(medidores -> new ResponseEntity<>(medidores, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Medidores> createMedidores(@RequestBody Medidores medidores) {
        try {
            Medidores createdMedidores = serviceMedidores.saveMedidores(medidores);
            return new ResponseEntity<>(createdMedidores, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medidores> updateMedidores(@PathVariable Long id, @RequestBody Medidores updatedMedidores) {
        try {
            Medidores updated = serviceMedidores.updateMedidores(id, updatedMedidores);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedidores(@PathVariable Long id) {
        try {
            serviceMedidores.deleteMedidores(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Manejo de errores generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


