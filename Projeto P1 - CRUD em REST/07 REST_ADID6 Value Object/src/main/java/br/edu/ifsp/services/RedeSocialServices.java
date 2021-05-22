package br.edu.ifsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.converter.DozerConverter;
import br.edu.ifsp.data.model.RedeSocial;
import br.edu.ifsp.data.vo.RedeSocialVO;
import br.edu.ifsp.exception.ResourceNotFoundException;
import br.edu.ifsp.repository.RedeSocialRepository;

@Service
public class RedeSocialServices {

	@Autowired
	RedeSocialRepository redeSocialRepository;
	
	public RedeSocialVO create(RedeSocialVO redeSocialVO) {
		var entity = DozerConverter.parseObject(redeSocialVO, RedeSocial.class);
		var vo = DozerConverter.parseObject(redeSocialRepository.save(entity), RedeSocialVO.class);
		return vo;
	}
	
	public List<RedeSocialVO> findAll(){
		return DozerConverter.parseListObjects(redeSocialRepository.findAll(), RedeSocialVO.class);
	}
	
	public RedeSocialVO findById(Long id) {
		var entity = redeSocialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		return DozerConverter.parseObject(entity, RedeSocialVO.class);
	}
	
	public RedeSocialVO update(RedeSocialVO redeSocialVO) {
		var entity = redeSocialRepository.findById(redeSocialVO.getRede_social_id()).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));		
		
		entity.setRede_social_id(redeSocialVO.getRede_social_id());
		entity.setNome(redeSocialVO.getNome());
		entity.setURL(redeSocialVO.getURL());

		var vo = DozerConverter.parseObject(redeSocialRepository.save(entity), RedeSocialVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		RedeSocial entity = redeSocialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		redeSocialRepository.delete(entity);
	}
	
}
