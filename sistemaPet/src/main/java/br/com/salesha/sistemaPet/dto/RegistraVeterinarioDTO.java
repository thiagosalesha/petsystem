package br.com.salesha.sistemaPet.dto;

import br.com.salesha.sistemaPet.model.Veterinario;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

public class RegistraVeterinarioDTO {
	
	private String nome;
	private String crmv;
	private String especialidade;
	
	
	public RegistraVeterinarioDTO(String nome, String crmv, String especialidade) {
		this.nome = nome;
		this.crmv = crmv;
		this.especialidade = especialidade;
	}


	public RegistraVeterinarioDTO() {
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCrmv() {
		return crmv;
	}


	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}


	public String getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}


	public Veterinario toVeterinario() {
		Veterinario veterinario = new Veterinario();
		veterinario.setCrmv(Integer.parseInt(crmv));
		veterinario.setEspecialidade(especialidade);
		veterinario.setNome(nome);
		
		return veterinario;
	}


	public boolean statusVeterinario(VeterinarioRepository veterinarioRepository, Veterinario veterinario) {
		if (veterinarioRepository.findByCrmv(veterinario.getCrmv()) == null) {
			return true;
		} 	
		return false;
	}
	
	

}
