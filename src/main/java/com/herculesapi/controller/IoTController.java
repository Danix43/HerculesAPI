package com.herculesapi.controller;

import java.util.List;

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

import com.herculesapi.model.Termometru;
import com.herculesapi.model.TermometruPOJO;
import com.herculesapi.model.TermometruTrimmed;
import com.herculesapi.services.TermometruService;

@RestController
@RequestMapping("/api")
public class IoTController {

	@Autowired
	TermometruService termometruService;

	@GetMapping("/termometre/all")
	public ResponseEntity<List<TermometruPOJO>> getAll() {
		return new ResponseEntity<>(termometruService.getAllTermometre(), HttpStatus.OK);
	}

	@GetMapping("/termometru")
	public ResponseEntity<TermometruPOJO> getByName(@RequestParam(name = "name") String name) {
		return new ResponseEntity<>(termometruService.getTermometruByName(name), HttpStatus.OK);
	}

	@GetMapping("/termometru/{id}/status")
	public ResponseEntity<TermometruPOJO> getById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<>(termometruService.getTermometruById(id), HttpStatus.OK);
	}

	/**	
		Should add use the same method for different objects
		Change in TermometreServiceImpl 
	 */
	@PostMapping(path = "/termometru/{id}/update", consumes = "application/json")
	public ResponseEntity<Termometru> updateByIdUsingPojo(@RequestBody TermometruPOJO requestPayload,
			@PathVariable(name = "id") int id) {
		termometruService.updateEntity(id, requestPayload);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// @PostMapping(path = "/termometru/{id}/update", consumes = "application/json")
	// public ResponseEntity<Termometru> updateByIdUsingTrimmed(@RequestBody TermometruTrimmed requestPayload,
	// 		@PathVariable(name = "id") int id) {
	// 	termometruService.updateEntity(id, requestPayload);
	// 	return new ResponseEntity<>(HttpStatus.OK);
	// }

	@DeleteMapping(path = "/termometru/{id}/delete")
	public ResponseEntity<Termometru> deleteById(@PathVariable(name = "id") int id) {
		termometruService.deleteEntity(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}