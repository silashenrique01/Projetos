package br.edu.ifsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.data.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	
}
