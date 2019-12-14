package com.danix43.herculesapi.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danix43.herculesapi.POJOs.TermometruPOJO;
import com.danix43.herculesapi.exceptionhandling.exceptions.EntityNotFoundException;
import com.danix43.herculesapi.model.Termometru;
import com.danix43.herculesapi.repository.TermometruRepository;

@RestController
@RequestMapping("/api")
public class IoTController {
	
	private static final Logger log = Logger.getLogger(IoTController.class.getName());
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TermometruRepository termometruRepo;

	@GetMapping("/termometre/all")
	public  ResponseEntity<List<Termometru>> getAll() {
		return ResponseEntity.ok(termometruRepo.findAll());
	}
	
	@GetMapping("/termometru")
	public ResponseEntity<TermometruPOJO> getByName(@RequestParam(name = "name") String name) {
		Termometru databaseEntity = termometruRepo.findByName(name);
		TermometruPOJO dtoEntity = modelMapper.map(databaseEntity, TermometruPOJO.class);
		return ResponseEntity.ok(dtoEntity);
	}
	
	@GetMapping("/termometru/{id}/status")
	public ResponseEntity<TermometruPOJO> getById(@PathVariable(name = "id") int id) {
		Optional<Termometru> databaseEntity = termometruRepo.findById(id);
		if (databaseEntity.isPresent()) {
			TermometruPOJO daoEntity = modelMapper.map(databaseEntity.get(), TermometruPOJO.class);
			return ResponseEntity.ok(daoEntity);	
		} else {
			throw new EntityNotFoundException("Entity with this id not found. ID: " + id);
		}
	}
	
	@PostMapping(path = "/termometru/{id}/update")
	public ResponseEntity<TermometruPOJO> updateById(@RequestBody TermometruPOJO requestPayload, 
													@PathVariable(name = "id") int id) {
		System.out.println(requestPayload);
		Optional<Termometru> databaseEntity = termometruRepo.findById(id);
		if (databaseEntity.isPresent()) {
			Termometru saveEntity = modelMapper.map(requestPayload, Termometru.class);
			saveEntity.setId(id);
			saveEntity.setLastInsert(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("Z"))));
			termometruRepo.save(saveEntity);
			return ResponseEntity.ok(requestPayload);
		} else {
			Termometru saveEntity = modelMapper.map(requestPayload, Termometru.class);
			termometruRepo.save(saveEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping(path = "/termometru/{id}/delete")
	public ResponseEntity<Termometru> deleteById(@PathVariable(name = "id") int id) {
		Optional<Termometru> databaseEntity = termometruRepo.findById(id);
		if (databaseEntity.isPresent()) {
			termometruRepo.delete(databaseEntity.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}