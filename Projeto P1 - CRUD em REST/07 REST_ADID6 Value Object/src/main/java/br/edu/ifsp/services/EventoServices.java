package br.edu.ifsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.converter.DozerConverter;
import br.edu.ifsp.data.model.Evento;
import br.edu.ifsp.data.vo.EventoVO;
import br.edu.ifsp.exception.ResourceNotFoundException;
import br.edu.ifsp.repository.EventoRepository;

@Service
public class EventoServices {

	@Autowired
	EventoRepository eventoRepository;
	
	public EventoVO create(EventoVO evento) {
		var entity = DozerConverter.parseObject(evento, Evento.class);
		var vo = DozerConverter.parseObject(eventoRepository.save(entity), EventoVO.class);
		return vo;
	}
	
	public List<EventoVO> findAll(){
		return DozerConverter.parseListObjects(eventoRepository.findAll(), EventoVO.class);
	}
	
	public EventoVO findById(Long id) {
		var entity = eventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		return DozerConverter.parseObject(entity, EventoVO.class);
	}
	
	public EventoVO update(EventoVO eventoVO) {
		var entity = eventoRepository.findById(eventoVO.getEvento_id()).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));		
		var evento = DozerConverter.parseObject(entity, Evento.class);
		
		entity.setLocal(eventoVO.getLocal());
		entity.setLotes(evento.lotes);
		entity.setTema(eventoVO.getTema());
		entity.setQuantidade_pessoas(eventoVO.getQuantidade_pessoas());
		entity.setData_evento(eventoVO.getData_evento());
		var vo = DozerConverter.parseObject(eventoRepository.save(entity), EventoVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Evento entity = eventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		eventoRepository.delete(entity);
	}
	
}
