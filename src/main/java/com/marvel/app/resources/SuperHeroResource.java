package com.marvel.app.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.app.dto.SuperHeroDto;
import com.marvel.app.services.SuperHeroService;

@RestController
@RequestMapping("superHeroes")
public class SuperHeroResource {

	@Autowired
	private SuperHeroService superHeroService;

	@GetMapping("/all")
	public List<SuperHeroDto> getAllSuperHeroes() {
		return superHeroService.getAllSuperHeroes();
	}

	@GetMapping("/{id}")
	public SuperHeroDto getSuperHeroeById(@PathVariable Long id) {
		return superHeroService.getSuperHeroeById(id);
	}

	@GetMapping("/searchByName")
	public List<SuperHeroDto> getSuperHeroeByGennericSearch(@RequestParam(name = "name") String name) {
		return superHeroService.getSuperHeroeByGennericSearch(name);
	}

	@PutMapping("/new")
	public SuperHeroDto modifySuperHeroTest(@RequestBody SuperHeroDto dto) {
		return superHeroService.createSuperHero(dto);
	}

	@PutMapping("/{id}")
	public SuperHeroDto modifySuperHeroTest(@PathVariable Long id, @RequestBody SuperHeroDto dto) {
		return superHeroService.modifySuperHero(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deleteSuperSeroTest(@PathVariable Long id) {
		superHeroService.deleteSuperHero(id);
	}
}
