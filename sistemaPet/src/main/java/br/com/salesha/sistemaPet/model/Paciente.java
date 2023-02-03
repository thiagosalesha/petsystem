package br.com.salesha.sistemaPet.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Paciente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeAnimal;
	private String tutor;
	private String cpf;
	
	@OneToMany(mappedBy = "paciente")
	private List<Exames> exames;
	
	
	
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;
	
	
	public Paciente(String nomeAnimal, String tutor, String cpf) {
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


	public List<Exames> getExames() {
		return exames;
	}


	public void setExames(List<Exames> exames) {
		this.exames = exames;
	}

	
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nomeAnimal=" + nomeAnimal + ", tutor=" + tutor + ", cpf=" + cpf
				+ ", consultas=" + consultas + "]";
	}
	
	

}
