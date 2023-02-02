package br.com.salesha.sistemaPet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendamentoController {
	@GetMapping("/agendar")
	public String agendar() {
		return "agendamento";
	}
	
	public String oi() {
		
	}
}
