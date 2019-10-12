package com.danix43.herculesapi.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danix43.herculesapi.model.termometru.Termometru;
import com.danix43.herculesapi.model.termometru.TermometruDAO;
import com.danix43.herculesapi.repository.TermometruRepository;

@RestController
@RequestMapping("/api")
public class IoTController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TermometruRepository termometruRepo;

	@GetMapping("/termometre/all")
	public  ResponseEntity<List<Termometru>> getAll() {
		return ResponseEntity.ok(termometruRepo.findAll());
	}
	
	@GetMapping("/termometru")
	public ResponseEntity<TermometruDAO> getByName(@RequestParam(name = "name") String name) {
		Termometru databaseEntity = termometruRepo.findByName(name);
		TermometruDAO dtoEntity = modelMapper.map(databaseEntity, TermometruDAO.class);
		return ResponseEntity.ok(dtoEntity);
	}
	
	@GetMapping("/termometru/{id}/status")
	public ResponseEntity<TermometruDAO> getById(@PathVariable(name = "id") int id) {
		Termometru databaseEntity = termometruRepo.getOne(id);
		TermometruDAO daoEntity = modelMapper.map(databaseEntity, TermometruDAO.class);
		return ResponseEntity.ok(daoEntity);
	}
	
	@PostMapping(path = "/termometru/{id}/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TermometruDAO> updateById(@RequestBody TermometruDAO requestPayload, 
													@PathVariable(name = "id") int id) {
		Optional<Termometru> databaseEntity = termometruRepo.findById(id);
		if (databaseEntity.isPresent()) {
			Termometru saveEntity = modelMapper.map(requestPayload, Termometru.class);
			saveEntity.setId(id);
			saveEntity.setLastinsert(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("Z"))));
			termometruRepo.save(saveEntity);
			return ResponseEntity.ok(requestPayload);
		} else {
			Termometru saveEntity = modelMapper.map(requestPayload, Termometru.class);
			termometruRepo.save(saveEntity);
			return new ResponseEntity<TermometruDAO>(HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping(path = "/termometru/{id}/delete")
	public ResponseEntity<Termometru> deleteById(@PathVariable(name = "id") int id) {
		Optional<Termometru> databaseEntity = termometruRepo.findById(id);
		if (databaseEntity.isPresent()) {
			termometruRepo.delete(databaseEntity.get());
			return new ResponseEntity<Termometru>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Termometru>(HttpStatus.NOT_FOUND);
		}
	}
	
}








































