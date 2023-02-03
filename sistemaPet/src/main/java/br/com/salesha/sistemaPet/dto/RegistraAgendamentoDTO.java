package br.com.salesha.sistemaPet.dto;

import br.com.salesha.sistemaPet.model.Consulta;
import br.com.salesha.sistemaPet.model.Paciente;
import br.com.salesha.sistemaPet.repository.PacienteRepository;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

public class RegistraAgendamentoDTO {
	private String tutor;
	private String cpfTutor;
	private int idPaciente;
	private String nomeAnimal;
	private String veterinario;
	private String data;
	

	
	public RegistraAgendamentoDTO(String tutor, String cpfTutor, int idPaciente, String nomeAnimal, String veterinario,
			String data) {
		this.tutor = tutor;
		this.cpfTutor = cpfTutor;
		this.idPaciente = idPaciente;
		this.nomeAnimal = nomeAnimal;
		this.veterinario = veterinario;
		this.data = data;
	}

	public RegistraAgendamentoDTO() {
	}
	
	public Consulta toConsulta(VeterinarioRepository veterinarioRepository, PacienteRepository pacienteRepository) {
		Consulta consulta = new Consulta();
		consulta.setData(data);
		Paciente paciente = new Paciente(idPaciente ,nomeAnimal, tutor, cpfTutor);
		System.out.println("CPF do Pacienete: " + paciente.getCpf());
		
		if (pacienteRepository.findByCpf(paciente.getCpf()) == null  && 
				pacienteRepository.findByTutor(paciente.getTutor()) == null) {
			System.out.println("Paciente Nao Existe");
			pacienteRepository.save(paciente);
			paciente = pacienteRepository.findByTutor(paciente.getTutor());
		} else{
			System.out.println("Paciente Existe");
			paciente = pacienteRepository.findByCpf(paciente.getCpf());
		}
		System.out.println("Pacienente Encontrado é: " + paciente);
		consulta.setPaciente(paciente);
		consulta.setVeterinario(veterinarioRepository.getReferenceById(Integer.parseInt(veterinario.substring(0, 4))));
		System.out.println("Passou aqui");
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

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
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

	@Override
	public String toString() {
		return "RegistraAgendamentoDTO [tutor=" + tutor + ", cpfTutor=" + cpfTutor + ", idPaciente=" + idPaciente
				+ ", nomeAnimal=" + nomeAnimal + ", veterinario=" + veterinario + ", data=" + data + "]";
	}


	
	
	
	

}
