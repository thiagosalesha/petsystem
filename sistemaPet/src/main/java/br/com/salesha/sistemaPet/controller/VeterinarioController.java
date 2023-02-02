package br.com.salesha.sistemaPet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.salesha.sistemaPet.dto.RegistraVeterinarioDTO;
import br.com.salesha.sistemaPet.model.Consulta;
import br.com.salesha.sistemaPet.model.Veterinario;
import br.com.salesha.sistemaPet.repository.ConsultaRepository;
import br.com.salesha.sistemaPet.repository.PacienteRepository;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
	@Autowired
	VeterinarioRepository veterinarioRepository;

	@Autowired
	ConsultaRepository consultaRepository;

	@Autowired
	PacienteRepository pacienteRepository;

	@GetMapping
	public String veterinario() {
		return "/veterinarios/veterinario";
	}

	@GetMapping("/cadastro")
	public String formularioCadastro() {
		return "/veterinarios/cadastroVeterinario";
	}

	@GetMapping("/identificacao")
	public String identificaVeterinario(Model model) {

		List<Veterinario> listaVet = veterinarioRepository.findAll();

		model.addAttribute("listaVeterinario", listaVet);

		return "/veterinarios/identificaVeterinario";
	}
	
	@PostMapping("/prontuario")
	public String prontuario(RegistraVeterinarioDTO registraVeterinarioDTO, RedirectAttributes attributes) {
		Veterinario veterinario = veterinarioRepository.findByCrmv(Integer.parseInt(registraVeterinarioDTO.getCrmv()));
		attributes.addFlashAttribute("veterinario", veterinario);
		return "redirect:/veterinario/buscaProntuario";
	}

	@GetMapping("/buscaProntuario")
	public String listaProntuario(Model model) {
		Veterinario veterinario = (Veterinario) model.getAttribute("veterinario");
		List<Consulta> listaConsultas = consultaRepository.findByVeterinarioCrmv(veterinario.getCrmv());
		model.addAttribute("listaConsulta", listaConsultas);
		return "/veterinarios/prontuarios";
	}

	@PostMapping("/registraVeterinario")
	public String veterinarioPersistencia(RegistraVeterinarioDTO registraVeterinarioDto) {
		System.out.println("CPF: " + registraVeterinarioDto.getCrmv());

		if (registraVeterinarioDto.getCrmv() == null) {
			return "oi";
		}

		Veterinario veterinario = registraVeterinarioDto.toVeterinario();

		if (registraVeterinarioDto.statusVeterinario(veterinarioRepository, veterinario)) {
			veterinarioRepository.save(veterinario);
			return "/veterinarios/cadastroVeterinario";
		} else {
			return "Usuário já cadastrado";
		}

	}
}
