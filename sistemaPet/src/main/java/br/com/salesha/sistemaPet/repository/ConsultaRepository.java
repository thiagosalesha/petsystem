package br.com.salesha.sistemaPet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salesha.sistemaPet.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

	List<Consulta> findByVeterinarioCrmv(int crmv);

	List<Consulta> findByPacienteId(int id);

}
