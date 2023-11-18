package com.example.pti.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "medidores")
@SequenceGenerator(name = "medidores_id_seq", sequenceName = "medidores_id_seq", allocationSize = 1)
@NoArgsConstructor  // Constructor sin argumentos para JPA
@AllArgsConstructor  // Constructor con todos los argumentos gracias a Lombok
@Getter
@Setter
public class Medidores {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medidores_id_seq")
	private Long id ;
	@Column(length = 50)
	private String serial;
	@ManyToOne
	@JoinColumn(name = "id_cabina")
	private Cabinas cabina ;
	public Medidores(String serial, String url, Cabinas cabina) {
		super();
		this.serial = serial;
		
		this.cabina = cabina;
	}
	
	public Medidores() {

}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Cabinas getCabina() {
		return cabina;
	}

	public void setCabina(Cabinas cabina) {
		this.cabina = cabina;
	}
	
}
