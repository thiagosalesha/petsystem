package br.com.salesha.sistemaPet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.salesha.sistemaPet.dto.RegistraVeterinarioDTO;
import br.com.salesha.sistemaPet.model.Veterinario;
import br.com.salesha.sistemaPet.repository.ConsultaRepository;
import br.com.salesha.sistemaPet.repository.PacienteRepository;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

public class VeterinarioController {
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	
	@GetMapping("/veterinario")
	public String veterinario() {
		return "cadastroVeterinario";
	}
	
	@PostMapping("/registraVeterinario")
	public String veterinarioPersistencia(RegistraVeterinarioDTO registraVeterinarioDto) {
		System.out.println("CPF: " + registraVeterinarioDto.getCrmv());
		
		if (registraVeterinarioDto.getCrmv() == null) {
			return "oi";
		}
		
		Veterinario veterinario = registraVeterinarioDto.toVeterinario();
		
		if(registraVeterinarioDto.statusVeterinario(veterinarioRepository, veterinario)) {
			veterinarioRepository.save(veterinario);
			return "cadastroVeterinario";
		} else {
			return "Usuário já cadastrado";
		}
			
	}
}
