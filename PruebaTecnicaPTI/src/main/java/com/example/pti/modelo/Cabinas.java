package com.example.pti.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cabinas")
public class Cabinas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;  
	@Column(length = 50)
    private String nombre;

    @Column(length = 100)
    private String url;

	public Cabinas(String nombre, String url) {
		super();
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
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
  
    
}
