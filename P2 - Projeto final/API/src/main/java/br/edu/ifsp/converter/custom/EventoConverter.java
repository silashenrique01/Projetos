package br.edu.ifsp.converter.custom;

import org.springframework.stereotype.Service;

import br.edu.ifsp.data.model.Evento;
import br.edu.ifsp.data.vo.v2.EventoVOV2;

@Service
public class EventoConverter {
	
	public EventoVOV2 convertEntityToVO(Evento evento) {
		EventoVOV2 vo = new EventoVOV2();
		vo.setEvento_id(evento.getEvento_id());
		vo.setLocal(evento.getLocal());
		vo.setData_evento(evento.getData_evento());
		vo.setEmail(evento.getEmail());
		vo.setQuantidade_pessoas(evento.getQuantidade_pessoas());
		vo.setTelefone(evento.getTelefone());
		vo.setTema(evento.getTema());
		return vo;
	}
	
	public Evento convertVOToEntity(EventoVOV2 evento) {
		Evento entity = new Evento();
		entity.setEvento_id(evento.getEvento_id());
		entity.setEmail(evento.getEmail());
		entity.setData_evento(evento.getData_evento());
		entity.setLocal(evento.getLocal());
		entity.setQuantidade_pessoas(evento.getQuantidade_pessoas());
		entity.setTema(evento.getTema());
		entity.setTelefone(evento.getTelefone());
		return entity;
	}
}
