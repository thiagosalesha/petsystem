package br.com.salesha.sistemaPet.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Consulta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsulta;
	private String data;
	
	@ManyToOne
	private Veterinario veterinario;
	
	@ManyToOne
	private Paciente paciente;
	
	@OneToMany(mappedBy = "consulta")
	private List<Exames> exames;


	public Consulta(int idConsulta, String data, Veterinario veterinario, Paciente paciente) {
		this.idConsulta = idConsulta;
		this.data = data;
		this.veterinario = veterinario;
		this.paciente = paciente;
	}

	public Consulta() {
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Consulta [idConsulta=" + idConsulta + ", data=" + data + ", veterinario=" + veterinario + ", paciente="
				+ paciente + "]";
	}
	
	
	
	
}
