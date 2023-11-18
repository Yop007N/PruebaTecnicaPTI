package com.example.pti.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cabinas")
@SequenceGenerator(name = "cabinas_id_seq", sequenceName = "cabinas_id_seq", allocationSize = 1)
@NoArgsConstructor  // Constructor sin argumentos para JPA
@AllArgsConstructor  // Constructor con todos los argumentos gracias a Lombok
@Getter
@Setter
public class Cabinas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cabinas_id_seq")
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 100)
    private String url;

    public Cabinas(String nombre, String url) {
        super();
        validarNombre(nombre);
        validarUrl(url);
        this.nombre = nombre;
        this.url = url;
    }

    public Cabinas() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        validarUrl(url);
        this.url = url;
    }

    // Métodos de validación
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
    }

    private void validarUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("La URL no puede ser nula o vacía.");
        }
    }
}
