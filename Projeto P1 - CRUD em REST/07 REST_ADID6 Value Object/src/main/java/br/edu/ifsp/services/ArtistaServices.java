package br.edu.ifsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.converter.DozerConverter;
import br.edu.ifsp.data.model.Artista;
import br.edu.ifsp.data.vo.ArtistaVO;
import br.edu.ifsp.exception.ResourceNotFoundException;
import br.edu.ifsp.repository.ArtistaRepository;

@Service
public class ArtistaServices {

	@Autowired
	ArtistaRepository artistaRepository;
	
	public ArtistaVO create(ArtistaVO artistaVO) {
		var entity = DozerConverter.parseObject(artistaVO, Artista.class);
		var vo = DozerConverter.parseObject(artistaRepository.save(entity), ArtistaVO.class);
		return vo;
	}
	
	public List<ArtistaVO> findAll(){
		return DozerConverter.parseListObjects(artistaRepository.findAll(), ArtistaVO.class);
	}
	
	public ArtistaVO findById(Long id) {
		var entity = artistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		return DozerConverter.parseObject(entity, ArtistaVO.class);
	}
	
	public ArtistaVO update(ArtistaVO artistaVO) {
		var entity = artistaRepository.findById(artistaVO.getArtista_id()).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));		
		var artista_eventos = DozerConverter.parseObject(entity, Artista.class);
		entity.setNome(artistaVO.getNome());
		entity.setArtista_id(artistaVO.getArtista_id());
		entity.setEventos(artista_eventos.getEventos());
		entity.setEmail(artistaVO.getEmail());
		entity.setImagem_URL(artistaVO.getImagemURL());
		entity.setRedes_sociais(artista_eventos.getRedes_sociais());
		entity.setTelefone(artistaVO.getTelefone());
		var vo = DozerConverter.parseObject(artistaRepository.save(entity), ArtistaVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Artista entity = artistaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		artistaRepository.delete(entity);
	}
	
}
