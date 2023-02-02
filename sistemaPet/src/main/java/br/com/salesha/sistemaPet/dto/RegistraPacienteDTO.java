package br.com.salesha.sistemaPet.dto;

import br.com.salesha.sistemaPet.model.Paciente;
import br.com.salesha.sistemaPet.repository.PacienteRepository;

public class RegistraPacienteDTO {
	private String tutor;
	private String cpf;
	private String nomePaciente;
	
	public RegistraPacienteDTO(String tutor, String cpf, String nomePaciente) {
		this.tutor = tutor;
		this.cpf = cpf;
		this.nomePaciente = nomePaciente;
	}

	public RegistraPacienteDTO() {
	}
	
	public Paciente toPaciente() {
		Paciente paciente = new Paciente();
		paciente.setTutor(tutor);
		paciente.setCpf(cpf);
		paciente.setNomeAnimal(nomePaciente);
		
		return paciente;
	}
	
	public boolean statusPaciente(PacienteRepository pacienteRepository, Paciente paciente) {
		if (pacienteRepository.findByCpf(paciente.getCpf()) == null) {
			return true;
		} 	
			return false;
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

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	
}
