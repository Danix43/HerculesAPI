package com.herculesapi.services.termometru;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herculesapi.exceptionhandling.errors.EntityNotFoundException;
import com.herculesapi.model.termometru.Termometru;
import com.herculesapi.model.termometru.TermometruPOJO;
import com.herculesapi.model.termometru.TermometruTrimmed;
import com.herculesapi.repositories.termometru.TermometruRepository;

@Service
public class TermometruServiceImpl implements TermometruService {

    @Autowired
    private TermometruRepository termometreRepo;

    @Autowired
    private ModelMapper modelMapper;

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
		termometruToSave = modelMapper.map(entity, Termometru.class);
	    } catch (IllegalArgumentException e) {
		throw new EntityNotFoundException();
	    }
	    termometruToSave.setTermometruId(id);
	    termometreRepo.save(termometruToSave);
	} else {
	    throw new EntityNotFoundException();
	}
    }

    @Override
    public void updateEntity(int id, TermometruTrimmed entity) {
	Optional<Termometru> termometruDatabase = termometreRepo.findById(id);
	if (termometruDatabase.isPresent()) {
	    Termometru termometruToSave = modelMapper.map(entity, Termometru.class);
	    termometruToSave.setTermometruId(id);
	    termometreRepo.save(termometruToSave);
	} else {
	    throw new EntityNotFoundException();
	}
    }

    @Override
    public void deleteEntity(int id) {
	Optional<Termometru> databaseEntity = termometreRepo.findById(id);
	if (!databaseEntity.isPresent()) {
	    throw new EntityNotFoundException();
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
	if (databaseEntity.isPresent()) {
	    return modelMapper.map(databaseEntity.get(), TermometruPOJO.class);
	} else {
	    throw new EntityNotFoundException();
	}
    }

}
