package br.edu.ifsp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import br.edu.ifsp.data.vo.v1.EventoVO;
import br.edu.ifsp.data.vo.v2.EventoVOV2;
import br.edu.ifsp.services.EventoServices;

@RestController
@RequestMapping("/api/evento/v1")
public class EventoController {
	
	@Autowired
	private EventoServices services;
	
	@RequestMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<EventoVO> findAll() {
		List<EventoVO> eventos = services.findAll();
		eventos.stream().forEach(e->e.add(linkTo(methodOn(EventoController.class).findById(e.getEvento_id())).withSelfRel()));
		return eventos;
	}
	
	@RequestMapping(value= "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public EventoVO findById(@PathVariable("id") Long id) {
		EventoVO eventoVO = services.findById(id);
		eventoVO.add(linkTo(methodOn(EventoController.class).findById(id)).withSelfRel());
		return eventoVO;
	}
	
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, 
					consumes = {"application/json", "application/xml", "application/x-yaml"})
	public EventoVO create(@RequestBody EventoVO evento) {
		EventoVO eventoVO = services.create(evento);
		eventoVO.add(linkTo(methodOn(EventoController.class).findById(eventoVO.getEvento_id())).withSelfRel());
		return eventoVO;
	}
	
	@PostMapping("/v2")
	public EventoVOV2 createV2(@RequestBody EventoVOV2 evento) {
		return services.createV2(evento);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, 
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public EventoVO update(@RequestBody EventoVO evento) {
		EventoVO eventoVO = services.update(evento);
		eventoVO.add(linkTo(methodOn(EventoController.class).findById(eventoVO.getEvento_id())).withSelfRel());
		return eventoVO;
	}
	
}
