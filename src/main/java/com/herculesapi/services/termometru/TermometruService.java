package com.herculesapi.services.termometru;

import java.util.List;

import org.springframework.stereotype.Service;

import com.herculesapi.model.termometru.TermometruPOJO;
import com.herculesapi.model.termometru.TermometruTrimmed;

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
