package com.herculesapi.repositories.termometru;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herculesapi.model.termometru.Termometru;

@Repository
public interface TermometruRepository extends JpaRepository<Termometru, Integer> {
	Termometru findByName(String name);

	List<Termometru> findAllByLocation(String location);
}
