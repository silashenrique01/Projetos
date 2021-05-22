package br.edu.ifsp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.converter.DozerConverter;
import br.edu.ifsp.data.model.Lote;
import br.edu.ifsp.data.vo.LoteVO;
import br.edu.ifsp.exception.ResourceNotFoundException;
import br.edu.ifsp.repository.LoteRepository;

@Service
public class LoteServices {

	@Autowired
	LoteRepository loteRepository;
	
	public LoteVO create(LoteVO loteVO) {
		var entity = DozerConverter.parseObject(loteVO, Lote.class);
		var vo = DozerConverter.parseObject(loteRepository.save(entity), LoteVO.class);
		return vo;
	}
	
	public List<LoteVO> findAll(){
		return DozerConverter.parseListObjects(loteRepository.findAll(), LoteVO.class);
	}
	
	public LoteVO findById(Long id) {
		var entity = loteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		return DozerConverter.parseObject(entity, LoteVO.class);
	}
	
	public LoteVO update(LoteVO loteVO) {
		var entity = loteRepository.findById(loteVO.getLote_id()).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));		
		
		entity.setNome(loteVO.getNome());
		entity.setPreco(loteVO.getPreco());
		entity.setQuantidade(loteVO.getQuantidade());
		entity.setData_inicio(loteVO.getData_inicio());
		entity.setData_fim(loteVO.getData_fim());
		entity.setLote_id(loteVO.getLote_id());
		var vo = DozerConverter.parseObject(loteRepository.save(entity), LoteVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Lote entity = loteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
		loteRepository.delete(entity);
	}
	
}
