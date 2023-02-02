package br.com.salesha.sistemaPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.salesha.sistemaPet.dto.RegistraPacienteDTO;
import br.com.salesha.sistemaPet.model.Paciente;
import br.com.salesha.sistemaPet.repository.ConsultaRepository;
import br.com.salesha.sistemaPet.repository.PacienteRepository;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

@Controller
public class PacienteController {
	
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	
	@GetMapping("/paciente")
	public String pacienteRegistro() {
		return "cadastroPaciente";
	}
	
	@PostMapping("/registraPaciente")
	public String pacientePersistencia(RegistraPacienteDTO registraPacienteDto) {
		System.out.println("CPF: " + registraPacienteDto.getCpf());
		
		if (registraPacienteDto.getCpf() == null) {
			return "oi";
		}
		
		Paciente paciente = registraPacienteDto.toPaciente();
		
		if(registraPacienteDto.statusPaciente(pacienteRepository, paciente)) {
			pacienteRepository.save(paciente);
			return "cadastroPaciente";
		} else {
			return "Usuário já cadastrado";
		}
			
	}
}
