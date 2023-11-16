package com.example.pti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pti.modelo.Cabinas;
import com.example.pti.service.ServiceCabinas;

import java.util.List;

@RestController
@RequestMapping("/cabinas")
public class RestCabinas {

    @Autowired
    private ServiceCabinas serviceCabinas;

    // Obtener todas las cabinas (GET /cabinas)
    @GetMapping
    public ResponseEntity<List<Cabinas>> getAllCabinas() {
        try {
            List<Cabinas> cabinasList = serviceCabinas.getAllCabinas();
            return new ResponseEntity<>(cabinasList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una cabina por ID (GET /cabinas/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Cabinas> getCabinasById(@PathVariable Long id) {
        try {
            return serviceCabinas.getCabinasById(id)
                    .map(cabinas -> new ResponseEntity<>(cabinas, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear una nueva cabina (POST /cabinas)
    @PostMapping
    public ResponseEntity<Cabinas> createCabinas(@RequestBody Cabinas cabinas) {
        try {
            Cabinas createdCabinas = serviceCabinas.saveCabinas(cabinas);
            return new ResponseEntity<>(createdCabinas, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una cabina por ID (PUT /cabinas/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Cabinas> updateCabinas(@PathVariable Long id, @RequestBody Cabinas updatedCabinas) {
        try {
            Cabinas updated = serviceCabinas.updateCabinas(id, updatedCabinas);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una cabina por ID (DELETE /cabinas/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCabinas(@PathVariable Long id) {
        try {
            serviceCabinas.deleteCabinas(id);
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
