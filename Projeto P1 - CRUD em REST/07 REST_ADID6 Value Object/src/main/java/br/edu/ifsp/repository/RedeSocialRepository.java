package br.edu.ifsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.data.model.Evento;
import br.edu.ifsp.data.model.Lote;
import br.edu.ifsp.data.model.RedeSocial;
import br.edu.ifsp.data.vo.EventoVO;

@Repository
public interface RedeSocialRepository extends JpaRepository<RedeSocial, Long> {
	
}
