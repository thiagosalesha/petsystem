package br.com.salesha.sistemaPet.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.salesha.sistemaPet.dto.RequisicaoAgendamento;
import br.com.salesha.sistemaPet.modelo.Veterinario;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

@Controller
public class AgendamentoController {
	
	@Autowired
	VeterinarioRepository veterinarioRepository;

	@GetMapping("/agendar")
	public String agendar(Model model, RequisicaoAgendamento requisicao) {
		
		List<Veterinario> listaVet =  veterinarioRepository.findAll();
		
		for (int i = 0; i < listaVet.size(); i++) {
			
			System.out.println(listaVet.get(i));
		}
		
		model.addAttribute("listaVeterinario", listaVet);
		return "agendamento";
	}
	
	@PostMapping("/enviar")
	public String oi(RequisicaoAgendamento agendamento){
		System.out.println(agendamento.getTutor());
		return "teste";
	}

}
