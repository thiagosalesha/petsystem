package br.com.salesha.sistemaPet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.salesha.sistemaPet.dto.RegistraAgendamentoDTO;
import br.com.salesha.sistemaPet.model.Consulta;
import br.com.salesha.sistemaPet.model.Veterinario;
import br.com.salesha.sistemaPet.repository.ConsultaRepository;
import br.com.salesha.sistemaPet.repository.PacienteRepository;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

@Controller
public class AgendamentoController {
	
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;

	@GetMapping("/agendar")
	public String agendar(Model model, RegistraAgendamentoDTO requisicao) {
		
		List<Veterinario> listaVet =  veterinarioRepository.findAll();
		
		for (int i = 0; i < listaVet.size(); i++) {
			
			System.out.println(listaVet.get(i));
		}
		
		model.addAttribute("listaVeterinario", listaVet);
		return "agendamento";
	}
	
	@PostMapping("/registrarConsulta")
	public String oi(RegistraAgendamentoDTO agendamento){
		
		Consulta consult = agendamento.toConsulta(veterinarioRepository, pacienteRepository);
		System.out.println("Antes da persistencia");
		consultaRepository.save(consult);
		System.out.println("Persistiu");
		return "agendamento";
	}

}
