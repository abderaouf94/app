package com.marvel.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.marvel.app.daos.SuperHeroRepository;
import com.marvel.app.dto.SuperHeroDto;
import com.marvel.app.model.SuperHero;
import com.marvel.app.services.SuperHeroService;

@SpringBootTest
@Transactional
@TestInstance(Lifecycle.PER_CLASS)
class AppApplicationTests {

	@Autowired
	private SuperHeroService superHeroService;

	@Autowired
	private SuperHeroRepository superHeroRepository;

	@BeforeAll
	private void init() {
		List<SuperHero> superHeroes = new LinkedList<>();
		superHeroes.add(new SuperHero("Superheroe1 Marvel"));
		superHeroes.add(new SuperHero("Superheroe2 Marvel"));
		superHeroes.add(new SuperHero("Superheroe3 DC"));

		superHeroRepository.saveAll(superHeroes);
	}

	@Test
	public void getAllSuperHeroesTest() {
		List<SuperHeroDto> result = superHeroService.getAllSuperHeroes();

		assertFalse(result.isEmpty());
		assertEquals(3, result.size());
	}

	@Test
	public void getSuperHeroeByIdTest() {
		SuperHeroDto result = superHeroService.getSuperHeroeById(1L);

		assertNotNull(result);
		assertEquals("Superheroe1 Marvel", result.getName());
	}

	@Test
	public void getSuperHeroeByGennericSearchTest() {
		List<SuperHeroDto> result = superHeroService.getSuperHeroeByGennericSearch("Marvel");

		assertFalse(result.isEmpty());
		assertEquals(2, result.size());
	}

	@Test
	public void createSuperHeroTest() {
		SuperHeroDto modificationDto = new SuperHeroDto();
		modificationDto.setName("New super hero");

		SuperHeroDto result = superHeroService.createSuperHero(modificationDto);

		assertNotNull(result);
		assertEquals("New super hero", result.getName());
	}

	@Test
	public void modifySuperHeroTest() {
		SuperHero superHero = new SuperHero("Superheroe1 Marvel");
		superHeroRepository.save(superHero);

		SuperHeroDto modificationDto = new SuperHeroDto();
		modificationDto.setName("He is no longer superman");

		SuperHeroDto result = superHeroService.modifySuperHero(1L, modificationDto);

		assertNotNull(result);
		assertEquals("He is no longer superman", result.getName());
	}

	@Test
	public void deleteSuperHeroTest() {
		superHeroService.deleteSuperHero(1L);

		boolean exists = superHeroRepository.existsById(1L);
		assertFalse(exists);
	}
}