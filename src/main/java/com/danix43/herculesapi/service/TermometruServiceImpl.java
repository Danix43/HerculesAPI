package com.danix43.herculesapi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.danix43.herculesapi.exceptionhandling.EntityNotFoundException;
import com.danix43.herculesapi.model.Termometru;
import com.danix43.herculesapi.model.TermometruPOJO;
import com.danix43.herculesapi.repository.TermometruRepository;

public class TermometruServiceImpl implements TermometruService {

	@Autowired
	private TermometruRepository termometreRepo;
	
	private ModelMapper modelMapper;
	
	@Override
	public List<TermometruPOJO> getAllTermometre() {
		List<Termometru> databaseList = termometreRepo.findAll();
		Type type = new TypeToken<List<TermometruPOJO>>() {}.getType();
		return modelMapper.map(databaseList, type);
	}
	
	@Override
	public void saveToDatabase(TermometruPOJO entity) {
		termometreRepo.save(modelMapper.map(entity, Termometru.class));
	}

	@Override
	public void updateEntity(int id, TermometruPOJO entity) {
		Optional<Termometru> databaseEntity = termometreRepo.findById(id);
		if (!databaseEntity.isPresent()) {
			throw new EntityNotFoundException("Entity with this id " + id + " can not be found");
		} else {
			Termometru entityToSave = modelMapper.map(entity, Termometru.class);
			entityToSave.setId(id);
			entityToSave.setLastInsert(Timestamp.valueOf(LocalDateTime.now()));
			termometreRepo.save(entityToSave);
		}
	}

	@Override
	public void deleteEntity(int id) {
		Optional<Termometru> databaseEntity = termometreRepo.findById(id);
		if (!databaseEntity.isPresent()) {
			throw new EntityNotFoundException("Entity with this id " + id + " can not be found");
		} else {
			termometreRepo.deleteById(id);
		}
	}

	@Override
	public TermometruPOJO getTermometruByName(String name) {
		return modelMapper.map(termometreRepo.findByName(name), TermometruPOJO.class);
	}
	
	@Override
	public List<TermometruPOJO> getTermometruByLocation(String location) {
		List<Termometru> databaseList = termometreRepo.findAllByLocation(location);
		Type type = new TypeToken<List<TermometruPOJO>>() {}.getType();
		return modelMapper.map(databaseList, type);
	}
	
	@Override
	public TermometruPOJO getTermometruById(int id) { 
		Optional<Termometru> databaseEntity = termometreRepo.findById(id);
		if (!databaseEntity.isPresent()) {
			throw new EntityNotFoundException("Entity with this id " + id + " can not be found");
		} else {
			return modelMapper.map(databaseEntity, TermometruPOJO.class);
		}
	}

}
