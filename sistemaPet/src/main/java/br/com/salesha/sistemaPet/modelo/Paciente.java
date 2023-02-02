package br.com.salesha.sistemaPet.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paciente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeAnimal;
	private String tutor;
	private String cpf;
	
	@OneToMany
	private List<Consulta> consultas;
	
	
	public Paciente(int id, String nomeAnimal, String tutor, String cpf) {
		this.id = id;
		this.nomeAnimal = nomeAnimal;
		this.tutor = tutor;
		this.cpf = cpf;
	}


	public Paciente() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomeAnimal() {
		return nomeAnimal;
	}


	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}


	public String getTutor() {
		return tutor;
	}


	public void setTutor(String tutor) {
		this.tutor = tutor;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public List<Consulta> getConsultas() {
		return consultas;
	}


	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
	

}
