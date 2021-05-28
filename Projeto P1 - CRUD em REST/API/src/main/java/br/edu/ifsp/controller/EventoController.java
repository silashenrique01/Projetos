package br.edu.ifsp.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.data.model.Evento;
import br.edu.ifsp.data.vo.EventoVO;
import br.edu.ifsp.services.EventoServices;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoServices services;
	
	@GetMapping
	public List<EventoVO> findAll(){
		
		return services.findAll();
	}
	
	@GetMapping("/{id}")
	public EventoVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	@PostMapping
	public EventoVO create(@RequestBody EventoVO evento) {
		return services.create(evento);
	}
	
	@PutMapping
	public EventoVO update(@RequestBody EventoVO evento) {
		return services.update(evento);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
	

}
