package br.com.salesha.sistemaPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salesha.sistemaPet.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	Paciente findByCpf(String cpf);

	Paciente findByTutor(String tutor);
}
