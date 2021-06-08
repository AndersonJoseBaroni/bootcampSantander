package com.project.bootcamp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;

@Component
public class StockMapper {

	public Stock toEntity(StockDTO dto) {
		Stock stock = new Stock();
		stock.setId(dto.getId());
		stock.setName(dto.getName());
		stock.setDate(dto.getDate());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		return stock;
		
	}
	
	public StockDTO toDto(Stock model) {
		StockDTO stock = new StockDTO();
		stock.setId(model.getId());
		stock.setName(model.getName());
		stock.setDate(model.getDate());
		stock.setPrice(model.getPrice());
		stock.setVariation(model.getVariation());
		return stock;
		
	}

	public List<StockDTO> toDto(List<Stock> listStock) {
		// TODO Auto-generated method stub
		
		return listStock.stream().map(this::toDto).collect(Collectors.toList());
	}
	
}
