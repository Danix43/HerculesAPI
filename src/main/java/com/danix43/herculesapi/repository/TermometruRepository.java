package com.danix43.herculesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danix43.herculesapi.model.Termometru;

@Repository
public interface TermometruRepository extends JpaRepository<Termometru, Integer> {
	Termometru findByName(String name);
}
