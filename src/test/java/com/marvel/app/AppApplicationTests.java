package com.marvel.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marvel.app.daos.SuperHeroRepository;
import com.marvel.app.dto.SuperHeroDto;
import com.marvel.app.model.SuperHero;
import com.marvel.app.services.SuperHeroService;

@SpringBootTest
class AppApplicationTests {

	@Autowired
	private SuperHeroService superHeroService;

	@Autowired
	private SuperHeroRepository superHeroRepository;

	@BeforeEach
	private void init() {
		List<SuperHero> superHeroes = new LinkedList<>();
		superHeroes.add(new SuperHero("Superman"));
		superHeroes.add(new SuperHero("Spiderman"));
		superHeroes.add(new SuperHero("Capitan America"));
		
		superHeroRepository.saveAll(superHeroes);
	}
	
	@Test
	void getAllSuperHeroesTest() {
		List<SuperHeroDto> result = superHeroService.getAllSuperHeroes();
		
		assertFalse(result.isEmpty());
		assertEquals(3, result.size());
	}

	@Test
	void getSuperHeroeByIdTest() {
		SuperHeroDto result = superHeroService.getSuperHeroeById(1L);
		
		assertNotNull(result);
		assertEquals("Superman", result.getName());
	}

	@Test
	void getSuperHeroeByGennericSearchTest() {
		List<SuperHeroDto> result = superHeroService.getSuperHeroeByGennericSearch("man");
		
		assertFalse(result.isEmpty());
		assertEquals(2, result.size());
	}

	@Test
	void modifySuperSeroTest() {
		SuperHeroDto modificationDto = new SuperHeroDto();
		modificationDto.setName("He is no longer superman");
		
		SuperHeroDto result = superHeroService.modifySuperHeroTest(1L, modificationDto);
		
		assertNotNull(result);
		assertEquals("He is no longer superman", result.getName());
	}

	@Test
	void deleteSuperSeroTest() {
		superHeroService.deleteSuperHeroTest(1L);
		
		boolean exists = superHeroRepository.existsById(1L);
		assertFalse(exists);
	}
	
}