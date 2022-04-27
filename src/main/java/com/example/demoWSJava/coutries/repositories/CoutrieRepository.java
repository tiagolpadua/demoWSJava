package com.example.demoWSJava.coutries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoWSJava.coutries.models.Countrie;

public interface CoutrieRepository extends JpaRepository<Countrie, Long> {
	Countrie findById(long id);
}
