package com.example.pti.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pti.modelo.Medidores;
import com.example.pti.repository.RepositoryMedidores;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMedidores {

    @Autowired
    private RepositoryMedidores repositoryMedidores;

    // Método para guardar un Medidores
    public Medidores saveMedidores(Medidores medidores) {
        return repositoryMedidores.save(medidores);
    }

    // Método para obtener todos los Medidores
    public List<Medidores> getAllMedidores() {
        return repositoryMedidores.findAll();
    }

    // Método para obtener un Medidores por su ID
    public Optional<Medidores> getMedidoresById(Long id) {
        return repositoryMedidores.findById(id);
    }

    // Método para actualizar un Medidores
    public Medidores updateMedidores(Long id, Medidores updatedMedidores) {
        if (repositoryMedidores.existsById(id)) {
            updatedMedidores.setId(id);
            return repositoryMedidores.save(updatedMedidores);
        } else {
            // Manejar el caso en el que el Medidores con el ID dado no existe
            return null;
        }
    }

    // Método para eliminar un Medidores por su ID
    public void deleteMedidores(Long id) {
        repositoryMedidores.deleteById(id);
    }
}
