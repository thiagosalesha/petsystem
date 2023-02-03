package br.com.salesha.sistemaPet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.salesha.sistemaPet.dto.AgendarConsultaDTO;
import br.com.salesha.sistemaPet.dto.RegistraPacienteDTO;
import br.com.salesha.sistemaPet.model.Consulta;
import br.com.salesha.sistemaPet.model.Paciente;
import br.com.salesha.sistemaPet.model.Veterinario;
import br.com.salesha.sistemaPet.repository.ConsultaRepository;
import br.com.salesha.sistemaPet.repository.PacienteRepository;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	
	@GetMapping
	public String pacienteRegistro() {
		return "/pacientes/paciente";
	}
	
	@GetMapping("/cadastro")
	public String formularioCadastro() {
		return "/pacientes/cadastroPaciente";
	}
	
	@GetMapping("/agendar")
	public String formularioAgendamento(Model model, AgendarConsultaDTO agendarConsultaDTO) {
		List<Veterinario> listaVeterinarios = veterinarioRepository.findAll();

		model.addAttribute("listaVeterinario", listaVeterinarios);
		return "/pacientes/agendamento";
	}
	
	@GetMapping("/identificacao")
	public String identificaPaciente(Model model) {

		List<Paciente> listaPaciente = pacienteRepository.findAll();

		model.addAttribute("listaPaciente", listaPaciente);

		return "/pacientes/identificaPaciente";
	}
	
	@GetMapping("/identificacaoAgenda")
	public String identificaPacienteAgenda(Model model) {

		List<Paciente> listaPaciente = pacienteRepository.findAll();

		model.addAttribute("listaPaciente", listaPaciente);

		return "/pacientes/identificaPacienteAgendamento";
	}
	

	
	@PostMapping("/consulta")
	public String consulta(RegistraPacienteDTO registraPacienteDTO, RedirectAttributes attributes) {
		System.out.println("CPF do tutor é: " + registraPacienteDTO.getCpf());
		Paciente paciente = pacienteRepository.findByCpf(registraPacienteDTO.getCpf());
		attributes.addFlashAttribute("paciente", paciente);
		return "redirect:/paciente/listaConsulta";
	}
	
	@PostMapping("/consultaAgendamento")
	public String consultaAgendamento(RegistraPacienteDTO registraPacienteDTO, RedirectAttributes attributes) {
		System.out.println("CPF do tutor é: " + registraPacienteDTO.getCpf());
		Paciente paciente = pacienteRepository.findByCpf(registraPacienteDTO.getCpf());
		attributes.addFlashAttribute("paciente", paciente);
		return "redirect:/paciente/agendar";
	}
	
	
	
	@GetMapping("/listaConsulta")
	public String listaConsulta(Model model) {
		Paciente paciente = (Paciente) model.getAttribute("paciente");
		List<Consulta> listaConsultas = consultaRepository.findByPacienteId(paciente.getId());
		model.addAttribute("listaConsulta", listaConsultas);
		return "/pacientes/consultas";
	}
	
	@PostMapping("/registraConsulta")
	public String consultaPersistencia(AgendarConsultaDTO agendarConsultaDTO)  {
		int id = 0;
		List<Paciente> findAll = pacienteRepository.findAll();
		System.out.println(agendarConsultaDTO);

		for (Paciente paciente : findAll) {
			if(paciente.getCpf().equalsIgnoreCase(agendarConsultaDTO.getCpf())) {
				id = paciente.getId();
			}
		}
		Paciente regPaciente = pacienteRepository.findById(id).get();
		Veterinario regVeterinario = veterinarioRepository
				.getReferenceById(Integer.parseInt((String) agendarConsultaDTO.getVeterinario().subSequence(0, 4)));
	
		Consulta consulta = agendarConsultaDTO.toConsulta(regVeterinario, regPaciente);
		
		consultaRepository.save(consulta);
		return "redirect:/paciente/identificacaoAgenda";		
	}
	
	
	@PostMapping("/registraPaciente")
	public String pacientePersistencia(RegistraPacienteDTO registraPacienteDto)  {
		System.out.println("CPF: " + registraPacienteDto.getCpf());
		
		Paciente paciente = registraPacienteDto.toPaciente();
		
		if(registraPacienteDto.statusPaciente(pacienteRepository, paciente)) {
			pacienteRepository.save(paciente);
			return "redirect:/paciente/identificacao";
		} else {
			return "Usuário já cadastrado";
		}
			
	}
}
