package br.com.salesha.sistemaPet.dto;

import br.com.salesha.sistemaPet.model.Consulta;
import br.com.salesha.sistemaPet.model.Paciente;
import br.com.salesha.sistemaPet.repository.PacienteRepository;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

public class RequisicaoAgendamento {
	private String tutor;
	private String cpfTutor;
	private String nomePaciente;
	private String veterinario;
	private String data;
	

	public RequisicaoAgendamento(String tutor, String cpfTutor, String nomePaciente, String data,
			String veterinario) {
		this.tutor = tutor;
		this.cpfTutor = cpfTutor;
		this.nomePaciente = nomePaciente;
		this.data = data;
		this.veterinario = veterinario;
		
	}

	public RequisicaoAgendamento() {
	}
	
	public Consulta toConsulta(VeterinarioRepository veterinarioRepository, PacienteRepository pacienteRepository) {
		Consulta consulta = new Consulta();
		consulta.setData(data);
		Paciente paciente = new Paciente(nomePaciente, tutor, cpfTutor);
		if (pacienteRepository.findByCpf(paciente.getCpf()) == null) {
			pacienteRepository.save(paciente);
		}
		consulta.setPaciente(paciente);
		consulta.setVeterinario(veterinarioRepository.getReferenceById(Integer.parseInt(veterinario.substring(0, 4))));
		System.out.println("Passou aqui");
		pacienteRepository.flush();
		return consulta;
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
