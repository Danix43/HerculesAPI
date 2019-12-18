package com.danix43.herculesapi.service;

import java.util.List;

import com.danix43.herculesapi.model.Termometru;
import com.danix43.herculesapi.model.TermometruPOJO;

public interface TermometruService  {
	
	public List<TermometruPOJO> getAllTermometre();
	public void saveToDatabase(Termometru entity);
	public void updateEntity(int id, TermometruPOJO entity);
	public void deleteEntity(int id);
	public TermometruPOJO getTermometruByName(String name);
	public List<TermometruPOJO> getTermometruByLocation(String location);
	public TermometruPOJO getTermometruById(int id);
}
