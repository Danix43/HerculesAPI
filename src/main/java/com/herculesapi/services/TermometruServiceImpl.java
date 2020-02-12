package com.herculesapi.services;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herculesapi.exceptionhandling.EntityNotFoundException;
import com.herculesapi.model.Termometru;
import com.herculesapi.model.TermometruPOJO;
import com.herculesapi.model.TermometruTrimmed;
import com.herculesapi.repositories.TermometruRepository;

@Service
public class TermometruServiceImpl implements TermometruService {

	@Autowired
	private TermometruRepository termometreRepo;

	@Autowired
	private ModelMapper modelMapper;

	private static final String ERROR_NOTFOUND = "Entity with this id can't be found";

	@Override
	public List<TermometruPOJO> getAllTermometre() {
		List<Termometru> databaseList = termometreRepo.findAll();
		Type type = new TypeToken<List<TermometruPOJO>>() {
		}.getType();
		try {
			return modelMapper.map(databaseList, type);
		} catch (IllegalArgumentException e) {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void updateEntity(int id, TermometruPOJO entity) {
		Optional<Termometru> termometruDatabase = termometreRepo.findById(id);
		if (termometruDatabase.isPresent()) {
			Termometru termometruToSave;
			try {
				termometruToSave = modelMapper.map(entity, termometruDatabase.get().getClass());
			} catch (IllegalArgumentException e) {
				throw new EntityNotFoundException();
			}
			termometruToSave.setTermometruId(id);
			termometreRepo.save(termometruToSave);
		} else {
			throw new EntityNotFoundException(ERROR_NOTFOUND);
		}
	}

	@Override
	public void updateEntity(int id, TermometruTrimmed entity) {
		Optional<Termometru> termometruDatabase = termometreRepo.findById(id);
		if (termometruDatabase.isPresent()) {
			Termometru termometruToSave = modelMapper.map(entity, termometruDatabase.get().getClass());
			termometruToSave.setTermometruId(id);
			termometreRepo.save(termometruToSave);
		} else {
			throw new EntityNotFoundException(ERROR_NOTFOUND);
		}
	}

	@Override
	public void deleteEntity(int id) {
		Optional<Termometru> databaseEntity = termometreRepo.findById(id);
		if (!databaseEntity.isPresent()) {
			throw new EntityNotFoundException(ERROR_NOTFOUND);
		} else {
			termometreRepo.deleteById(id);
		}
	}

	@Override
	public TermometruPOJO getTermometruByName(String name) {
		try {
			return modelMapper.map(termometreRepo.findByName(name), TermometruPOJO.class);
		} catch (IllegalArgumentException e) {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public List<TermometruPOJO> getTermometruByLocation(String location) {
		List<Termometru> databaseList = termometreRepo.findAllByLocation(location);
		Type type = new TypeToken<List<TermometruPOJO>>() {
		}.getType();
		try {
			return modelMapper.map(databaseList, type);
		} catch (IllegalArgumentException e) {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public TermometruPOJO getTermometruById(int id) {
		Optional<Termometru> databaseEntity = termometreRepo.findById(id);
		if (!databaseEntity.isPresent()) {
			throw new EntityNotFoundException(ERROR_NOTFOUND);
		} else {
			return modelMapper.map(databaseEntity, TermometruPOJO.class);
		}
	}

}
