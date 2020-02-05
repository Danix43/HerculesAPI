package com.herculesapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.herculesapi.model.TermometruPOJO;
import com.herculesapi.model.TermometruTrimmed;

@Service
public interface TermometruService {

	public List<TermometruPOJO> getAllTermometre();

	public void updateEntity(int id, TermometruPOJO entity);

	public void updateEntity(int id, TermometruTrimmed entity);

	public void deleteEntity(int id);

	public TermometruPOJO getTermometruByName(String name);

	public List<TermometruPOJO> getTermometruByLocation(String location);

	public TermometruPOJO getTermometruById(int id);
}
