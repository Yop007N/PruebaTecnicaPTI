package com.example.pti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pti.modelo.Cabinas;
import com.example.pti.repository.RepositoryCabinas;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCabinas {

    @Autowired
    private RepositoryCabinas repositoryCabinas;

    // Obtener todos las cabinas
    public List<Cabinas> getAllCabinas() {
        return repositoryCabinas.findAll();
    }

    // Obtener una cabina por ID
    public Optional<Cabinas> getCabinasById(Long id) {
        return repositoryCabinas.findById(id);
    }

    // Crear una nueva cabina
    public Cabinas saveCabinas(Cabinas cabinas) {
        return repositoryCabinas.save(cabinas);
    }

    // Actualizar una cabina por ID
    public Cabinas updateCabinas(Long id, Cabinas updatedCabinas) {
        if (repositoryCabinas.existsById(id)) {
            updatedCabinas.setId(id);
            return repositoryCabinas.save(updatedCabinas);
        } else {
            // Manejar el caso en el que la cabina con el ID dado no existe
            return null;
        }
    }

    // Eliminar una cabina por ID
    public void deleteCabinas(Long id) {
        repositoryCabinas.deleteById(id);
    }
}
