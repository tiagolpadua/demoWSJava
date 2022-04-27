package com.example.demoWSJava.coutries.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demoWSJava.coutries.dtos.CountrieDTO;
import com.example.demoWSJava.coutries.entities.Countrie;
import com.example.demoWSJava.coutries.services.CountrieService;

@RestController
public class CountrieController {
	private CountrieService countrieService;

	public CountrieController(CountrieService countrieService) {
		this.countrieService = countrieService;
	}

	// http://localhost:8080/countries
	@GetMapping("/countries")
	public List<CountrieDTO> all() {
		return countrieService.getAllCountries();
	}

	// http://localhost:8080/countries/1
	@GetMapping("/countries/{id}")
	public Countrie findById(@PathVariable Long id) {
		return countrieService.getCountrieById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
	}

//	@PostMapping("/countries")
//	Countrie newCountrie(@RequestBody Countrie newCountrie) {
//		return repository.save(newCountrie);
//	}

//	@PutMapping("/countries/{id}")
//	Countrie replaceCountrie(@RequestBody Countrie newCountrie, @PathVariable Long id) {
//		return repository.findById(id).map(countrie -> {
//			countrie.setName(newCountrie.getName());
//			return repository.save(countrie);
//		}).orElseGet(() -> {
//			newCountrie.setId(id);
//			return repository.save(newCountrie);
//		});
//	}
//
//	@DeleteMapping("/countries/{id}")
//	void deleteCountrie(@PathVariable Long id) {
//		repository.deleteById(id);
//	}
}
