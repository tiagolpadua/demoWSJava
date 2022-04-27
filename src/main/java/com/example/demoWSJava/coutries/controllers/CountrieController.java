package com.example.demoWSJava.coutries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoWSJava.coutries.models.Countrie;
import com.example.demoWSJava.coutries.repositories.CoutrieRepository;

@RestController
public class CountrieController {
	private final CoutrieRepository repository;

	private record CountrieDTO(Long id, String name) {
	};

	CountrieController(CoutrieRepository repository) {
		this.repository = repository;
	}

	// http://localhost:8080/countries
	@GetMapping("/countries")
	List<CountrieDTO> all() {
		return repository
				.findAll()
				.stream()
				.map(c -> new CountrieDTO(c.getId(), c.getName()))
				.toList();
	}

	@PostMapping("/countries")
	Countrie newCountrie(@RequestBody Countrie newCountrie) {
		return repository.save(newCountrie);
	}

	@GetMapping("/countries/{id}")
	Countrie one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException(id.toString()));
	}

	@PutMapping("/countries/{id}")
	Countrie replaceCountrie(@RequestBody Countrie newCountrie, @PathVariable Long id) {
		return repository.findById(id).map(countrie -> {
			countrie.setName(newCountrie.getName());
			return repository.save(countrie);
		}).orElseGet(() -> {
			newCountrie.setId(id);
			return repository.save(newCountrie);
		});
	}

	@DeleteMapping("/countries/{id}")
	void deleteCountrie(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
