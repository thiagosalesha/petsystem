package br.com.salesha.sistemaPet.dto;

import br.com.salesha.sistemaPet.model.Veterinario;
import br.com.salesha.sistemaPet.repository.VeterinarioRepository;

public class RegistraVeterinarioDTO {
	
	private String nomeVet;
	private String crmv;
	private String especialidade;
	
	
	public RegistraVeterinarioDTO(String nomeVet, String crmv, String especialidade) {
		this.nomeVet = nomeVet;
		this.crmv = crmv;
		this.especialidade = especialidade;
	}


	public RegistraVeterinarioDTO() {
	}

	public String getNomeVet() {
		return nomeVet;
	}


	public void setNomeVet(String nomeVet) {
		this.nomeVet = nomeVet;
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
		veterinario.setNome(nomeVet);
		veterinario.setCrmv(Integer.parseInt(crmv));
		veterinario.setEspecialidade(especialidade);
		
		
		return veterinario;
	}


	public boolean statusVeterinario(VeterinarioRepository veterinarioRepository, Veterinario veterinario) {
		if (veterinarioRepository.findByCrmv(veterinario.getCrmv()) == null) {
			return true;
		} 	
		return false;
	}
	
	

}
