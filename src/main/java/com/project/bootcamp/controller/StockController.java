package com.project.bootcamp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

	@Autowired
	private StockService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
		
		return ResponseEntity.ok(service.save(dto));
	
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
		
		return ResponseEntity.ok(service.update(dto));
	
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<StockDTO>> findAll(){
		List<StockDTO> lista = service.findAll();
		/*List<StockDTO> lista = new ArrayList<>();
		StockDTO dto = new StockDTO();
		dto.setId(1L);
		dto.setName("Magazine Luiza");
		dto.setPrice(100D);
		dto.setVariation(10D);
		dto.setDate(LocalDate.now());
		lista.add(dto);*/
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
		/*List<StockDTO> lista = new ArrayList<>();
		StockDTO dto1 = new StockDTO();
		dto1.setId(1L);
		dto1.setName("Magazine Luiza");
		dto1.setPrice(100D);
		dto1.setVariation(10D);
		dto1.setDate(LocalDate.now());
		lista.add(dto1);
		
		StockDTO dto2 = new StockDTO();
		dto2.setId(2L);
		dto2.setName("Ppnto Frio");
		dto2.setPrice(200D);
		dto2.setVariation(5D);
		dto2.setDate(LocalDate.now());
		lista.add(dto2);
		
		StockDTO dtoSelecionado = lista.stream().filter(x -> x.getId().compareTo(id)==0).findFirst().get();
		
		
		return ResponseEntity.ok(dtoSelecionado);
		*/
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StockDTO> delete(@PathVariable Long id){
		return ResponseEntity.ok(service.delete(id));
	}
	
	@GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<StockDTO>> findByToday(){
		return ResponseEntity.ok(service.findByToday());
	}
}
