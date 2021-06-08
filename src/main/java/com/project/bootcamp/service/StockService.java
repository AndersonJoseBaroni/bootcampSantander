package com.project.bootcamp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bootcamp.exceptions.BusinessException;
import com.project.bootcamp.exceptions.NotFoundException;
import com.project.bootcamp.mapper.StockMapper;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.repository.StockRepository;
import com.project.bootcamp.util.MessageUtils;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;
	
	@Autowired
	private StockMapper mapper;
	
	@Transactional
	public StockDTO save(@Valid StockDTO dto) {
		
		Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());

		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		
		Stock stock = mapper.toEntity(dto);
		
		return mapper.toDto(repository.save(stock));
	}

	@Transactional
	public StockDTO update(StockDTO dto) {
		
		Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(),dto.getId());

		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		
		Stock stock = mapper.toEntity(dto);
		
		repository.save(stock);
		
		return mapper.toDto(stock);
		
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findAll() {
		// TODO Auto-generated method stub
		
		return mapper.toDto(repository.findAll());
	}
	@Transactional(readOnly = true)
	public StockDTO findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new); 
	}

	@Transactional
	public StockDTO delete(Long id) {
		StockDTO stockDTO = this.findById(id);
		repository.deleteById(stockDTO.getId());
		return stockDTO;
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findByToday() {
		return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
	}

	
	
}
