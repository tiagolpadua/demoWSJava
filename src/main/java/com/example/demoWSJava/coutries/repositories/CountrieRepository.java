package com.example.demoWSJava.coutries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoWSJava.coutries.entities.Countrie;

public interface CountrieRepository extends JpaRepository<Countrie, Long> {
	Countrie findById(long id);
}
