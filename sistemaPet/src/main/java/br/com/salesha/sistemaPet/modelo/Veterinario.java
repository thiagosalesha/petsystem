package br.com.salesha.sistemaPet.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Veterinario {
	@Id
	private int crmv;
	private String nome;
	private String especialidade;

	@OneToMany
	private List<Consulta> consult;
	
	public Veterinario() {
	}

	
	
	public Veterinario(int crmv, String nome, String especialidade) {
		this.crmv = crmv;
		this.nome = nome;
		this.especialidade = especialidade;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCrmv() {
		return crmv;
	}

	public void setCrmv(int crmv) {
		this.crmv = crmv;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}



	public List<Consulta> getConsultas() {
		return consult;
	}



	public List<Consulta> getConsult() {
		return consult;
	}



	public void setConsult(List<Consulta> consult) {
		this.consult = consult;
	}



	@Override
	public String toString() {
		return crmv + " | " + nome + " | " + especialidade;
	}



	
	
	
	
	
	
	
}
