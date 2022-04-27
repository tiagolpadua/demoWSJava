package com.example.demoWSJava.coutries.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demoWSJava.coutries.dtos.CountrieDTO;
import com.example.demoWSJava.coutries.entities.Countrie;
import com.example.demoWSJava.coutries.repositories.CountrieRepository;

@Service
public class CountrieService {
	private CountrieRepository countrieRepository;

	public CountrieService(CountrieRepository countrieRepository) {
		this.countrieRepository = countrieRepository;
	}

	public CountrieDTO mapCountrie(Countrie countrie) {
		return new CountrieDTO(countrie.getId(), countrie.getName());
	}

	public List<CountrieDTO> getAllCountries() {
		var countries = countrieRepository.findAll();
		return countries.stream().map(this::mapCountrie).collect(Collectors.toList());
	}

	public Optional<Countrie> getCountrieById(Long id) {
		return countrieRepository.findById(id);
	}
}
