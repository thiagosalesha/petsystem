package br.com.salesha.sistemaPet.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Consulta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsulta;
	private String data;
	
	@ManyToOne
	private Veterinario veterinario;
	
	@ManyToOne
	private Paciente paciente;
	
	
}
