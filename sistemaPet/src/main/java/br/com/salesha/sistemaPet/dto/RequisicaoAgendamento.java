package br.com.salesha.sistemaPet.dto;

public class RequisicaoAgendamento {
	private String tutor;
	private String cpfTutor;
	private String nomePaciente;
	private String veterinario;
	private String data;
	
	
	
	
	public RequisicaoAgendamento(String tutor, String cpfTutor, String nomePaciente, String veterinario, String data) {
		this.tutor = tutor;
		this.cpfTutor = cpfTutor;
		this.nomePaciente = nomePaciente;
		this.veterinario = veterinario;
		this.data = data;
	}
	
	
	
	public RequisicaoAgendamento() {
	}



	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public String getCpfTutor() {
		return cpfTutor;
	}
	public void setCpfTutor(String cpfTutor) {
		this.cpfTutor = cpfTutor;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	

}
