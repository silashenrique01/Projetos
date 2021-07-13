package br.edu.ifsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.converter.DozerConverter;
import br.edu.ifsp.converter.custom.EventoConverter;
import br.edu.ifsp.data.model.Evento;
import br.edu.ifsp.data.vo.v1.EventoVO;
import br.edu.ifsp.data.vo.v2.EventoVOV2;
import br.edu.ifsp.exception.ResourceNotFoundException;
import br.edu.ifsp.repository.EventoRepository;

@Service
public class EventoServices {
	
	@Autowired
	EventoRepository repository;
	
	@Autowired
	EventoConverter converter;
	
	public EventoVO create(EventoVO evento) {
		var entity = DozerConverter.parseObject(evento, Evento.class);
		var vo = DozerConverter.parseObject(repository.save(entity), EventoVO.class);
		//var == PersonVO nesse caso
		return vo;
	}
	
	public EventoVOV2 createV2(EventoVOV2 evento) {
		var entity = converter.convertVOToEntity(evento);
		var vo = converter.convertEntityToVO(repository.save(entity));
		return vo;
	}
	
	public List<EventoVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), EventoVO.class);
	}
	
	public EventoVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		return DozerConverter.parseObject(entity, EventoVO.class);
	}
	
	public EventoVO update(EventoVO evento) {
		var entity = repository.findById(evento.getEvento_id())
				.orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		
		entity.setEmail(evento.getEmail());
		entity.setLocal(evento.getLocal());
		entity.setQuantidade_pessoas(evento.getQuantidade_pessoas());
		entity.setTelefone(evento.getTelefone());
		entity.setTema(evento.getTema());
		entity.setData_evento(evento.getData_evento());
		
		var vo = DozerConverter.parseObject(repository.save(entity), EventoVO.class);
		return vo;
	}
	
	
	public void delete(Long id) {
		Evento entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		repository.delete(entity);
	}
	
	
}
