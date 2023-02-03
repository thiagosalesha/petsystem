package br.com.salesha.sistemaPet.dto;

import br.com.salesha.sistemaPet.model.Consulta;
import br.com.salesha.sistemaPet.model.Paciente;
import br.com.salesha.sistemaPet.model.Veterinario;
import br.com.salesha.sistemaPet.repository.PacienteRepository;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

public class AgendarConsultaDTO {
	private String tutor;
	private String cpf;
	private String data;
	private String veterinario;
	private String paciente;

	

	public AgendarConsultaDTO(String tutor, String cpf, String data, String veterinario, String paciente) {
		this.tutor = tutor;
		this.cpf = cpf;
		this.data = data;
		this.veterinario = veterinario;
		this.paciente = paciente;
		
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	
	public Consulta toConsulta(Veterinario veterinario, Paciente paciente) {
		Consulta cslt = new Consulta();
		cslt.setData(data);
		cslt.setPaciente(paciente);
		cslt.setVeterinario(veterinario);
		return cslt;
//		Consulta consulta = new Consulta();
//		consulta.setData(data);
//		Paciente pacient = null;
//		System.out.println("CPF do Pacienete: " + pacient.getCpf());
//		
//		if (pacienteRepository.findByCpf(pacient.getCpf()) == null  && 
//				pacienteRepository.findByTutor(pacient.getTutor()) == null) {
//			System.out.println("Paciente Nao Existe");
//			pacienteRepository.save(pacient);
//			pacient = pacienteRepository.findByTutor(pacient.getTutor());
//		} else{
//			System.out.println("Paciente Existe");
//			pacient = pacienteRepository.findByCpf(pacient.getCpf());
//		}
//		System.out.println("Pacienente Encontrado é: " + pacient);
//		consulta.setPaciente(pacient);
//		consulta.setVeterinario(veterinarioRepository.getReferenceById(Integer.parseInt(veterinario.substring(0, 4))));
//		System.out.println("Passou aqui");
//		return consulta;
	}

	@Override
	public String toString() {
		return "AgendarConsultaDTO [tutor=" + tutor + ", cpf=" + cpf + ", data=" + data + ", veterinario=" + veterinario
				+ ", paciente=" + paciente + "]";
	}
	
	

}
