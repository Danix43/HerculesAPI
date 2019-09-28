package com.danix43.herculesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danix43.herculesapi.model.termometru.Termometru;

public interface TermometruRepository extends JpaRepository<Termometru, Integer> {
	Termometru findByName(String name);
}
