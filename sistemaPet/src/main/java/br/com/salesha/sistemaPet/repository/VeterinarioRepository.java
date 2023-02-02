package br.com.salesha.sistemaPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salesha.sistemaPet.modelo.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer>{

}
